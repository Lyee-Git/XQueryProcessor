package com.github.cse232b.subexpr;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BinaryRp implements SubExpression {
    final private SubExpression leftExpression;
    final private SubExpression rightExpression;
    final private SubType subType;

    public BinaryRp(SubExpression left, SubExpression right, SubType type) {
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

    @Override
    public SubType getExprType() {
        return this.subType;
    }

    //        BinarySlashRp,
    //        BinaryDslashRp,
    //        BinaryCombineRp,
    //        FilterRp,
    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        List<Node> leftRes = leftExpression.eval(input);
        switch (this.subType) {
            case SlashAp:
                return new ArrayList<>(new HashSet<>(rightExpression.eval(leftRes)));
            case DslashAp:
                List<Node> descendentsOutput = new ArrayList<>();
                getDescendants(leftRes, descendentsOutput);
                return new ArrayList<>(new HashSet<>(rightExpression.eval(descendentsOutput)));
            case BinaryCombineRp:
                // combine the two expressions together
                boolean success = leftRes.addAll(rightExpression.eval(input));
                if(success) {
                    return leftRes;
                }
                return null;
            case FilterRp:
                // rightExpression is a filter expression
                return this.rightExpression.eval(leftRes);
            default:
                throw new Exception("Evaluation error in " + this.subType);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryRp binaryRp = (BinaryRp) o;
        return Objects.equals(leftExpression, binaryRp.leftExpression) && Objects.equals(rightExpression, binaryRp.rightExpression) && subType == binaryRp.subType;
    }

    @Override
    public String toString() {
        return "" + this.leftExpression + this.subType + this.rightExpression;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression, subType);
    }
}
