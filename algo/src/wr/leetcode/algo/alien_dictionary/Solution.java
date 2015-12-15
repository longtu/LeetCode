package wr.leetcode.algo.alien_dictionary;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        try {
            Set<ArrayList<Character>> edges = edges(words);
            List<Character> order = toplogicalSort(edges, words);
            //Set<Character> chars = chars(words);
            //if(chars.size() == order.size()) {
            for (Character ch : order) {
                sb.append(ch);
            }
            //}
        } catch (Exception e) {
            //do nothing to escape from invalid edge input
        }
        return sb.toString();
    }

    //BUG: the toplogical sort should include characters not in edges
    List<Character> toplogicalSort(Set<ArrayList<Character>> edges, String[] words) {
        Map<Character, List<Character>> outs = new HashMap<>();
        Map<Character, Integer> incomings = new HashMap<>();

        for (ArrayList<Character> edge : edges) {
            Character s = edge.get(0);
            Character e = edge.get(1);

            int inCnt = incomings.getOrDefault(e, 0) + 1;
            incomings.put(e, inCnt);

            List<Character> out = outs.getOrDefault(s, new LinkedList<>());
            out.add(e);
            outs.put(s, out);
        }


        List<Character> zeroIns = new LinkedList<>();
        Set<Character> chars = chars(words);
        //BUG: originally only check for edges, will have no zeroIns
        for ( Character ch : chars) {
            if(!incomings.containsKey(ch)) {
                zeroIns.add(ch);
            }
        }

        List<Character> order = new LinkedList<>();
        while(!zeroIns.isEmpty()) {
            Character s = zeroIns.remove(0);
            order.add(s);
            for (char e : outs.getOrDefault(s, new LinkedList<>())) {
                int cnt = incomings.getOrDefault(e, 0) - 1;
                if(0 == cnt) {
                    zeroIns.add(e);
                }
                //BUG: FORGOT TO UPDATE MAP
                incomings.put(e, cnt);
            }
        }
        if(order.size() != chars.size()) {
            order = new LinkedList<>();
        }

        return order;
    }


    Set<Character> chars (String [] words) {
        Set<Character> chars = new HashSet<>();
        for (String w : words) {
            for (char ch : w.toCharArray()) {
                if(!chars.contains(ch)) {
                    chars.add(ch);
                }
            }
        }
        return chars;
    }

    Set<ArrayList<Character>> edges ( String[] words ) {
        Set<ArrayList<Character>> edges = new HashSet<>();
        if( null == words) {
            words = new String[0];
        }
        for (int i = 0; i < words.length; ++i) {
            for (int j = i+1; j < words.length; ++j) {
                ArrayList<Character> edge = edge(words[i], words[j]);
                if(null != edge) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }

    ArrayList<Character> edge( String left, String right) {
        ArrayList<Character> edge = null;
        left = notNull(left);
        right = notNull(right);

        int i = 0;
        //left should always be smaller than right
        //BUG: input might be insane and right length > left > length
        while (i < left.length() && i < right.length() && left.charAt(i) == right.charAt(i)) {
            i++;
        }
        //add check here to escape from right length equal
        if( i != left.length()){
            edge = new ArrayList<>(2);
            edge.add(left.charAt(i));
            edge.add(right.charAt(i));
        }
        return edge;
    }


    String notNull(String str) {
        return (null == str)? ("") : str;
    }

    public static void main(String[] args) {
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        String[] words2 = {
                "l","wdhfgbdt","vzd","qqddytlfd","jj","vw","kkeqazf","pmc","eezyjdkmdf","pe","aphr","jhmdv","gemcj","q","ucpnquufb","jdilhilfn"
        };
        Solution sol = new Solution();
        System.out.println(sol.alienOrder(words2));
    }
}
