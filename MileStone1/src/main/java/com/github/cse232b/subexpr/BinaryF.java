package com.github.cse232b.subexpr;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryF implements SubExpression {
    //        BinaryEqualRpF, '=', 'eq'
    //        BinaryIsRpF,  '==', 'is'
    //        RpEqualStringF,
    //        BinaryAndF,
    //        BinaryOrF
    final private SubExpression leftExpression;
    private SubExpression rightExpression;
    final private SubType subType;

    private String string;
    // BinaryEqualRpF, '=', 'eq',   BinaryIsRpF,  '==', 'is',  BinaryAndF,   BinaryOrF
    public BinaryF(SubExpression left, SubExpression right, SubType type) {
        if (left == null) {
            throw new NullPointerException("Left expression is NULL!");
        }
        if (right == null) {
            throw new NullPointerException("Right expression is NULL!");
        }
        if (type == null) {
            throw new NullPointerException("Binary type is NULL!");
        }

        this.leftExpression = left;
        this.rightExpression = right;
        this.subType = type;
    }

    // RpEqualStringF
    public BinaryF(SubExpression left, String right, SubType type) {
        if (left == null) {
            throw new NullPointerException("Left expression is NULL!");
        }
        if (right == null) {
            throw new NullPointerException("String is NULL!");
        }
        if (type == null) {
            throw new NullPointerException("Binary type is NULL!");
        }

        this.leftExpression = left;
        this.string = right;
        this.subType = type;
    }

    private boolean checkEqual(List<Node> list1, List<Node> list2) {
        if (list1 == null) {
            throw new NullPointerException("List1 is NULL!");
        }
        if (list2 == null) {
            throw new NullPointerException("List2 is NULL!");
        }
        for(Node n : list1) {
            for(Node m : list2) {
                if(n.isEqualNode(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkSame(List<Node> list1, List<Node> list2) {
        if (list1 == null) {
            throw new NullPointerException("List1 is NULL!");
        }
        if (list2 == null) {
            throw new NullPointerException("List2 is NULL!");
        }
        for(Node n : list1) {
            for(Node m : list2) {
                if(n.isSameNode(m)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public SubType getExprType() {
        return this.subType;
    }

    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        List<Node> res = new ArrayList<>();
        switch (this.subType) {
            case BinaryEqualRpF:
                for(Node n : input) {
                    List<Node> left = leftExpression.eval(List.of(n));
                    List<Node> right = rightExpression.eval(List.of(n));
                    if(this.checkEqual(left, right)) {
                        res.add(n);
                    }
                }
                break;
            case BinaryIsRpF:
                for(Node n : input) {
                    List<Node> left = leftExpression.eval(List.of(n));
                    List<Node> right = rightExpression.eval(List.of(n));
                    if(this.checkSame(left, right)) {
                        res.add(n);
                    }
                }
                break;
            case BinaryAndF:
                List<Node> leftRes = leftExpression.eval(input);
                res = rightExpression.eval(leftRes);
                break;
            case BinaryOrF:
                for (Node n : input) {
                    if (!leftExpression.eval(List.of(n)).isEmpty() || !rightExpression.eval(List.of(n)).isEmpty()) {
                        res.add(n);
                    }
                }
                break;
            case RpEqualStringF:
                for (Node n : input) {
                    for (Node m : leftExpression.eval(List.of(n))) {
                        if (string.equals(m.getNodeValue())) {
                            res.add(n);
                            break;
                        }
                    }
                }
                break;
            default:
                throw new Exception("Evaluation error in " + this.subType);
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryF binaryF = (BinaryF) o;
        return Objects.equals(leftExpression, binaryF.leftExpression) && Objects.equals(rightExpression, binaryF.rightExpression) && subType == binaryF.subType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression, subType);
    }

    @Override
    public String toString() {
        return "BinaryF{" +
                "leftExpression=" + leftExpression +
                ", rightExpression=" + rightExpression +
                ", subType=" + subType +
                '}';
    }
}
