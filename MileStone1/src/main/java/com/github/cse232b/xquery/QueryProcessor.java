package com.github.cse232b.xquery;

import com.github.cse232b.gen.*;
import com.github.cse232b.subexpr.SubExpression;
import com.github.cse232b.subquery.*;
import com.github.cse232b.xpath.ExpressionProcessor;
import com.github.cse232b.xpath.XPathProcessor;
import com.sun.jdi.ArrayReference;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.management.Query;
import java.util.*;


public class QueryProcessor extends XQueryGrammarBaseVisitor<SubQuery>{
    private final Document doc;
    private final XPathProcessor xPathProcessor;
    private final ExpressionProcessor exprProcessor;
    private Map<String, List<Node>> ctxMap;
    private final Stack<Map<String, List<Node>>> ctxStack;
    public QueryProcessor(Document doc) throws Exception {
        if (doc == null) {
            throw new NullPointerException("Document is null" + this);
        }
        this.doc = doc;
        this.xPathProcessor = new XPathProcessor();
        this.exprProcessor = new ExpressionProcessor();
        this.ctxMap = new HashMap<>();
        this.ctxStack = new Stack<>();
    }

    @Override
    public SubQuery visitStringXq(XQueryGrammarParser.StringXqContext ctx) {
        String trimmed = ctx.String().getText();
        trimmed = trimmed.substring(1, trimmed.length() - 1);
        return new StringXq(trimmed);
    }

    @Override
    public SubQuery visitApXq(XQueryGrammarParser.ApXqContext ctx) {
        List<Node> list = new ArrayList<>();
        try {
            list = this.xPathProcessor.evaluate(ctx.ap().getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ApXq(list);
    }

    @Override
    public SubQuery visitBinarySlashXq(XQueryGrammarParser.BinarySlashXqContext ctx) {
        SubQuery xq = visit(ctx.xq());
        String rpText = ctx.rp().getText();
        SubExpression rp = this.exprProcessor.visit(xPathProcessor.createGrammarParser(rpText).rp());
        return new BinaryRpXq(xq, rp, SubQuery.QueryType.BinarySlashXq);
    }

    @Override
    public SubQuery visitVarXq(XQueryGrammarParser.VarXqContext ctx) {
        return new VarXq(ctxMap.get(ctx.VAR().getText()));
    }

    @Override
    public SubQuery visitLetXq(XQueryGrammarParser.LetXqContext ctx) {
        letBind(ctx.let().VAR(), ctx.let().xq());
        SubQuery xq = visit(ctx.xq());
        letUnbind(ctx.let().VAR().size());
        return xq;
    }

    @Override
    public SubQuery visitBinaryDslashXq(XQueryGrammarParser.BinaryDslashXqContext ctx) {
        SubQuery xq = visit(ctx.xq());
        String rpText = ctx.rp().getText();
        SubExpression rp = this.exprProcessor.visit(xPathProcessor.createGrammarParser(rpText).rp());
        return new BinaryRpXq(xq, rp, SubQuery.QueryType.BinaryDslashXq);
    }

    @Override
    public SubQuery visitBinaryCombineXq(XQueryGrammarParser.BinaryCombineXqContext ctx) {
        SubQuery xq1 = visit(ctx.xq(0));
        SubQuery xq2 = visit(ctx.xq(1));
        return new BinaryXq(xq1, xq2);
    }

    // Find result Nodes of forXq recursively (backtracking)
    private void forXqHandler(int idx, int size, XQueryGrammarParser.ForXqContext ctx, List<Node> res) throws Exception {
        if (idx == size) {
            if (ctx.let() != null) {
                letBind(ctx.let().VAR(), ctx.let().xq());
            }
            if (ctx.where() != null && visit(ctx.where().cond()).evaluate(this.doc) != null || ctx.where() == null) {
                res.addAll(visit(ctx.return_().xq()).evaluate(this.doc));
            }
            if (ctx.let() != null) {
                letUnbind(ctx.let().VAR().size());
            }
            return;
        }
        List<Node> xqResNodes = visit(ctx.for_().xq(idx)).evaluate(this.doc);
        String varName = ctx.for_().VAR(idx).getText();
        for (Node node: xqResNodes) {
            Map<String, List<Node>> oldMap = new HashMap<>(this.ctxMap);
            ctxMap.put(varName, List.of(node));
            ctxStack.push(oldMap);
            forXqHandler(idx + 1, size, ctx, res);
            ctxMap = ctxStack.pop();
        }
    }

    @Override
    public SubQuery visitForXq(XQueryGrammarParser.ForXqContext ctx) {
        List<Node> res = new ArrayList<>();
        try {
            forXqHandler(0, ctx.for_().VAR().size(), ctx, res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new VarXq(res);
    }

    @Override
    public SubQuery visitTagXq(XQueryGrammarParser.TagXqContext ctx) {
        String tagName = ctx.Name(0).getText();
        SubQuery xq = visit(ctx.xq());
        return new TagXq(tagName, xq);
    }

    @Override
    public SubQuery visitParenthXq(XQueryGrammarParser.ParenthXqContext ctx) {
        SubQuery xq = visit(ctx.xq());
        return new ParenthXq(xq);
    }

    @Override
    public SubQuery visitFor(XQueryGrammarParser.ForContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitLet(XQueryGrammarParser.LetContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitWhere(XQueryGrammarParser.WhereContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitReturn(XQueryGrammarParser.ReturnContext ctx) {
        return visitChildren(ctx);
    }

    // Cond1 or Cond2
    @Override
    public SubQuery visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        SubQuery c1 = visit(ctx.cond(0));
        SubQuery c2 = visit(ctx.cond(1));
        return new BinaryCond(c1, c2, SubQuery.QueryType.OrCond);
    }

    @Override
    public SubQuery visitEmpCond(XQueryGrammarParser.EmpCondContext ctx) {
        SubQuery q = visit(ctx.xq());
        return new SingleCond(q, SubQuery.QueryType.EmpCond);
    }

    // Cond1 and Cond2
    @Override
    public SubQuery visitAndCond(XQueryGrammarParser.AndCondContext ctx) {
        SubQuery c1 = visit(ctx.cond(0));
        SubQuery c2 = visit(ctx.cond(1));
        return new BinaryCond(c1, c2, SubQuery.QueryType.AndCond);
    }

    @Override
    public SubQuery visitParenthCond(XQueryGrammarParser.ParenthCondContext ctx) {
        return visit(ctx.cond());
    }

    private void letBind(List<TerminalNode> variables, List<XQueryGrammarParser.XqContext> queries) {
        if(null == variables || null == queries || variables.size() != queries.size()) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < variables.size(); i++) {
            try {
                String varName = variables.get(i).getText();
                List<Node> valueList = visit(queries.get(i)).evaluate(this.doc);
                Map<String, List<Node>> oldMap = new HashMap<>(this.ctxMap);
                this.ctxMap.put(varName, valueList);
                this.ctxStack.push(oldMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void letUnbind(int num) {
        if(num < 0 || num > this.ctxStack.size()) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < num; i++) {
            this.ctxMap = this.ctxStack.pop();
        }
    }

    // satisfy
    @Override
    public SubQuery visitSatCond(XQueryGrammarParser.SatCondContext ctx) {
        this.letBind(ctx.VAR(), ctx.xq());

        SubQuery finalCond = visit(ctx.cond());
        SubQuery condQuery = null;
        try {
            condQuery = new SatCond(finalCond.evaluate(this.doc));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.letUnbind(ctx.VAR().size());
        }
        return condQuery;
    }

    // not Cond1
    @Override
    public SubQuery visitNotCond(XQueryGrammarParser.NotCondContext ctx) {
        SubQuery q = visit(ctx.cond());
        return new SingleCond(q, SubQuery.QueryType.NotCond);
    }

    // XQ1 == XQ2 | XQ1 is XQ2
    @Override
    public SubQuery visitBinaryIsCond(XQueryGrammarParser.BinaryIsCondContext ctx) {
        SubQuery q1 = visit(ctx.xq(0));
        SubQuery q2 = visit(ctx.xq(1));
        return new BinaryCond(q1, q2, SubQuery.QueryType.BinaryIsCond);
    }

    // XQ1 = XQ2 | XQ1 eq XQ2 |
    @Override
    public SubQuery visitBinaryEqualCond(XQueryGrammarParser.BinaryEqualCondContext ctx) {
        SubQuery q1 = visit(ctx.xq(0));
        SubQuery q2 = visit(ctx.xq(1));
        return new BinaryCond(q1, q2, SubQuery.QueryType.BinaryEqualCond);
    }

    @Override
    public SubQuery visitSlashAp(XQueryGrammarParser.SlashApContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitDslashAp(XQueryGrammarParser.DslashApContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleParentRp(XQueryGrammarParser.SingleParentRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryCombineRp(XQueryGrammarParser.BinaryCombineRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryDslashRp(XQueryGrammarParser.BinaryDslashRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleAttrRp(XQueryGrammarParser.SingleAttrRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleTextRp(XQueryGrammarParser.SingleTextRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleSelfRp(XQueryGrammarParser.SingleSelfRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinarySlashRp(XQueryGrammarParser.BinarySlashRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitFilterRp(XQueryGrammarParser.FilterRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleParenthRp(XQueryGrammarParser.SingleParenthRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleStarRp(XQueryGrammarParser.SingleStarRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitSingleTagRp(XQueryGrammarParser.SingleTagRpContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryOrF(XQueryGrammarParser.BinaryOrFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitRpEqualStringF(XQueryGrammarParser.RpEqualStringFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitNegF(XQueryGrammarParser.NegFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryEqualRpF(XQueryGrammarParser.BinaryEqualRpFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryIsRpF(XQueryGrammarParser.BinaryIsRpFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitRpF(XQueryGrammarParser.RpFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitParenthF(XQueryGrammarParser.ParenthFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitBinaryAndF(XQueryGrammarParser.BinaryAndFContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public SubQuery visitDoc(XQueryGrammarParser.DocContext ctx) {
        return visitChildren(ctx);
    }
}
