package com.github.cse232b.subquery;

import com.github.cse232b.gen.XQueryGrammarParser;
import com.github.cse232b.xquery.XQueryProcessor;
import org.junit.Test;
import org.w3c.dom.Node;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class M3Test {
    @Test
    public void m3test5() throws Exception {
        String query;
        XQueryProcessor xq = new XQueryProcessor();

        query = """
                for $a in doc("j_caesar.xml")//ACT,
                    $b in doc("j_caesar.xml")//ACT,
                    $sa in $a//SCENE,
                    $sb in $b//SCENE,
                    $spa in $sa//SPEAKER,
                    $spb in $sb//SPEAKER/text(),
                    $spc in $sb//SPEAKER
                                
                where $spb="FLAVIUS" and $sa eq $sb and $spa eq $spc
                                
                return <result>{ <title>{$sa/TITLE/text()}</title> }</result>
                """;
        long t1 = System.currentTimeMillis();
        List<Node> result1 = xq.evaluate(query);
        long t2 = System.currentTimeMillis();
        System.out.printf("returned results: %d\n", result1.size());

        Rewriter r = new Rewriter();
        String rewritten = r.rewrite((XQueryGrammarParser.ForXqContext)xq.getGrammarParser(query).xq());
        String expected = """
                for $tuple in join (for $a in doc("j_caesar.xml")//ACT,
                $sa in $a//SCENE,
                $spa in $sa//SPEAKER
                return <tuple>{
                <a>{$a}</a>,
                <sa>{$sa}</sa>,
                <spa>{$spa}</spa>
                }</tuple>,
                for $b in doc("j_caesar.xml")//ACT,
                $sb in $b//SCENE,
                $spb in $sb//SPEAKER/text(),
                $spc in $sb//SPEAKER
                where $spb eq "FLAVIUS"
                return <tuple>{
                <b>{$b}</b>,
                <sb>{$sb}</sb>,
                <spb>{$spb}</spb>,
                <spc>{$spc}</spc>
                }</tuple>,
                [sa,spa], [sb,spc]
                )
                return
                <result>{<title>{$tuple/sa/*/TITLE/text()}</title>}</result>""";
        assertEquals(expected, rewritten);
        long t3 = System.currentTimeMillis();
        List<Node> result2 = xq.evaluate(rewritten);
        long t4 = System.currentTimeMillis();

        assertEquals(result1.size(), result2.size());
        System.out.printf("nested loop join time: %d\n", t2 - t1);
        System.out.printf("hash join time: %d\n", t4 - t3);
    }
}
