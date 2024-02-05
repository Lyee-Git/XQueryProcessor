package com.github.cse232b.xpath;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.github.cse232b.parsers.XPathGrammarLexer;
import com.github.cse232b.parsers.XPathGrammarParser;
import com.github.cse232b.subexpr.SubExpression;
import com.github.cse232b.subexpr.ApPath;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.w3c.dom.Text;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class XPathProcessor {
    private DocumentBuilder docBuilder;

    // Constructor to initialize the DocumentBuilder with a custom entity resolver.
    public XPathProcessor() throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        this.docBuilder = dbf.newDocumentBuilder();
        this.docBuilder.setEntityResolver(new MyResolver());
    }

    // Evaluates an XPath expression and returns the resulting nodes.
    public List<Node> evaluate(String path) throws Exception {
        // Lexer and parser setup
        XPathGrammarLexer lexer = new XPathGrammarLexer(CharStreams.fromString(path));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPathGrammarParser parser = new XPathGrammarParser(tokens);
        ParserRuleContext tree = parser.ap();

        // Build expression from parsed tree
        ExpressionProcessor expBuild = new ExpressionProcessor();
        SubExpression rootExp = expBuild.visit(tree);

        // Load document
        ApPath apExp = (ApPath) rootExp;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(apExp.getDoc());
        Document doc = docBuilder.parse(is);

        // Evaluate expression
        List<Node> inputNodes = new ArrayList<>();
        inputNodes.add(doc);
        return apExp.eval(inputNodes);
    }

    // Transforms a list of nodes to a human-readable format
    public void transform(List<Node> result) throws Exception {
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        Transformer tf = tfFactory.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");

        // Print each node in the result list
        for (Node n : result) {
            if (n instanceof Attr || n instanceof Text) {
                // Directly print attribute or text content
                System.out.println(n.getTextContent());
            } else {
                // Transform and print other types of nodes recursively
                tf.transform(new DOMSource(n), new StreamResult(new PrintStream(System.out)));
            }
        }
    }
}
