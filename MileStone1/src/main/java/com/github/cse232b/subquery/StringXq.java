package com.github.cse232b.subquery;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class StringXq implements SubQuery{
    private final String string;

    public StringXq(String string) {
        if (string == null)
            throw new NullPointerException("Missing subQuery" + this);
        this.string = string;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        return List.of(makeText(doc, this.string));
    }

    @Override
    public QueryType getQueryType() {
        return QueryType.StringXq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringXq stringXq = (StringXq) o;
        return string.equals(stringXq.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
