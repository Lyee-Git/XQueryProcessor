package com.github.cse232b.subquery;

import com.github.cse232b.subexpr.SubExpression;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class BinaryRpXq implements SubQuery{
    private final SubQuery xq;
    private final SubExpression rp;
    private final QueryType queryType;

    public BinaryRpXq(SubQuery xq, SubExpression rp, QueryType queryType) {
        if (xq == null)
            throw  new NullPointerException("Missing xq" + this);
        if (rp == null)
            throw  new NullPointerException("Missing rp" + this);
        if (queryType == null)
            throw  new NullPointerException("Missing queryType" + this);
        this.xq = xq;
        this.rp = rp;
        this.queryType = queryType;
    }

    @Override
    public List<Node> evaluate(Document doc) throws Exception {
        List<Node> res = this.xq.evaluate(doc);
        if (this.queryType == QueryType.BinarySlashXq) {
            return new ArrayList<>(new HashSet<>(this.rp.eval(res)));
        } else if (this.queryType == QueryType.BinaryDslashXq) {
            List<Node> descentNodes = new ArrayList<>();
            getAllDescentNodes(res, descentNodes);
            return new ArrayList<>(new HashSet<>(this.rp.eval(descentNodes)));
        } else {
            throw new Exception("Unsupported queryType" + this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryRpXq that = (BinaryRpXq) o;
        return xq.equals(that.xq) && rp.equals(that.rp) && queryType == that.queryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xq, rp, queryType);
    }

    @Override
    public QueryType getQueryType() {
        return queryType;
    }
}
