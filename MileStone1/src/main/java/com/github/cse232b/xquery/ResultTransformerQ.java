package com.github.cse232b.xquery;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.PrintStream;
import java.util.List;

public class ResultTransformerQ {
    public void transform(List<Node> result) throws Exception{
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        Transformer tf = tfFactory.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        for (Node n: result) {
            if(n instanceof Attr || n instanceof Text) {
                System.out.println(n.getTextContent());
            }
            else {
                DOMSource source = new DOMSource(n);
                StreamResult resultStream = new StreamResult(new PrintStream(System.out));
                tf.transform(source, resultStream);
            }
        }
    }
}
