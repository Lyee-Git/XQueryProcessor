package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TagXq implements SubQuery{
    private final String tagName;
    private final SubQuery xq;

    public TagXq(String tagName, SubQuery xq) {
        if (xq == null)
            throw  new NullPointerException("Missing subQuery" + this);
        if (tagName == null)
            throw  new NullPointerException("Missing String" + this);
        this.tagName = tagName;
        this.xq = xq;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> queryRes = xq.evaluate(doc);
        Node node = makeElement(doc, tagName, queryRes);
        return List.of(node);
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.TagXq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagXq tagXq = (TagXq) o;
        return tagName.equals(tagXq.tagName) && xq.equals(tagXq.xq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagName, xq);
    }
}
