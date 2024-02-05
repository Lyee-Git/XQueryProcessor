// Generated from D:/qq/1359641035/FileRecv/Winter 2024/CSE 232B/XQueryProcessor/MileStone1/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package com.github.cse232b.parsers;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XPathGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XPathGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code SlashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlashAp(XPathGrammarParser.SlashApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DslashAp}
	 * labeled alternative in {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDslashAp(XPathGrammarParser.DslashApContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleParentRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParentRp(XPathGrammarParser.SingleParentRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryCombineRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCombineRp(XPathGrammarParser.BinaryCombineRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryDslashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryDslashRp(XPathGrammarParser.BinaryDslashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleAttrRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAttrRp(XPathGrammarParser.SingleAttrRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleTextRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTextRp(XPathGrammarParser.SingleTextRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleSelfRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSelfRp(XPathGrammarParser.SingleSelfRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinarySlashRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinarySlashRp(XPathGrammarParser.BinarySlashRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FilterRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRp(XPathGrammarParser.FilterRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleParenthRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleParenthRp(XPathGrammarParser.SingleParenthRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleStarRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStarRp(XPathGrammarParser.SingleStarRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleTagRp}
	 * labeled alternative in {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleTagRp(XPathGrammarParser.SingleTagRpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryOrF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOrF(XPathGrammarParser.BinaryOrFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpEqualStringF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpEqualStringF(XPathGrammarParser.RpEqualStringFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegF(XPathGrammarParser.NegFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryEqualRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryEqualRpF(XPathGrammarParser.BinaryEqualRpFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryIsRpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryIsRpF(XPathGrammarParser.BinaryIsRpFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RpF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpF(XPathGrammarParser.RpFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthF(XPathGrammarParser.ParenthFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BinaryAndF}
	 * labeled alternative in {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAndF(XPathGrammarParser.BinaryAndFContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XPathGrammarParser.DocContext ctx);
}