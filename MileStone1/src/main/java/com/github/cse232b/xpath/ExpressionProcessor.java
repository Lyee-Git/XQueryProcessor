package com.github.cse232b.xpath;

import com.github.cse232b.gen.XPathGrammarBaseVisitor;
import com.github.cse232b.gen.XPathGrammarParser;
import com.github.cse232b.subexpr.*;

import static com.github.cse232b.subexpr.SubExpression.SubType.*;

public class ExpressionProcessor extends XPathGrammarBaseVisitor<SubExpression> {
    @Override
    public SubExpression visitSlashAp(XPathGrammarParser.SlashApContext ctx) {
        String docName = ctx.doc().String().getText();
        SubExpression rp = visit(ctx.rp());
        return new ApPath(docName.substring(1, docName.length()-1), SlashAp, rp);
    }

    @Override
    public SubExpression visitDslashAp(XPathGrammarParser.DslashApContext ctx) {
        String docName = ctx.doc().String().getText();
        SubExpression rp = visit(ctx.rp());
        return new ApPath(docName.substring(1, docName.length()-1), DslashAp, rp);
    }

    @Override
    public SubExpression visitSingleParentRp(XPathGrammarParser.SingleParentRpContext ctx) {
        return new SingleRp(null, null, SubExpression.SubType.SingleParentRp);
    }

    @Override
    public SubExpression visitBinaryCombineRp(XPathGrammarParser.BinaryCombineRpContext ctx) {
        SubExpression leftRp = visit(ctx.rp(0));
        SubExpression rightRp = visit(ctx.rp(1));
        return new BinaryRp(leftRp, rightRp, BinaryCombineRp);
    }

    @Override
    public SubExpression visitBinaryDslashRp(XPathGrammarParser.BinaryDslashRpContext ctx) {
        SubExpression leftRp = visit(ctx.rp(0));
        SubExpression rightRp = visit(ctx.rp(1));
        return new BinaryRp(leftRp, rightRp, BinaryDslashRp);
    }

    @Override
    public SubExpression visitSingleAttrRp(XPathGrammarParser.SingleAttrRpContext ctx) {
        return new SingleRp(ctx.Name().getText(), null, SubExpression.SubType.SingleAttrRp);
    }

    @Override
    public SubExpression visitSingleTextRp(XPathGrammarParser.SingleTextRpContext ctx) {
        return new SingleRp(null, null, SubExpression.SubType.SingleTextRp);
    }

    @Override
    public SubExpression visitSingleSelfRp(XPathGrammarParser.SingleSelfRpContext ctx) {
        return new SingleRp(null, null, SubExpression.SubType.SingleSelfRp);
    }

    @Override
    public SubExpression visitBinarySlashRp(XPathGrammarParser.BinarySlashRpContext ctx) {
        SubExpression leftRp = visit(ctx.rp(0));
        SubExpression rightRp = visit(ctx.rp(1));
        return new BinaryRp(leftRp, rightRp, BinarySlashRp);
    }

    @Override
    public SubExpression visitFilterRp(XPathGrammarParser.FilterRpContext ctx) {
        SubExpression rp = visit(ctx.rp());
        SubExpression f = visit(ctx.f());
        return new BinaryRp(rp, f, FilterRp);
    }

    @Override
    public SubExpression visitSingleParenthRp(XPathGrammarParser.SingleParenthRpContext ctx) {
        SubExpression parenthRp = visit(ctx.rp());
        return new SingleRp(null, parenthRp, SubExpression.SubType.SingleParenthRp);
    }

    @Override
    public SubExpression visitSingleStarRp(XPathGrammarParser.SingleStarRpContext ctx) {
        return new SingleRp(null, null, SubExpression.SubType.SingleStarRp);
    }

    @Override
    public SubExpression visitSingleTagRp(XPathGrammarParser.SingleTagRpContext ctx) {
        return new SingleRp(ctx.Name().getText(), null, SubExpression.SubType.SingleTagRp);
    }

    @Override
    public SubExpression visitBinaryOrF(XPathGrammarParser.BinaryOrFContext ctx) {
        SubExpression f1 = visit(ctx.f(0));
        SubExpression f2 = visit(ctx.f(1));
        return new BinaryF(f1, f2, BinaryOrF);
    }

    @Override
    public SubExpression visitRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx) {
        SubExpression rp = visit(ctx.rp());
        String s = ctx.String().getText();
        s = s.substring(1, s.length() - 1);
        return new BinaryF(rp, s, RpEqualStringF);
    }

    @Override
    public SubExpression visitNegF(XPathGrammarParser.NegFContext ctx) {
        SubExpression f = visit(ctx.f());
        return new SingleF(SubExpression.SubType.NegF, f);
    }

    @Override
    public SubExpression visitBinaryEqualRpF(XPathGrammarParser.BinaryEqualRpFContext ctx) {
        SubExpression leftRp = visit(ctx.rp(0));
        SubExpression rightRp = visit(ctx.rp(1));
        return new BinaryF(leftRp, rightRp, BinaryEqualRpF);
    }

    @Override
    public SubExpression visitBinaryIsRpF(XPathGrammarParser.BinaryIsRpFContext ctx) {
        SubExpression leftRp = visit(ctx.rp(0));
        SubExpression rightRp = visit(ctx.rp(1));
        return new BinaryF(leftRp, rightRp, BinaryIsRpF);
    }

    @Override
    public SubExpression visitRpF(XPathGrammarParser.RpFContext ctx) {
        SubExpression rp = visit(ctx.rp());
        return new SingleF(SubExpression.SubType.RpF, rp);
    }

    @Override
    public SubExpression visitParenthF(XPathGrammarParser.ParenthFContext ctx) {
        SubExpression f = visit(ctx.f());
        return new SingleF(SubExpression.SubType.ParenthF, f);
    }

    @Override
    public SubExpression visitBinaryAndF(XPathGrammarParser.BinaryAndFContext ctx) {
        SubExpression f1 = visit(ctx.f(0));
        SubExpression f2 = visit(ctx.f(1));
        return new BinaryF(f1, f2, BinaryAndF);
    }

    @Override
    public SubExpression visitDoc(XPathGrammarParser.DocContext ctx) {
        return super.visitDoc(ctx);
    }
}
