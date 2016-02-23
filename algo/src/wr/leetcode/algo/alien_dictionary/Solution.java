package wr.leetcode.algo.alien_dictionary;

import java.util.*;

public class Solution {
    /*
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
    }*/

    public String alienOrder(String[] words) {
        words = (null == words)?(new String[0]):(words);
        Set<Character> dict = new HashSet<>();
        for (String w : words) {
            char[] arr = w.toCharArray();
            for (char ch : arr) {
                dict.add(ch);
            }
        }
        Set<Character> start = new HashSet<>(dict);

        Map<Character, Set<Character>> edges = new HashMap<>();
        Map<Character, Set<Character>> incomings = new HashMap<>();

        int n = words.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                String left = words[i];
                String right = words[j];
                int k = 0;
                while (k < left.length() && k < right.length()) {
                    char src = left.charAt(k);
                    char dest = right.charAt(k);
                    if (src == dest) {
                        k++;
                    } else {
                        start.remove(dest);

                        Set<Character> dests = edges.getOrDefault(src, new HashSet<>());
                        dests.add(dest);
                        edges.put(src, dests);

                        Set<Character> incoming = incomings.getOrDefault(dest, new HashSet<>());
                        incoming.add(src);
                        incomings.put(dest, incoming);
                        break;
                    }
                }
            }
        }
        return toplogicalSort(start, edges, incomings, dict.size());

    }

    String toplogicalSort(Set<Character> start, Map<Character, Set<Character>> outs, Map<Character, Set<Character>> ins, int n ) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character ch : start) {
            queue.offer(ch);
        }

        while(!queue.isEmpty()) {
            Character v = queue.poll();
            sb.append(v);
            Set<Character> nvs = outs.getOrDefault(v, new HashSet<>());
            for (Character nv : nvs) {
                Set<Character> nvSrcs = ins.get(nv);
                nvSrcs.remove(v);
                if (nvSrcs.isEmpty()) {
                    ins.remove(nv);
                    queue.offer(nv);
                }
            }
        }

        if (sb.length() < n ) {
            sb.setLength(0);
        }

        return sb.toString();
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
        System.out.println(sol.alienOrder(words));
    }
}
