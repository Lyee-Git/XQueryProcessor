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
        List<Node> res;
        String outputPath = "MileStone1/src/main/resources/output";

        query = "for $q1 in doc(\"j_caesar.xml\")//ACT,\n" +
                "                  $q2 in doc(\"j_caesar.xml\")//ACT,\n" +
                "                  $sa in $q1//SCENE,\n" +
                "                  $sb in $q2//SCENE,\n" +
                "                  $spa in $sa//SPEAKER,\n" +
                "                  $spb in $sa//SPEAKER/text(),\n" +
                "                  $spc in $sb//SPEAKER,\n" +
                "                  $spd in $sb//SPEAKER/text(),\n" +
                "                  $spea in $sa//SPEECH,\n" +
                "                  $speb in $sb//SPEECH,\n" +
                "                  $spec in $sa//SPEECH,\n" +
                "                  $sped in $sb//SPEECH\n" +
                "                where $spb=\"FLAVIUS\" and $spd=\"FLAVIUS\" and $sa eq $sb and $spa eq $spc and $speb eq $spec and $spea eq $sped\n" +
                "                return <result>{ <title>{$sa/TITLE/text()}</title>, <speaker>{$spa/*}</speaker> }</result>";
        res = xq.evaluate(query);

        System.out.printf("total results: %d\n", res.size());
        new ResultTransformerQ().transform(res);
    }
}

