package com.github.cse232b.xquery;

import com.github.cse232b.gen.XQueryGrammarLexer;
import com.github.cse232b.gen.XQueryGrammarParser;
import com.github.cse232b.subquery.SubQuery;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

public class XQueryProcessor {
    final private Document curDocument;
    public XQueryProcessor() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
        this.curDocument = documentBuilder.newDocument();
    }

    public XQueryGrammarParser getGrammarParser(String path) {
        final XQueryGrammarLexer lexer = new XQueryGrammarLexer(CharStreams.fromString(path));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new XQueryGrammarParser(tokens);
    }

    public List<Node> evaluate(String path) throws Exception {
        final XQueryGrammarParser parser = getGrammarParser(path);
        final ParserRuleContext tree = parser.xq();
        QueryProcessor qb = new QueryProcessor(this.curDocument);
        final SubQuery root = qb.visit(tree);
        return root.evaluate(this.curDocument);
    }
}
