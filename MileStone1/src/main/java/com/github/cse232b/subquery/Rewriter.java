package com.github.cse232b.subquery;

import com.github.cse232b.gen.XQueryGrammarParser;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class Rewriter {
    public String rewrite(XQueryGrammarParser.ForXqContext ctx) {
        StringBuilder sb = new StringBuilder();
        List<LinkedHashMap<String, String>> forMapList = new ArrayList<>();
        List<List<Pair<String, String>>> joinConditions = new ArrayList<>(); // For constructing Where clause
        for(int i = 0; i < ctx.for_().VAR().size(); i++) {
            String var = ctx.for_().VAR(i).getText();
            String xq = ctx.for_().xq(i).getText(), root = xq.split("/")[0];
            boolean newSubForQuery = true;
            for (int j = 0; j < forMapList.size(); j++) {
                LinkedHashMap<String, String> forMap = forMapList.get(j);
                // For example in query2, we hava "for $d1 in doc" and "$id1 in $d1/id/text()"
                // Here $d1 and $id1 are in the same subFor and hence be added to the same map
                if (forMap.containsKey(root)) {
                    newSubForQuery = false;
                    forMap.put(var, xq);
                    break;
                }
            }
            if (newSubForQuery) {
                LinkedHashMap<String, String> newForMap = new LinkedHashMap<>();
                newForMap.put(var, xq);
                forMapList.add(newForMap);
            }
        }
        if (forMapList.isEmpty()) {
            return "";
        }
        for (int i = 0; i < forMapList.size(); i++) {
            joinConditions.add(new ArrayList<>());
        }
        String[] whereClauses = ctx.where().cond().getText().split("and");
        for (String whereClause : whereClauses) {
            String[] vars = whereClause.split("=|eq");
            String leftVar = vars[0].strip(), rightVar = vars[1].strip();
            for (int i = 0; i < forMapList.size(); i++) {
                if (forMapList.get(i).containsKey(leftVar) || forMapList.get(i).containsKey(rightVar)) {
                    joinConditions.get(i).add(new Pair<>(leftVar, rightVar));
                }
            }
        }

        List<RewriterHandler> rewriterHandlers = new ArrayList<>();
        for (int i = 0; i < forMapList.size(); i++) {
            rewriterHandlers.add(new RewriterHandler(forMapList.get(i), joinConditions.get(i)));
        }

        return sb.toString();
    }
}
