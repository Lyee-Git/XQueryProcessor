package com.github.cse232b.subexpr;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleRp implements SubExpression {
    private final String info; // Additional info stored in SingleAp like tagName or attrName
    private final SubExpression parenthRp;
    private final SubType subType;

    public SingleRp(String info, SubExpression parenthRp, SubType subType) {
        if (subType == null) {
            throw new NullPointerException("subType in SingleRp missing " + this);
        }
        this.info = info;
        this.parenthRp = parenthRp;
        this.subType = subType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleRp singleRp = (SingleRp) o;
        return Objects.equals(info, singleRp.info) && Objects.equals(parenthRp, singleRp.parenthRp) && subType == singleRp.subType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(info, parenthRp, subType);
    }

    @Override
    public String toString() {
        return "SingleRp{" +
                "info='" + info + '\'' +
                ", parenthRp=" + parenthRp +
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
            return this.parenthRp.eval(input);
        }
        for (Node node : input) {
            NodeList children = node.getChildNodes();
            switch (subType) {
                case SingleTagRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        if (cur.getNodeType() == Node.ELEMENT_NODE && cur.getNodeName().equals(info)) {
                            res.add(cur);
                        }
                    }
                    break;
                case SingleStarRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        res.add(cur);
                    }
                    break;
                case SingleSelfRp:
                    res.add(node);
                    break;
                case SingleTextRp:
                    for (int i = 0; i < children.getLength(); i++) {
                        Node cur = children.item(i);
                        if (cur.getNodeType() == Node.TEXT_NODE) {
                            res.add(cur);
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
