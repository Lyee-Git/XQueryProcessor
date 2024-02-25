package com.github.cse232b.subquery;

import com.github.cse232b.subexpr.SubExpression;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.management.Query;
import java.util.List;
import java.util.Objects;

// Cond1 and Cond2 | Cond1 or Cond2 | XQ1 = XQ2 | XQ1 eq XQ2 | XQ1 == XQ2 | XQ1 is XQ2
public class BinaryCond implements SubQuery{
    private final SubQuery leftExpression;
    private final SubQuery rightExpression;
    private final SubQuery.QueryType queryType;
    public BinaryCond(SubQuery left, SubQuery right, QueryType type) {
        if (left == null) {
            throw new NullPointerException("Left expression is NULL!");
        }
        if (right == null) {
            throw new NullPointerException("Right expression is NULL!");
        }
        if (type == null) {
            throw new NullPointerException("Query type is NULL!");
        }

        this.leftExpression = left;
        this.rightExpression = right;
        this.queryType = type;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> leftRes = this.leftExpression.evaluate(doc);
        List<Node> rightRes = this.rightExpression.evaluate(doc);
        switch (this.queryType) {
            case AndCond -> {
                if(null != leftRes && null != rightRes) {
                    return List.of();
                }
            }
            case OrCond -> {
                if(null != leftRes || null != rightRes) {
                    return List.of();
                }
            }
            case BinaryEqualCond -> {
                for(Node n : leftRes) {
                    for(Node m : rightRes) {
                        if(n.isEqualNode(m)) {
                            return List.of();
                        }
                    }
                }
            }
            case BinaryIsCond -> {
                for(Node n : leftRes) {
                    for(Node m : rightRes) {
                        if(n.isSameNode(m)) {
                            return List.of();
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public QueryType getQueryType() {
        return this.queryType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryCond that = (BinaryCond) o;
        return Objects.equals(leftExpression, that.leftExpression) && Objects.equals(rightExpression, that.rightExpression) && queryType == that.queryType;
    }

    @Override
    public String toString() {
        return "BinaryCond{" +
                "leftExpression=" + leftExpression +
                ", rightExpression=" + rightExpression +
                ", queryType=" + queryType +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression, rightExpression, queryType);
    }
}
