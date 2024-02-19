package com.github.cse232b.xquery;

import com.github.cse232b.gen.*;
import com.github.cse232b.subquery.SubQuery;
import com.github.cse232b.xpath.ExpressionProcessor;
import com.github.cse232b.xpath.XPathProcessor;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

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
        return super.visitStringXq(ctx);
    }

    @Override
    public SubQuery visitApXq(XQueryGrammarParser.ApXqContext ctx) {
        return super.visitApXq(ctx);
    }

    @Override
    public SubQuery visitBinarySlashXq(XQueryGrammarParser.BinarySlashXqContext ctx) {
        return super.visitBinarySlashXq(ctx);
    }

    @Override
    public SubQuery visitVarXq(XQueryGrammarParser.VarXqContext ctx) {
        return super.visitVarXq(ctx);
    }

    @Override
    public SubQuery visitLetXq(XQueryGrammarParser.LetXqContext ctx) {
        return super.visitLetXq(ctx);
    }

    @Override
    public SubQuery visitBinaryDslashXq(XQueryGrammarParser.BinaryDslashXqContext ctx) {
        return super.visitBinaryDslashXq(ctx);
    }

    @Override
    public SubQuery visitBinaryCombineXq(XQueryGrammarParser.BinaryCombineXqContext ctx) {
        return super.visitBinaryCombineXq(ctx);
    }

    @Override
    public SubQuery visitForXq(XQueryGrammarParser.ForXqContext ctx) {
        return super.visitForXq(ctx);
    }

    @Override
    public SubQuery visitTagXq(XQueryGrammarParser.TagXqContext ctx) {
        return super.visitTagXq(ctx);
    }

    @Override
    public SubQuery visitParenthXq(XQueryGrammarParser.ParenthXqContext ctx) {
        return super.visitParenthXq(ctx);
    }

    @Override
    public SubQuery visitFor(XQueryGrammarParser.ForContext ctx) {
        return super.visitFor(ctx);
    }

    @Override
    public SubQuery visitLet(XQueryGrammarParser.LetContext ctx) {
        return super.visitLet(ctx);
    }

    @Override
    public SubQuery visitWhere(XQueryGrammarParser.WhereContext ctx) {
        return super.visitWhere(ctx);
    }

    @Override
    public SubQuery visitReturn(XQueryGrammarParser.ReturnContext ctx) {
        return super.visitReturn(ctx);
    }

    @Override
    public SubQuery visitOrCond(XQueryGrammarParser.OrCondContext ctx) {
        return super.visitOrCond(ctx);
    }

    @Override
    public SubQuery visitEmpCond(XQueryGrammarParser.EmpCondContext ctx) {
        return super.visitEmpCond(ctx);
    }

    @Override
    public SubQuery visitAndCond(XQueryGrammarParser.AndCondContext ctx) {
        return super.visitAndCond(ctx);
    }

    @Override
    public SubQuery visitParenthCond(XQueryGrammarParser.ParenthCondContext ctx) {
        return super.visitParenthCond(ctx);
    }

    @Override
    public SubQuery visitSatCond(XQueryGrammarParser.SatCondContext ctx) {
        return super.visitSatCond(ctx);
    }

    @Override
    public SubQuery visitNotCond(XQueryGrammarParser.NotCondContext ctx) {
        return super.visitNotCond(ctx);
    }

    @Override
    public SubQuery visitBinaryIsCond(XQueryGrammarParser.BinaryIsCondContext ctx) {
        return super.visitBinaryIsCond(ctx);
    }

    @Override
    public SubQuery visitBinaryEqualCond(XQueryGrammarParser.BinaryEqualCondContext ctx) {
        return super.visitBinaryEqualCond(ctx);
    }

    @Override
    public SubQuery visitSlashAp(XQueryGrammarParser.SlashApContext ctx) {
        return super.visitSlashAp(ctx);
    }

    @Override
    public SubQuery visitDslashAp(XQueryGrammarParser.DslashApContext ctx) {
        return super.visitDslashAp(ctx);
    }

    @Override
    public SubQuery visitSingleParentRp(XQueryGrammarParser.SingleParentRpContext ctx) {
        return super.visitSingleParentRp(ctx);
    }

    @Override
    public SubQuery visitBinaryCombineRp(XQueryGrammarParser.BinaryCombineRpContext ctx) {
        return super.visitBinaryCombineRp(ctx);
    }

    @Override
    public SubQuery visitBinaryDslashRp(XQueryGrammarParser.BinaryDslashRpContext ctx) {
        return super.visitBinaryDslashRp(ctx);
    }

    @Override
    public SubQuery visitSingleAttrRp(XQueryGrammarParser.SingleAttrRpContext ctx) {
        return super.visitSingleAttrRp(ctx);
    }

    @Override
    public SubQuery visitSingleTextRp(XQueryGrammarParser.SingleTextRpContext ctx) {
        return super.visitSingleTextRp(ctx);
    }

    @Override
    public SubQuery visitSingleSelfRp(XQueryGrammarParser.SingleSelfRpContext ctx) {
        return super.visitSingleSelfRp(ctx);
    }

    @Override
    public SubQuery visitBinarySlashRp(XQueryGrammarParser.BinarySlashRpContext ctx) {
        return super.visitBinarySlashRp(ctx);
    }

    @Override
    public SubQuery visitFilterRp(XQueryGrammarParser.FilterRpContext ctx) {
        return super.visitFilterRp(ctx);
    }

    @Override
    public SubQuery visitSingleParenthRp(XQueryGrammarParser.SingleParenthRpContext ctx) {
        return super.visitSingleParenthRp(ctx);
    }

    @Override
    public SubQuery visitSingleStarRp(XQueryGrammarParser.SingleStarRpContext ctx) {
        return super.visitSingleStarRp(ctx);
    }

    @Override
    public SubQuery visitSingleTagRp(XQueryGrammarParser.SingleTagRpContext ctx) {
        return super.visitSingleTagRp(ctx);
    }

    @Override
    public SubQuery visitBinaryOrF(XQueryGrammarParser.BinaryOrFContext ctx) {
        return super.visitBinaryOrF(ctx);
    }

    @Override
    public SubQuery visitRpEqualStringF(XQueryGrammarParser.RpEqualStringFContext ctx) {
        return super.visitRpEqualStringF(ctx);
    }

    @Override
    public SubQuery visitNegF(XQueryGrammarParser.NegFContext ctx) {
        return super.visitNegF(ctx);
    }

    @Override
    public SubQuery visitBinaryEqualRpF(XQueryGrammarParser.BinaryEqualRpFContext ctx) {
        return super.visitBinaryEqualRpF(ctx);
    }

    @Override
    public SubQuery visitBinaryIsRpF(XQueryGrammarParser.BinaryIsRpFContext ctx) {
        return super.visitBinaryIsRpF(ctx);
    }

    @Override
    public SubQuery visitRpF(XQueryGrammarParser.RpFContext ctx) {
        return super.visitRpF(ctx);
    }

    @Override
    public SubQuery visitParenthF(XQueryGrammarParser.ParenthFContext ctx) {
        return super.visitParenthF(ctx);
    }

    @Override
    public SubQuery visitBinaryAndF(XQueryGrammarParser.BinaryAndFContext ctx) {
        return super.visitBinaryAndF(ctx);
    }

    @Override
    public SubQuery visitDoc(XQueryGrammarParser.DocContext ctx) {
        return super.visitDoc(ctx);
    }
}
