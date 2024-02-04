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
	 * Visit a parse tree produced by {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAp(XPathGrammarParser.ApContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRp(XPathGrammarParser.RpContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(XPathGrammarParser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link XPathGrammarParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XPathGrammarParser.DocContext ctx);
}