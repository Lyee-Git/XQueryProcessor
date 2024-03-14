package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class JoinXq implements SubQuery{
    private SubQuery leftQuery;
    private SubQuery rightQuery;
    private List<String> leftAttributes;
    private List<String> rightAttributes;

    private Transformer tf;

    public JoinXq (SubQuery leftQ, SubQuery rightQ, List<String> leftA, List<String> rightA) {
        if (leftQ == null) {
            throw new NullPointerException("Left query is NULL!");
        }
        if (rightQ == null) {
            throw new NullPointerException("Right query is NULL!");
        }
        if (leftA == null) {
            throw new NullPointerException("Left attributes list is NULL!");
        }
        if (rightA == null) {
            throw new NullPointerException("right attributes list is NULL!");
        }
        this.leftQuery = leftQ;
        this.rightQuery = rightQ;
        this.leftAttributes = leftA;
        this.rightAttributes = rightA;
    }

    public void initTransformer() throws TransformerConfigurationException {
        this.tf = TransformerFactory.newInstance().newTransformer();
        this.tf.setOutputProperty(OutputKeys.INDENT, "yes");
    }

    private Node concatTuple(Document doc, Node t1, Node t2) {
        Element tuple = doc.createElement("tuple");
        appendChildNodes(tuple, t1.getChildNodes());
        appendChildNodes(tuple, t2.getChildNodes());
        return tuple;
    }

    private void appendChildNodes(Node parent, NodeList childNodes) {
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node child = childNodes.item(i);
            parent.appendChild(child.cloneNode(true));
        }
    }

    private String setHash(Node tuple, List<String> attrs) throws TransformerException, UnsupportedEncodingException {
        Map<String, Node> tagToVar = new HashMap<>();
        NodeList childNodes = tuple.getChildNodes();
        StringBuilder index = new StringBuilder();
        for(int i=0; i < childNodes.getLength(); i++) {
            assert childNodes.item(i).getChildNodes().getLength() == 1;
            tagToVar.put(childNodes.item(i).getNodeName(), childNodes.item(i).getChildNodes().item(0));
        }
        for(String attr: attrs) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            this.tf.transform(new DOMSource(tagToVar.get(attr)), new StreamResult(new PrintStream(os)));
            index.append(os.toString("UTF8"));
            index.append("+");
        }
        return index.toString();
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        this.initTransformer();
        List<Node> output = new ArrayList<>();
        List<Node> leftNodes = this.leftQuery.evaluate(doc);
        List<Node> rightNodes = this.rightQuery.evaluate(doc);
        Map<String, List<Node>> leftMap = new HashMap<>();
        // use cartesian product if attribute is null
        if(this.leftAttributes.size() == 0 || this.rightAttributes.size() == 0) {
            for (Node leftN : leftNodes) {
                for (Node rightN : rightNodes) {
                    output.add(this.concatTuple(doc, leftN, rightN));
                }
            }
        // use hash join    
        } else {
            for(Node leftN: leftNodes) {
                // might have same nodes with the same hashcode. Each node should map to the right line.
                String hashcode = this.setHash(leftN, this.leftAttributes);
                if(!leftMap.containsKey(hashcode)) {
                    leftMap.put(hashcode, new ArrayList<>());
                }
                leftMap.get(hashcode).add(leftN);
            }
            for(Node rightN: rightNodes) {
                String hashcode = this.setHash(rightN, this.rightAttributes);
                if(leftMap.containsKey(hashcode)) {
                    List<Node> matchedNodes = leftMap.get(hashcode);
                    for (Node node : matchedNodes) {
                        output.add(this.concatTuple(doc, node, rightN));
                    }
                }
            }
        }
        return output;
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.JoinXq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinXq joinXq = (JoinXq) o;
        return Objects.equals(leftQuery, joinXq.leftQuery) && Objects.equals(rightQuery, joinXq.rightQuery) && Objects.equals(leftAttributes, joinXq.leftAttributes) && Objects.equals(rightAttributes, joinXq.rightAttributes) && Objects.equals(tf, joinXq.tf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftQuery, rightQuery, leftAttributes, rightAttributes, tf);
    }

    @Override
    public String toString() {
        return "JoinXq{" +
                "leftQuery=" + leftQuery +
                ", rightQuery=" + rightQuery +
                ", leftAttributes=" + leftAttributes +
                ", rightAttributes=" + rightAttributes +
                ", tf=" + tf +
                '}';
    }
}
