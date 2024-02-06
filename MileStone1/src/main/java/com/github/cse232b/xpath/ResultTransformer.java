package com.github.cse232b.xpath;

import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.PrintStream;
import java.util.List;

// Transforms a list of nodes to a human-readable format
public class ResultTransformer {
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
