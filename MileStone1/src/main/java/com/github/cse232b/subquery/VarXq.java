package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

// Used also as a wrapper class for forXq/letXq Visit Func results
public class VarXq implements SubQuery{
    private final List<Node> nodes;

    public VarXq(List<Node> nodes) {
        if (nodes == null)
            throw  new NullPointerException("Missing nodes List" + this);
        this.nodes = nodes;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.nodes;
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.VarXq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarXq varXq = (VarXq) o;
        return nodes.equals(varXq.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes);
    }
}
