package com.github.cse232b.xquery.xqueryTest;

import com.github.cse232b.subquery.SubQuery;
import com.github.cse232b.xpath.ResultTransformer;
import com.github.cse232b.xquery.ResultTransformerQ;
import com.github.cse232b.xquery.XQueryProcessor;
import org.w3c.dom.Node;

import java.util.List;

public class MileStone2_Test {
    public static void main(String[] args) throws Exception {
        String query;
        XQueryProcessor xq = new XQueryProcessor();
        List<Node> res = List.of();

        query = "<acts> { for $a in doc(\"j_caesar.xml\")//ACT\n where not empty ( for $sp in $a/SCENE/SPEECH\n where \n" +
                "($sp/SPEAKER/text() = \"FLAVIUS\" and $sp/../TITLE/text()=\"SCENE I.  Rome. A street.\") return \n" +
                "<speaker> {\n $sp/text() }\n</speaker> ) return <act>{$a/TITLE/text()}</act> }</acts>\n";
        res = xq.evaluate(query);

        System.out.printf("total results: %d\n", res.size());
        new ResultTransformerQ().transform(res);
    }
}

