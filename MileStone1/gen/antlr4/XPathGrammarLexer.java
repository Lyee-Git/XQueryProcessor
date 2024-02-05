// Generated from D:/qq/1359641035/FileRecv/Winter 2024/CSE 232B/XQueryProcessor/MileStone1/src/main/resources/antlr4/XPathGrammar.g4 by ANTLR 4.13.1
package antlr4;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, Name=21, String=22, WhiteSpace=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "Name", "String", "WhiteSpace"
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


	public XPathGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPathGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0017}\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0004\u0014j\b\u0014"+
		"\u000b\u0014\f\u0014k\u0001\u0015\u0001\u0015\u0005\u0015p\b\u0015\n\u0015"+
		"\f\u0015s\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0004\u0016x\b\u0016"+
		"\u000b\u0016\f\u0016y\u0001\u0016\u0001\u0016\u0000\u0000\u0017\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017\u0001"+
		"\u0000\u0003\u0004\u0000--09AZaz\u0001\u0000\"\"\u0003\u0000\t\n\r\r "+
		" \u007f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0001/\u0001\u0000\u0000\u0000\u00031\u0001\u0000\u0000\u0000\u00054"+
		"\u0001\u0000\u0000\u0000\u00076\u0001\u0000\u0000\u0000\t8\u0001\u0000"+
		"\u0000\u0000\u000b;\u0001\u0000\u0000\u0000\rB\u0001\u0000\u0000\u0000"+
		"\u000fD\u0001\u0000\u0000\u0000\u0011F\u0001\u0000\u0000\u0000\u0013H"+
		"\u0001\u0000\u0000\u0000\u0015J\u0001\u0000\u0000\u0000\u0017L\u0001\u0000"+
		"\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bP\u0001\u0000\u0000\u0000"+
		"\u001dS\u0001\u0000\u0000\u0000\u001fV\u0001\u0000\u0000\u0000!Y\u0001"+
		"\u0000\u0000\u0000#]\u0001\u0000\u0000\u0000%`\u0001\u0000\u0000\u0000"+
		"\'d\u0001\u0000\u0000\u0000)i\u0001\u0000\u0000\u0000+m\u0001\u0000\u0000"+
		"\u0000-w\u0001\u0000\u0000\u0000/0\u0005/\u0000\u00000\u0002\u0001\u0000"+
		"\u0000\u000012\u0005/\u0000\u000023\u0005/\u0000\u00003\u0004\u0001\u0000"+
		"\u0000\u000045\u0005*\u0000\u00005\u0006\u0001\u0000\u0000\u000067\u0005"+
		".\u0000\u00007\b\u0001\u0000\u0000\u000089\u0005.\u0000\u00009:\u0005"+
		".\u0000\u0000:\n\u0001\u0000\u0000\u0000;<\u0005t\u0000\u0000<=\u0005"+
		"e\u0000\u0000=>\u0005x\u0000\u0000>?\u0005t\u0000\u0000?@\u0005(\u0000"+
		"\u0000@A\u0005)\u0000\u0000A\f\u0001\u0000\u0000\u0000BC\u0005@\u0000"+
		"\u0000C\u000e\u0001\u0000\u0000\u0000DE\u0005(\u0000\u0000E\u0010\u0001"+
		"\u0000\u0000\u0000FG\u0005)\u0000\u0000G\u0012\u0001\u0000\u0000\u0000"+
		"HI\u0005,\u0000\u0000I\u0014\u0001\u0000\u0000\u0000JK\u0005[\u0000\u0000"+
		"K\u0016\u0001\u0000\u0000\u0000LM\u0005]\u0000\u0000M\u0018\u0001\u0000"+
		"\u0000\u0000NO\u0005=\u0000\u0000O\u001a\u0001\u0000\u0000\u0000PQ\u0005"+
		"e\u0000\u0000QR\u0005q\u0000\u0000R\u001c\u0001\u0000\u0000\u0000ST\u0005"+
		"=\u0000\u0000TU\u0005=\u0000\u0000U\u001e\u0001\u0000\u0000\u0000VW\u0005"+
		"i\u0000\u0000WX\u0005s\u0000\u0000X \u0001\u0000\u0000\u0000YZ\u0005a"+
		"\u0000\u0000Z[\u0005n\u0000\u0000[\\\u0005d\u0000\u0000\\\"\u0001\u0000"+
		"\u0000\u0000]^\u0005o\u0000\u0000^_\u0005r\u0000\u0000_$\u0001\u0000\u0000"+
		"\u0000`a\u0005n\u0000\u0000ab\u0005o\u0000\u0000bc\u0005t\u0000\u0000"+
		"c&\u0001\u0000\u0000\u0000de\u0005d\u0000\u0000ef\u0005o\u0000\u0000f"+
		"g\u0005c\u0000\u0000g(\u0001\u0000\u0000\u0000hj\u0007\u0000\u0000\u0000"+
		"ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000kl\u0001\u0000\u0000\u0000l*\u0001\u0000\u0000\u0000mq\u0005\"\u0000"+
		"\u0000np\b\u0001\u0000\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\"\u0000\u0000u,\u0001\u0000"+
		"\u0000\u0000vx\u0007\u0002\u0000\u0000wv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{|\u0006\u0016\u0000\u0000|.\u0001\u0000\u0000"+
		"\u0000\u0004\u0000kqy\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}