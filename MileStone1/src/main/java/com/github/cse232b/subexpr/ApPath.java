package com.github.cse232b.subexpr;

import org.w3c.dom.Node;

import java.util.List;
import java.util.Objects;

public class ApPath implements SubExpression {

    final private String doc;
    final private SubType subType;
    final private SubExpression subExpression;

    public ApPath(String doc, SubType type, SubExpression Expression) {
        Objects.requireNonNull(doc, "Doc is NULL!");
        Objects.requireNonNull(type, "Slash content is NULL!");
        Objects.requireNonNull(Expression, "Relative path is NULL!");
        this.doc = doc;
        this.subType = type;
        this.subExpression = Expression;
    }

    @Override
    public SubType getExprType() {
        return this.subType;
    }

    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApPath apPath = (ApPath) o;
        return Objects.equals(doc, apPath.doc) && subType == apPath.subType && Objects.equals(subExpression, apPath.subExpression);
    }

    @Override
    public String toString() {
        return "ApPath{" +
                "doc='" + doc + '\'' +
                ", subType=" + subType +
                ", subExpression=" + subExpression +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(doc, subType, subExpression);
    }

}
