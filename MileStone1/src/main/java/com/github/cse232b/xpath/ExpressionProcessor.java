package com.github.cse232b.xpath;

import com.github.cse232b.parsers.XPathGrammarBaseVisitor;
import com.github.cse232b.subexpr.*;
import com.github.cse232b.parsers.XPathGrammarParser;

public class ExpressionProcessor extends XPathGrammarBaseVisitor<SubExpression> {
    @Override
    public SubExpression visitSlashAp(XPathGrammarParser.SlashApContext ctx) {
        return super.visitSlashAp(ctx);
    }

    @Override
    public SubExpression visitDslashAp(XPathGrammarParser.DslashApContext ctx) {
        return super.visitDslashAp(ctx);
    }

    @Override
    public SubExpression visitSingleParentRp(XPathGrammarParser.SingleParentRpContext ctx) {
        return new SingleRp(null, null, SubExpression.SubType.SingleParentRp);
    }

    @Override
    public SubExpression visitBinaryCombineRp(XPathGrammarParser.BinaryCombineRpContext ctx) {
        return super.visitBinaryCombineRp(ctx);
    }

    @Override
    public SubExpression visitBinaryDslashRp(XPathGrammarParser.BinaryDslashRpContext ctx) {
        return super.visitBinaryDslashRp(ctx);
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
        return super.visitBinarySlashRp(ctx);
    }

    @Override
    public SubExpression visitFilterRp(XPathGrammarParser.FilterRpContext ctx) {
        return super.visitFilterRp(ctx);
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
        return super.visitBinaryOrF(ctx);
    }

    @Override
    public SubExpression visitRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx) {
        SubExpression rp = visit(ctx.rp());
        String s = ctx.String().getText();
        return new StringF(SubExpression.SubType.RpEqualStringF, rp, s);
    }

    @Override
    public SubExpression visitNegF(XPathGrammarParser.NegFContext ctx) {
        SubExpression f = visit(ctx.f());
        return new SingleF(SubExpression.SubType.NegF, f);
    }

    @Override
    public SubExpression visitBinaryEqualRpF(XPathGrammarParser.BinaryEqualRpFContext ctx) {
        return super.visitBinaryEqualRpF(ctx);
    }

    @Override
    public SubExpression visitBinaryIsRpF(XPathGrammarParser.BinaryIsRpFContext ctx) {
        return super.visitBinaryIsRpF(ctx);
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
        return super.visitBinaryAndF(ctx);
    }

    @Override
    public SubExpression visitDoc(XPathGrammarParser.DocContext ctx) {
        return super.visitDoc(ctx);
    }
}
