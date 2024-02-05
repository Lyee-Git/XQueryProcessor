package com.github.cse232b.subexpr;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApPath implements SubExpression {

    final private String doc;
    final private SubType subType;
    final private SubExpression subExpression;

    public ApPath(String doc, SubType type, SubExpression expression) {
        if (doc == null) {
            throw new NullPointerException("Doc is NULL!");
        }
        if (type == null) {
            throw new NullPointerException("Slash content is NULL!");
        }
        if (expression == null) {
            throw new NullPointerException("Relative path is NULL!");
        }

        this.doc = doc;
        this.subType = type;
        this.subExpression = expression;
    }

    @Override
    public SubType getExprType() {
        return this.subType;
    }

    @Override
    public List<Node> eval(List<Node> input) throws Exception {
        if(this.subType == SubType.SlashAp) {
            return subExpression.eval(input);
        } else {
            List<Node> output = new ArrayList<>();
            getDescendants(input, output);
            return subExpression.eval(output);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApPath apPath = (ApPath) o;
        return Objects.equals(doc, apPath.doc) && subType == apPath.subType && Objects.equals(subExpression, apPath.subExpression);
    }

    public String getDoc() {
        return doc;
    }

    @Override
    public String toString() {
        return this.doc + this.subType + this.subExpression;
    }

    @Override
    public int hashCode() {
        return Objects.hash(doc, subType, subExpression);
    }

}
