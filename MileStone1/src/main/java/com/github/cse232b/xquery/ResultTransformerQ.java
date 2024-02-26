package com.github.cse232b.xquery;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public void transform(List<Node> result, String outputPath) throws Exception{
        TransformerFactory tfFactory = TransformerFactory.newInstance();
        Transformer tf = tfFactory.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        tf.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        OutputStreamWriter dos = null;
        File file = new File(outputPath);
        try {
            dos = new OutputStreamWriter(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Node n: result) {
            if(n instanceof Attr || n instanceof Text) {
                System.out.println(n.getTextContent());
                try {
                    assert dos != null;
                    dos.write(n.getTextContent());
                } catch (IOException | DOMException e) {
                    e.printStackTrace();
                }
            }
            else {
                DOMSource source = new DOMSource(n);
//                StreamResult resultStream = new StreamResult(new PrintStream(System.out));
                StreamResult resultStream = new StreamResult(dos);
                tf.transform(source, resultStream);
            }
        }
        if (dos != null) {
            dos.close();
        }
    }
}
