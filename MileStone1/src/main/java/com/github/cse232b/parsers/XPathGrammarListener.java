// Generated from D:/qq/1359641035/FileRecv/Winter 2024/CSE 232B/XQueryProcessor/MileStone1/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package com.github.cse232b.parsers;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathGrammarParser}.
 */
public interface XPathGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void enterAp(XPathGrammarParser.ApContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#ap}.
	 * @param ctx the parse tree
	 */
	void exitAp(XPathGrammarParser.ApContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void enterRp(XPathGrammarParser.RpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#rp}.
	 * @param ctx the parse tree
	 */
	void exitRp(XPathGrammarParser.RpContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(XPathGrammarParser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathGrammarParser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(XPathGrammarParser.FContext ctx);
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