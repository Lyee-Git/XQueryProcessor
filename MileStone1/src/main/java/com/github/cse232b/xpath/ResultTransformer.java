package com.github.cse232b.xpath;

import org.w3c.dom.*;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

// Transforms a list of nodes to a human-readable format
public class ResultTransformer {
    public void transform(List<Node> result) throws Exception {
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        Transformer tf = tfFactory.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        Document newXmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        Element root = newXmlDocument.createElement("result");
        newXmlDocument.appendChild(root);
        // Print each node in the result list
        for (Node n : result) {
            Node copyNode = newXmlDocument.importNode(n, true);
            root.appendChild(copyNode);
        }
        // Create a DOMSource
        DOMSource source = new DOMSource(root);
        // Create a StreamResult
        StreamResult resultStream = new StreamResult(System.out);
        // Transform the XML document
        tf.transform(source, resultStream);
    }
}
