package com.github.cse232b.xquery.xqueryTest;

import com.github.cse232b.gen.XQueryGrammarParser;
import com.github.cse232b.subquery.Rewriter;
import com.github.cse232b.xquery.ResultTransformerQ;
import com.github.cse232b.xquery.XQueryProcessor;
import org.w3c.dom.Node;

import java.io.*;
import java.util.List;

/**
 * @author Lyee
 * @date 3/14/2024
 * @Description
 */
public class MileStone3_Test {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new Exception("Empty Command");
        }
        String inputPath = args[args.length - 2], outputPath = args[args.length - 1];
        BufferedReader in = new BufferedReader(new FileReader(inputPath));
        StringBuilder query = new StringBuilder();
        String str;
        while ((str = in.readLine()) != null) {
            query.append(str.replaceAll("\r\n|\r|\n", " "));
            query.append(" ");
        }
        XQueryProcessor xq = new XQueryProcessor();

        Rewriter rewriter = new Rewriter();
        String rewritten = rewriter.rewrite((XQueryGrammarParser.ForXqContext)xq.getGrammarParser(query.toString()).xq());
        BufferedWriter output = null;
        File file = new File(outputPath + "/rewriteOutput.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        output = new BufferedWriter(new FileWriter(file));
        output.write(rewritten);
        output.close();
        System.out.print("output rewritten result in rewriteOutput.txt");
        try {
            long t1 = System.currentTimeMillis();
            List<Node> result = xq.evaluate(rewritten);
            long t2 = System.currentTimeMillis();
            System.out.printf("returned results: %d\n", result.size());
            System.out.printf("Query execution time: %d ms\n", t2 - t1);
            ResultTransformerQ transformerQ = new ResultTransformerQ();
            transformerQ.transform(result, outputPath + "/Test1_output.rtf");
        } catch (IOException e) {
            System.err.println("Failed to read file: " + inputPath);
            System.err.println(e);
            System.exit(2);
        }
    }
}
