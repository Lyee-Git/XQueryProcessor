package com.github.cse232b.subexpr;


import org.w3c.dom.Node;

import java.util.*;

public class SingleF implements SubExpression {
    private final SubType subType;
    private final SubExpression subExpr; // Could be a Rp for rpF or a Filter for negF or ParenthF

    public SingleF(SubType subType, SubExpression subExpr) {
        if (subType == null) {
            throw new NullPointerException("subType in SingleF missing " + this);
        }
        if (subExpr == null) {
            throw new NullPointerException("subExpr in SingleF missing " + this);
        }
        this.subType = subType;
        this.subExpr = subExpr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingleF singleF = (SingleF) o;
        return subType == singleF.subType && subExpr.equals(singleF.subExpr);
    }

    @Override
    public String toString() {
        return "SingleF{" +
                "subType=" + subType +
                ", subExpr=" + subExpr +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(subType, subExpr);
    }

    @Override
    public SubType getExprType() {
        return subType;
    }

    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        List<Node> res = new ArrayList<>();
        if (this.subType == SubType.RpF) {
            for (Node node : input) {
                List<Node> evalResult = this.subExpr.eval(List.of(node));
                if (!evalResult.isEmpty()) {
                    res.add(node);
                }
            }
        } else if (this.subType == SubType.ParenthF) {
            return this.subExpr.eval(input);
        } else if (this.subType == SubType.NegF) {
            List<Node> negNodes = this.subExpr.eval(input);
            Set<Node> negNodesSet = new HashSet<>(negNodes);
            for (Node node : input) {
                if (!negNodesSet.contains(node)) {
                    res.add(node);
                }
            }
        } else {
            throw new Exception("Unsupported subExpression type:" + this);
        }
        return res;
    }
}
