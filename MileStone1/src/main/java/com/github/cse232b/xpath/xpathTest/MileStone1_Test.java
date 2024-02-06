package com.github.cse232b.xpath.xpathTest;

import com.github.cse232b.xpath.ResultTransformer;
import com.github.cse232b.xpath.XPathProcessor;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class MileStone1_Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Tests start for XPath Processor");
        XPathProcessor xPathProcessor = new XPathProcessor();
        List<String> queries = new ArrayList<>();
        List<Node> res;
//        queries.add("doc(\"j_caesar.xml\")//PERSONA");
//       queries.add("doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"]");
//        queries.add("doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\" and SPEECH/SPEAKER/text()=\"BRUTUS\"]]");
//       queries.add("doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text()=\"CAESAR\"] [SPEECH/SPEAKER/text()=\"BRUTUS\"]]");
        queries.add("doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text()=\"CAESAR\"]");
        for (int i = 0; i < queries.size(); i++) {
            System.out.println("Testcase " + i + " starts:");
            String q = queries.get(i);
            res = xPathProcessor.evaluate(q);
            new ResultTransformer().transform(res);
        }
    }
}
