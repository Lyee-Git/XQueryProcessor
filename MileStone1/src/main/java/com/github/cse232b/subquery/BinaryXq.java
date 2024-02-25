package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class BinaryXq implements SubQuery{
    private final SubQuery xq1;
    private final SubQuery xq2;

    public BinaryXq(SubQuery xq1, SubQuery xq2) {
        if (xq1 == null)
            throw  new NullPointerException("Missing subQuery" + this);
        if (xq2 == null)
            throw  new NullPointerException("Missing subQuery2" + this);
        this.xq1 = xq1;
        this.xq2 = xq2;
    }

    // just combine results from both Xqueries
    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.xq1.evaluate(doc);
        res.addAll(this.xq2.evaluate(doc));
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryXq binaryXq = (BinaryXq) o;
        return xq1.equals(binaryXq.xq1) && xq2.equals(binaryXq.xq2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xq1, xq2);
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.BinaryCombineXq;
    }
}
