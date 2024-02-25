package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class SatCond implements SubQuery{
    private final boolean flag;
    public SatCond(List<Node> expressionsList) {
        this.flag = (expressionsList == null);
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.flag ? null : List.of();
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.SatCond;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SatCond satCond = (SatCond) o;
        return flag == satCond.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag);
    }

    @Override
    public String toString() {
        return "SatCond{" +
                "flag=" + flag +
                '}';
    }
}
