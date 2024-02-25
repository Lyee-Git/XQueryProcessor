package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ParenthXq implements SubQuery {
    private final SubQuery xq;

    public ParenthXq(SubQuery xq) {
        if (xq == null)
            throw  new NullPointerException("Missing subQuery" + this);
        this.xq = xq;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return this.xq.evaluate(doc);
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.ParenthXq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParenthXq parenthXq = (ParenthXq) o;
        return xq.equals(parenthXq.xq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xq);
    }
}
