package com.github.cse232b.subexpr;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleRp implements SubExpression {
    private final String info; // Additional info stored in SingleAp like tagName or attrName
    private final SubExpression paraRp;
    private final SubType subType;

    public SingleRp(String info, SubExpression paraRp, SubType subType) {
        if (subType == null) {
            throw new NullPointerException("subType in SingleRp missing " + this);
        }
        this.info = info;
        this.paraRp = paraRp;
        this.subType = subType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleRp singleRp = (SingleRp) o;
        return Objects.equals(info, singleRp.info) && Objects.equals(paraRp, singleRp.paraRp) && subType == singleRp.subType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, paraRp, subType);
    }

    @Override
    public String toString() {
        return "SingleRp{" +
                "info='" + info + '\'' +
                ", paraRp=" + paraRp +
                ", subType=" + subType +
                '}';
    }

    @Override
    public SubType getExprType() {
        return this.subType;
    }

    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        List<Node> res = new ArrayList<>();
        if (this.subType == SubType.SingleParenthRp) {
            return this.paraRp.eval(input);
        }
        for (Node node : input) {
            NodeList children = node.getChildNodes();
            switch (subType) {
                case SingleTagRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        if (cur.getNodeType() == Node.ELEMENT_NODE && cur.getNodeName().equals(info)) {
                            res.add(node);
                        }
                    }
                    break;
                case SingleStarRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        res.add(node);
                    }
                    break;
                case SingleSelfRp:
                    res.add(node);
                    break;
                case SingleTextRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        if (cur.getNodeType() == Node.TEXT_NODE) {
                            res.add(node);
                        }
                    }
                    break;
                case SingleParentRp:
                    if (!(node instanceof Document))
                        res.add(node.getParentNode());
                    break;
                case SingleAttrRp:
                    res.add(node.getAttributes().getNamedItem(info));
                    break;
                default:
                    throw new Exception("Unsupported subExpression type:" + this);
            }
        }
        return res;
    }
}
