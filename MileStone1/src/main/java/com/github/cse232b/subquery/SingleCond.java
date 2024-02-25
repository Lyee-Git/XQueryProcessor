package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.management.Query;
import java.util.List;
import java.util.Objects;

// empty(XQ1) | not Cond1
public class SingleCond implements SubQuery{
    private final SubQuery expression;
    private final QueryType queryType;

    public SingleCond(SubQuery expression, QueryType type) {
        if (type == null) {
            throw new NullPointerException("Missing QueryType" + this);
        }
        if (expression == null) {
            throw new NullPointerException("Missing Expression " + this);
        }
        this.expression = expression;
        this.queryType = type;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.expression.evaluate(doc);
        switch (this.queryType) {
            case EmpCond -> {
                if(null == res || res.isEmpty()) {
                    return List.of();
                }
            }
            case NotCond -> {
                if(null == res) {
                    return List.of();
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
        SingleCond that = (SingleCond) o;
        return Objects.equals(expression, that.expression) && queryType == that.queryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression, queryType);
    }

    @Override
    public String toString() {
        return "SingleCond{" +
                "expression=" + expression +
                ", queryType=" + queryType +
                '}';
    }
}
