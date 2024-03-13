package com.github.cse232b.xquery.xqueryTest;

import com.github.cse232b.gen.XQueryGrammarParser;
import com.github.cse232b.subquery.Rewriter;
import com.github.cse232b.xquery.XQueryProcessor;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class MileStone3_Rewriter_Test {

    public static void main(String[] args) throws Exception {
        XQueryProcessor xq = new XQueryProcessor();
        List<String> queries = new ArrayList<>();
        queries.add("for $s in doc(\"j_caesar.xml\")//SPEAKER, $a in doc(\"j_caesar.xml\")//ACT,\n" +
                "\n" +
                "$sp in $a//SPEAKER, $stxt in $s/text()\n" +
                "\n" +
                "where $sp eq $s and $stxt = \"CAESAR\"\n" +
                "\n" +
                "return <act> { $a/TITLE/text()} </act>");
        queries.add("for $d1 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d2 in doc(\"large-data.xml\")/data/d,\n" +
                "    $id1 in $d1/id/text(),\n" +
                "    $id2 in $d2/id/text(),\n" +
                "    $a1 in $d1/a2/text(),\n" +
                "    $a2 in $d2/a6/text()\n" +
                "where $a1 eq $a2\n" +
                "return <d>{<id1>{$id1}</id1>,<id2>{$id2}</id2>}</d>");
        queries.add("for $d1 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d2 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d3 in doc(\"large-data.xml\")/data/d,\n" +
                "    $id1 in $d1/id/text(),\n" +
                "    $id2 in $d2/id/text(),\n" +
                "    $id3 in $d3/id/text(),\n" +
                "    $a1 in $d1/a4/text(),\n" +
                "    $a2 in $d2/a6/text(),\n" +
                "    $a3 in $d3/a9/text()\n" +
                "where $a1 eq $a2 and $a2 eq $a3\n" +
                "return <d>{<id1>{$id1}</id1>,<id2>{$id2}</id2>,<id3>{$id3}</id3>}</d>\n");
        queries.add("for $d1 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d2 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d3 in doc(\"large-data.xml\")/data/d,\n" +
                "    $d4 in doc(\"large-data.xml\")/data/d,\n" +
                "    $id1 in $d1/id/text(),\n" +
                "    $id2 in $d2/id/text(),\n" +
                "    $id3 in $d3/id/text(),\n" +
                "    $id4 in $d4/id/text(),\n" +
                "    $a1 in $d1/a1/text(),\n" +
                "    $a2 in $d2/a6/text(),\n" +
                "    $a3 in $d3/a2/text(),\n" +
                "    $a4 in $d4/a5/text()\n" +
                "where $a1 eq $a2 and $a3 eq $a4 and $a1 eq $a3\n" +
                "return <d>{<id1>{$id1}</id1>,<id2>{$id2}</id2>,<id3>{$id3}</id3>,<id4>{$id4}</id4>}</d>\n");
        queries.add("for $b1 in doc(\"input\")/book,\n" +
                "$aj in $b1/author/first/text(),\n" +
                "$a1 in $b1/author,\n" +
                "$af1 in $a1/first,\n" +
                "$al1 in $a1/last,\n" +
                "$b2 in doc(\"input\")/book,\n" +
                "$a21 in $b2/author,\n" +
                "$af21 in $a21/first,\n" +
                "$al21 in $a21/last,\n" +
                "$a22 in $b2/author,\n" +
                "$af22 in $a22/first,\n" +
                "$al22 in $a22/last,\n" +
                "$b3 in doc(\"input\")/book,\n" +
                "$a3 in $b3/author,\n" +
                "$af3 in $a3/first,\n" +
                "$al3 in $a3/last\n" +
                "where $aj eq \"John\" and\n" +
                "$af1 eq $af21 and $al1 eq $al21 and\n" +
                "$af22 eq $af3 and $al22 eq $al3\n" +
                "return <triplet> {$b1, $b2, $b3} </triplet>");
        queries.add("for $b in doc(\"input\")/book,\n" +
                "$a in doc(\"input\")/entry\n" +
                "\n" +
                "return\n" +
                "<book-with-prices>\n" +
                "{\n" +
                "<price-review>{ $a/price }</price-review>,\n" +
                "<price>{ $b/price }</price> }\n" +
                "</book-with-prices>");
        for (int i = 0; i < queries.size(); i++) {
            String query = queries.get(i);
            System.out.printf("Test case %d starts:\n", i + 1);
//            long t1 = System.currentTimeMillis();
//            List<Node> result = xq.evaluate(query);
//            long t2 = System.currentTimeMillis();
//            System.out.printf("Execution time without Join: %d\n", t2 - t1);
            Rewriter rewriter = new Rewriter();
            String rewritten = rewriter.rewrite((XQueryGrammarParser.ForXqContext)xq.getGrammarParser(query).xq());
            System.out.println("Query after rewriting:");
            System.out.println(rewritten);

// TODO: Test after Join implemented
//        long t3 = System.currentTimeMillis();
//        List<Node> resultJoin = xq.evaluate(rewritten);
//        long t4 = System.currentTimeMillis();
//        System.out.printf("Execution time with Join: %d\n", t4 - t3);
        }
    }
}
