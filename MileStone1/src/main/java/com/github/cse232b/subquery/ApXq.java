package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ApXq implements SubQuery{
    private final List<Node> apNodes;

    public ApXq(List<Node> apNodes) {
        if (apNodes == null)
            throw  new NullPointerException("Missing nodeList" + this);
        this.apNodes = apNodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApXq apXq = (ApXq) o;
        return Objects.equals(apNodes, apXq.apNodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apNodes);
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.apNodes;
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.ApXq;
    }
}
