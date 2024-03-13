package com.github.cse232b.subquery;

import com.github.cse232b.gen.XQueryGrammarParser;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rewriter {
    public String rewrite(XQueryGrammarParser.ForXqContext ctx) {
        StringBuilder res = new StringBuilder();
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
        Set<Integer> joined = new HashSet<>(); // Set of SubFor queries that have been processed
        Set<String> curVarsJoined = new HashSet<>(forMapList.get(0).keySet());
        joined.add(0);
        res.append(rewriterHandlers.get(0).rewriteToString());
        // iterate over forMapList to find SubFor query with matched variable
        while (joined.size() != forMapList.size()) {
            boolean addNew = false;
            for (int i = 0; i < forMapList.size(); i++) {
                if (joined.contains(i)) {
                    continue;
                }
                LinkedHashMap<String, String> curForMap = forMapList.get(i);
                List<String> leftVars = new ArrayList<>();
                List<String> rightVars = new ArrayList<>();
                for(Pair<String, String> pair : joinConditions.get(i)) {
                    String left = pair.a, right = pair.b;
                    if (curVarsJoined.contains(left) && curForMap.containsKey(right)) {
                        leftVars.add(left);
                        rightVars.add(right);
                    } else if (curVarsJoined.contains(right) && curForMap.containsKey(left)) {
                        leftVars.add(right);
                        rightVars.add(left);
                    }
                }
                if (!leftVars.isEmpty() && !rightVars.isEmpty()) {
                    joined.add(i);
                    addNew = true;
                    curVarsJoined.addAll(forMapList.get(i).keySet());
                    res.insert(0, "join (");
                    res.append(rewriterHandlers.get(i).rewriteToString());
                    res.append("[");
                    // Join Condition Format: [af22, al22], [af3, al3] (remove '$' and extra comma)
                    for(String left : leftVars) {
                        res.append(left.substring(1));  res.append(",");
                    }
                    res.deleteCharAt(res.length()-1);  // remove last comma
                    res.append("], [");
                    for(String right : rightVars) {
                        res.append(right.substring(1));  res.append(",");
                    }
                    res.deleteCharAt(res.length()-1);
                    res.append("]\n),\n");
                }
            }
            if (!addNew) {
                int indexToAdd = -1;
                for (int i = 0; i < forMapList.size(); i++) {
                    if (!joined.contains(i)) {
                        indexToAdd = i;
                        break;
                    }
                }
                // Here we find some variable group/table is isolated, and we still need to rewrite into a
                // join operation (even if the arguments that specified the join are actually empty)
                if (indexToAdd != -1) {
                    curVarsJoined.addAll(forMapList.get(indexToAdd).keySet());
                    joined.add(indexToAdd);
                    res.insert(0, "join (");
                    res.append(rewriterHandlers.get(indexToAdd).rewriteToString());
                    res.append("[], []\n),\n");
                }
            }
        }
        res.deleteCharAt(res.length() - 2);
        res.insert(0, "for $tuple in ");

        // Example for Return Clause processing:
        // return
        //  <book-with-prices>
        //      { $tb,
        //        <price-review>{ $a/price }</price-review>,
        //        <price>{ $b/price }</price> }
        //  </book-with-prices>

        // ---->>> convert to

        // return
        //<book-with-prices>
        //  { $tuple/tb/*,
        //      <price-review>{ $tuple/a/*/price }</price-review>,
        //      <price>{ $tuple/b/*/price }</price> }
        //</book-with-prices>
        String returnClause = ctx.return_().xq().getText();
        Set<String> returnVars = new HashSet<>();
        int find = -1;
        while ((find = returnClause.indexOf('$', find + 1)) != -1) {
            int end;
            for (end = find; end < returnClause.length(); end++) {
                char c = returnClause.charAt(end);
                if (c == ',' || c == '/' || c == ' ' || c == '}') {
                    returnVars.add(returnClause.substring(find, end));
                    find = end;
                    break;
                }
            }
        }
        for (String returnVar : returnVars) {
            String regex = Pattern.quote("$" + returnVar.substring(1));
            String replacement = Matcher.quoteReplacement("$tuple/" + returnVar.substring(1) + "/*");
            returnClause = returnClause.replaceAll(regex, replacement);
        }
        res.append("return\n");
        res.append(returnClause);
        return res.toString();
    }
}
