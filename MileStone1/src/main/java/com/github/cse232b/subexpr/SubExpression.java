package com.github.cse232b.subexpr;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public interface SubExpression {
    SubType getExprType();
    List<Node> eval(List<Node> input) throws Exception;

    /*
        Get All descendants nodes if there is a double slash in subExpr
     */
    default void getDescendants(List<Node> input, List<Node> output) {
        for (Node node : input) {
            output.add(node);
            NodeList children = node.getChildNodes();
            List<Node> childrenNodes = new ArrayList<>();
            for (int i = 0; i < children.getLength(); i++)
                childrenNodes.add(children.item(i));
            getDescendants(childrenNodes, output);
        }
    }

    /*
        An enumeration of all subexpression type
     */
    enum SubType {
        SlashAp,
        DslashAp,
        SingleTagRp,
        SingleStarRp,
        SingleSelfRp,
        SingleParentRp,
        SingleTextRp,
        SingleAttrRp,
        SingleParenthRp,
        BinarySlashRp,
        BinaryDslashRp,
        BinaryCombineRp,
        FilterRp,
        RpF,
        BinaryEqualRpF,
        BinaryIsRpF,
        RpEqualStringF,
        ParenthF,
        BinaryAndF,
        BinaryOrF,
        NegF
    }
}
