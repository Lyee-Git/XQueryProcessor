package com.github.cse232b.subquery;

import org.antlr.v4.runtime.misc.Pair;

import java.util.*;

public class RewriterHandler {
    // for var in xq, maps each (var -> xq)
    // Use LinkedHashMap to record the order of variables in query
    private final LinkedHashMap<String, String> forMap = new LinkedHashMap<>();
    private final List<Pair<String, String>> conditions = new ArrayList<>();

    public RewriterHandler(LinkedHashMap<String, String> forMap, List<Pair<String, String>> conditions) {
        this.forMap.putAll(forMap);
        this.conditions.addAll(conditions);
    }

    public String rewriteToString() {
        StringBuilder forSb = new StringBuilder("for ");
        StringBuilder whereSb = new StringBuilder("where ");
        StringBuilder returnSb = new StringBuilder("return ");

        for (Map.Entry<String, String> entry : this.forMap.entrySet()) {
            String var = entry.getKey(), xq = entry.getValue();
            forSb.append(var); forSb.append(" ");
            forSb.append("in");forSb.append(" ");
            forSb.append(xq);forSb.append(",\n");
        }
        // remove one extra comma
        if (!forSb.isEmpty()) {
            forSb.deleteCharAt(forSb.length() - 2);
        }

        // Could perform selection push-down when the predicate only refer to var in one table
        boolean pushDown = false;
        for (Pair<String, String> pair : this.conditions) {
            String root1 = pair.a.split("/")[0];
            String root2 = pair.b.split("/")[0];
            if((this.forMap.containsKey(root1) && this.forMap.containsKey(root2)) ||
                    (this.forMap.containsKey(root1) && !root2.startsWith("$")) ||
                    (this.forMap.containsKey(root2) && !root1.startsWith("$"))) {
                if(!pushDown) {
                    pushDown = true;
                }
                whereSb.append(pair.a);
                whereSb.append(" eq ");
                whereSb.append(pair.b);
                whereSb.append(",\n");
            }
        }
        if (!whereSb.isEmpty() && pushDown) {
            whereSb.deleteCharAt(whereSb.length()-2);
        }

        returnSb.append("<tuple>{\n");
        for (Map.Entry<String, String> entry : this.forMap.entrySet()) {
            String var = entry.getKey(), varName = var.substring(1);
            returnSb.append("<").append(varName).append(">{");
            returnSb.append(var);
            returnSb.append("}<").append("/").append(varName).append(">");
            returnSb.append(",\n");
        }
        returnSb.deleteCharAt(returnSb.length() - 2);
        returnSb.append("}</tuple>,\n");

        return forSb.toString() + (pushDown ? whereSb.toString() : "") + returnSb.toString();
    }
}
