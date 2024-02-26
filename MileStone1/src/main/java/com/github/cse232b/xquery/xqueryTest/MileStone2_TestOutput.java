package com.github.cse232b.xquery.xqueryTest;

import com.github.cse232b.subquery.SubQuery;
import com.github.cse232b.xquery.ResultTransformerQ;
import com.github.cse232b.xquery.XQueryProcessor;
import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.List;

public class MileStone2_TestOutput {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Empty Command");
        }
        String inputPath = args[0], outputPath = args[1];
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputPath));
            StringBuilder query = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                query.append(str.replaceAll("\r\n|\r|\n", " "));
                query.append(" ");
            }
            XQueryProcessor xq = new XQueryProcessor();
            List<Node> result = xq.evaluate(query.toString());
            ResultTransformerQ transformerQ = new ResultTransformerQ();
            transformerQ.transform(result, outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
