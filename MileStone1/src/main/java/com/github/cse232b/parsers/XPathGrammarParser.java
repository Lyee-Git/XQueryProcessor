// Generated from D:/qq/1359641035/FileRecv/Winter 2024/CSE 232B/XQueryProcessor/MileStone1/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package com.github.cse232b.parsers;
import antlr4.XPathGrammarVisitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class XPathGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Name=21, String=22, WhiteSpace=23;
	public static final int
		RULE_ap = 0, RULE_rp = 1, RULE_f = 2, RULE_doc = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"ap", "rp", "f", "doc"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'('", 
			"')'", "','", "'['", "']'", "'='", "'eq'", "'=='", "'is'", "'and'", "'or'", 
			"'not'", "'doc'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "Name", "String", 
			"WhiteSpace"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ApContext extends ParserRuleContext {
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
	 
		public ApContext() { }
		public void copyFrom(ApContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlashApContext extends ApContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SlashApContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSlashAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSlashAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor) return ((XPathGrammarVisitor<? extends T>)visitor).visitSlashAp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DslashApContext extends ApContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public DslashApContext(ApContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterDslashAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitDslashAp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitDslashAp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_ap);
		try {
			setState(16);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new SlashApContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(8);
				doc();
				setState(9);
				match(T__0);
				setState(10);
				rp(0);
				}
				break;
			case 2:
				_localctx = new DslashApContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				doc();
				setState(13);
				match(T__1);
				setState(14);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RpContext extends ParserRuleContext {
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
	 
		public RpContext() { }
		public void copyFrom(RpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParentRpContext extends RpContext {
		public SingleParentRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleParentRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleParentRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleParentRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryCombineRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public BinaryCombineRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryCombineRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryCombineRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryCombineRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryDslashRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public BinaryDslashRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryDslashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryDslashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryDslashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleAttrRpContext extends RpContext {
		public TerminalNode Name() { return getToken(XPathGrammarParser.Name, 0); }
		public SingleAttrRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleAttrRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleAttrRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleAttrRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleTextRpContext extends RpContext {
		public SingleTextRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleTextRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleTextRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleTextRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleSelfRpContext extends RpContext {
		public SingleSelfRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleSelfRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleSelfRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleSelfRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinarySlashRpContext extends RpContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public BinarySlashRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinarySlashRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinarySlashRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinarySlashRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterRpContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilterRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterFilterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitFilterRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitFilterRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleParenthRpContext extends RpContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public SingleParenthRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleParenthRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleParenthRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleParenthRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleStarRpContext extends RpContext {
		public SingleStarRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleStarRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleStarRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleStarRp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleTagRpContext extends RpContext {
		public TerminalNode Name() { return getToken(XPathGrammarParser.Name, 0); }
		public SingleTagRpContext(RpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterSingleTagRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitSingleTagRp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitSingleTagRp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Name:
				{
				_localctx = new SingleTagRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(19);
				match(Name);
				}
				break;
			case T__2:
				{
				_localctx = new SingleStarRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new SingleSelfRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new SingleParentRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__4);
				}
				break;
			case T__5:
				{
				_localctx = new SingleTextRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new SingleAttrRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__6);
				setState(25);
				match(Name);
				}
				break;
			case T__7:
				{
				_localctx = new SingleParenthRpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__7);
				setState(27);
				rp(0);
				setState(28);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(48);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(46);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new BinarySlashRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(32);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(33);
						match(T__0);
						setState(34);
						rp(5);
						}
						break;
					case 2:
						{
						_localctx = new BinaryDslashRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(35);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(36);
						match(T__1);
						setState(37);
						rp(4);
						}
						break;
					case 3:
						{
						_localctx = new BinaryCombineRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(38);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(39);
						match(T__9);
						setState(40);
						rp(3);
						}
						break;
					case 4:
						{
						_localctx = new FilterRpContext(new RpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rp);
						setState(41);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(42);
						match(T__10);
						setState(43);
						f(0);
						setState(44);
						match(T__11);
						}
						break;
					}
					} 
				}
				setState(50);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryOrFContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public BinaryOrFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryOrF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryOrF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryOrF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RpEqualStringFContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public TerminalNode String() { return getToken(XPathGrammarParser.String, 0); }
		public RpEqualStringFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterRpEqualStringF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitRpEqualStringF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitRpEqualStringF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegFContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NegFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterNegF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitNegF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitNegF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryEqualRpFContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public BinaryEqualRpFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryEqualRpF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryEqualRpF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryEqualRpF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryIsRpFContext extends FContext {
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public BinaryIsRpFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryIsRpF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryIsRpF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryIsRpF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RpFContext extends FContext {
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public RpFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterRpF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitRpF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitRpF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthFContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public ParenthFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterParenthF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitParenthF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitParenthF(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryAndFContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public BinaryAndFContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterBinaryAndF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitBinaryAndF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitBinaryAndF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new RpFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(52);
				rp(0);
				}
				break;
			case 2:
				{
				_localctx = new BinaryEqualRpFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(53);
				rp(0);
				setState(54);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(55);
				rp(0);
				}
				break;
			case 3:
				{
				_localctx = new BinaryIsRpFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				rp(0);
				setState(58);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(59);
				rp(0);
				}
				break;
			case 4:
				{
				_localctx = new RpEqualStringFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				rp(0);
				setState(62);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(63);
				match(String);
				}
				break;
			case 5:
				{
				_localctx = new ParenthFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__7);
				setState(66);
				f(0);
				setState(67);
				match(T__8);
				}
				break;
			case 6:
				{
				_localctx = new NegFContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__18);
				setState(70);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(79);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryAndFContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(73);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(74);
						match(T__16);
						setState(75);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new BinaryOrFContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(76);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(77);
						match(T__17);
						setState(78);
						f(3);
						}
						break;
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(XPathGrammarParser.String, 0); }
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathGrammarListener ) ((XPathGrammarListener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathGrammarVisitor ) return ((XPathGrammarVisitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__19);
			setState(85);
			match(T__7);
			setState(86);
			match(String);
			setState(87);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 2:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017Z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003"+
		"\u0000\u0011\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u001f\b\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001/\b\u0001\n\u0001\f\u00012\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002H\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002P\b\u0002\n\u0002\f\u0002S\t\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0000"+
		"\u0002\u0002\u0004\u0004\u0000\u0002\u0004\u0006\u0000\u0002\u0001\u0000"+
		"\r\u000e\u0001\u0000\u000f\u0010g\u0000\u0010\u0001\u0000\u0000\u0000"+
		"\u0002\u001e\u0001\u0000\u0000\u0000\u0004G\u0001\u0000\u0000\u0000\u0006"+
		"T\u0001\u0000\u0000\u0000\b\t\u0003\u0006\u0003\u0000\t\n\u0005\u0001"+
		"\u0000\u0000\n\u000b\u0003\u0002\u0001\u0000\u000b\u0011\u0001\u0000\u0000"+
		"\u0000\f\r\u0003\u0006\u0003\u0000\r\u000e\u0005\u0002\u0000\u0000\u000e"+
		"\u000f\u0003\u0002\u0001\u0000\u000f\u0011\u0001\u0000\u0000\u0000\u0010"+
		"\b\u0001\u0000\u0000\u0000\u0010\f\u0001\u0000\u0000\u0000\u0011\u0001"+
		"\u0001\u0000\u0000\u0000\u0012\u0013\u0006\u0001\uffff\uffff\u0000\u0013"+
		"\u001f\u0005\u0015\u0000\u0000\u0014\u001f\u0005\u0003\u0000\u0000\u0015"+
		"\u001f\u0005\u0004\u0000\u0000\u0016\u001f\u0005\u0005\u0000\u0000\u0017"+
		"\u001f\u0005\u0006\u0000\u0000\u0018\u0019\u0005\u0007\u0000\u0000\u0019"+
		"\u001f\u0005\u0015\u0000\u0000\u001a\u001b\u0005\b\u0000\u0000\u001b\u001c"+
		"\u0003\u0002\u0001\u0000\u001c\u001d\u0005\t\u0000\u0000\u001d\u001f\u0001"+
		"\u0000\u0000\u0000\u001e\u0012\u0001\u0000\u0000\u0000\u001e\u0014\u0001"+
		"\u0000\u0000\u0000\u001e\u0015\u0001\u0000\u0000\u0000\u001e\u0016\u0001"+
		"\u0000\u0000\u0000\u001e\u0017\u0001\u0000\u0000\u0000\u001e\u0018\u0001"+
		"\u0000\u0000\u0000\u001e\u001a\u0001\u0000\u0000\u0000\u001f0\u0001\u0000"+
		"\u0000\u0000 !\n\u0004\u0000\u0000!\"\u0005\u0001\u0000\u0000\"/\u0003"+
		"\u0002\u0001\u0005#$\n\u0003\u0000\u0000$%\u0005\u0002\u0000\u0000%/\u0003"+
		"\u0002\u0001\u0004&\'\n\u0002\u0000\u0000\'(\u0005\n\u0000\u0000(/\u0003"+
		"\u0002\u0001\u0003)*\n\u0001\u0000\u0000*+\u0005\u000b\u0000\u0000+,\u0003"+
		"\u0004\u0002\u0000,-\u0005\f\u0000\u0000-/\u0001\u0000\u0000\u0000. \u0001"+
		"\u0000\u0000\u0000.#\u0001\u0000\u0000\u0000.&\u0001\u0000\u0000\u0000"+
		".)\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000"+
		"\u000001\u0001\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000020\u0001"+
		"\u0000\u0000\u000034\u0006\u0002\uffff\uffff\u00004H\u0003\u0002\u0001"+
		"\u000056\u0003\u0002\u0001\u000067\u0007\u0000\u0000\u000078\u0003\u0002"+
		"\u0001\u00008H\u0001\u0000\u0000\u00009:\u0003\u0002\u0001\u0000:;\u0007"+
		"\u0001\u0000\u0000;<\u0003\u0002\u0001\u0000<H\u0001\u0000\u0000\u0000"+
		"=>\u0003\u0002\u0001\u0000>?\u0007\u0000\u0000\u0000?@\u0005\u0016\u0000"+
		"\u0000@H\u0001\u0000\u0000\u0000AB\u0005\b\u0000\u0000BC\u0003\u0004\u0002"+
		"\u0000CD\u0005\t\u0000\u0000DH\u0001\u0000\u0000\u0000EF\u0005\u0013\u0000"+
		"\u0000FH\u0003\u0004\u0002\u0001G3\u0001\u0000\u0000\u0000G5\u0001\u0000"+
		"\u0000\u0000G9\u0001\u0000\u0000\u0000G=\u0001\u0000\u0000\u0000GA\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000HQ\u0001\u0000\u0000\u0000"+
		"IJ\n\u0003\u0000\u0000JK\u0005\u0011\u0000\u0000KP\u0003\u0004\u0002\u0004"+
		"LM\n\u0002\u0000\u0000MN\u0005\u0012\u0000\u0000NP\u0003\u0004\u0002\u0003"+
		"OI\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000R\u0005\u0001"+
		"\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000TU\u0005\u0014\u0000\u0000"+
		"UV\u0005\b\u0000\u0000VW\u0005\u0016\u0000\u0000WX\u0005\t\u0000\u0000"+
		"X\u0007\u0001\u0000\u0000\u0000\u0007\u0010\u001e.0GOQ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}