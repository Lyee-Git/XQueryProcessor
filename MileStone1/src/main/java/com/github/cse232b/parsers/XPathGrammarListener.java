// Generated from D:/qq/1359641035/FileRecv/Winter 2024/CSE 232B/XQueryProcessor/MileStone1/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package com.github.cse232b.parsers;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathGrammarParser}.
 */
public interface XPathGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code SlashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterSlashAp(XPathGrammarParser.SlashApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SlashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitSlashAp(XPathGrammarParser.SlashApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DslashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterDslashAp(XPathGrammarParser.DslashApContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DslashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitDslashAp(XPathGrammarParser.DslashApContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleParentRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleParentRp(XPathGrammarParser.SingleParentRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleParentRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleParentRp(XPathGrammarParser.SingleParentRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryCombineRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryCombineRp(XPathGrammarParser.BinaryCombineRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryCombineRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryCombineRp(XPathGrammarParser.BinaryCombineRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryDslashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBinaryDslashRp(XPathGrammarParser.BinaryDslashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryDslashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBinaryDslashRp(XPathGrammarParser.BinaryDslashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleAttrRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleAttrRp(XPathGrammarParser.SingleAttrRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleAttrRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleAttrRp(XPathGrammarParser.SingleAttrRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleTextRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleTextRp(XPathGrammarParser.SingleTextRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleTextRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleTextRp(XPathGrammarParser.SingleTextRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleSelfRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleSelfRp(XPathGrammarParser.SingleSelfRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleSelfRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleSelfRp(XPathGrammarParser.SingleSelfRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinarySlashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterBinarySlashRp(XPathGrammarParser.BinarySlashRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinarySlashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitBinarySlashRp(XPathGrammarParser.BinarySlashRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterFilterRp(XPathGrammarParser.FilterRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitFilterRp(XPathGrammarParser.FilterRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleParenthRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleParenthRp(XPathGrammarParser.SingleParenthRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleParenthRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleParenthRp(XPathGrammarParser.SingleParenthRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleStarRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleStarRp(XPathGrammarParser.SingleStarRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleStarRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleStarRp(XPathGrammarParser.SingleStarRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleTagRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterSingleTagRp(XPathGrammarParser.SingleTagRpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleTagRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitSingleTagRp(XPathGrammarParser.SingleTagRpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryOrF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOrF(XPathGrammarParser.BinaryOrFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryOrF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOrF(XPathGrammarParser.BinaryOrFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpEqualStringF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpEqualStringF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NegF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNegF(XPathGrammarParser.NegFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NegF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNegF(XPathGrammarParser.NegFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryEqualRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBinaryEqualRpF(XPathGrammarParser.BinaryEqualRpFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryEqualRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBinaryEqualRpF(XPathGrammarParser.BinaryEqualRpFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryIsRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBinaryIsRpF(XPathGrammarParser.BinaryIsRpFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryIsRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBinaryIsRpF(XPathGrammarParser.BinaryIsRpFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpF(XPathGrammarParser.RpFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpF(XPathGrammarParser.RpFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterParenthF(XPathGrammarParser.ParenthFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitParenthF(XPathGrammarParser.ParenthFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BinaryAndF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBinaryAndF(XPathGrammarParser.BinaryAndFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BinaryAndF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBinaryAndF(XPathGrammarParser.BinaryAndFContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XPathGrammarParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XPathGrammarParser.DocContext ctx);
}