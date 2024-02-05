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
        return super.visitSingleParentRp(ctx);
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
        return super.visitSingleAttrRp(ctx);
    }

    @Override
    public SubExpression visitSingleTextRp(XPathGrammarParser.SingleTextRpContext ctx) {
        return super.visitSingleTextRp(ctx);
    }

    @Override
    public SubExpression visitSingleSelfRp(XPathGrammarParser.SingleSelfRpContext ctx) {
        return super.visitSingleSelfRp(ctx);
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
        return super.visitSingleParenthRp(ctx);
    }

    @Override
    public SubExpression visitSingleStarRp(XPathGrammarParser.SingleStarRpContext ctx) {
        return super.visitSingleStarRp(ctx);
    }

    @Override
    public SubExpression visitSingleTagRp(XPathGrammarParser.SingleTagRpContext ctx) {
        return super.visitSingleTagRp(ctx);
    }

    @Override
    public SubExpression visitBinaryOrF(XPathGrammarParser.BinaryOrFContext ctx) {
        return super.visitBinaryOrF(ctx);
    }

    @Override
    public SubExpression visitRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx) {
        return super.visitRpEqualStringF(ctx);
    }

    @Override
    public SubExpression visitNegF(XPathGrammarParser.NegFContext ctx) {
        return super.visitNegF(ctx);
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
        return super.visitRpF(ctx);
    }

    @Override
    public SubExpression visitParenthF(XPathGrammarParser.ParenthFContext ctx) {
        return super.visitParenthF(ctx);
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
