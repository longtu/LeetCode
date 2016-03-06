package wr.leetcode.algo.reconstruct_itinerary;

import java.util.*;

public class Solution {

    LinkedList<String> res;
    Map<String, PriorityQueue<String>> mp;


    /**
     * The graph must be Eulerian since we know that a Eulerian path exists: the man’s real itinerary.
     Thus, start from “JFK”, we can apply the Hierholzer’s algorithm to find a Eulerian path in the graph
     which is a valid reconstruction.

     Since the problem asks for lexical order smallest solution,
     we can put the neighbors in a min-heap.
     In this way, we always visit the smallest possible neighbor first in our trip.

     */
    public List<String> findItineraryOptimal(String[][] tickets) {
        if (tickets==null || tickets.length==0) return new LinkedList<String>();
        res = new LinkedList<String>();
        mp = new HashMap<String, PriorityQueue<String>>();
        for (String[] ticket : tickets) {
            if (!mp.containsKey(ticket[0])) {
                mp.put(ticket[0], new PriorityQueue<String>());
            }
            mp.get(ticket[0]).offer(ticket[1]);
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String cur) {
        while (mp.containsKey(cur) && !mp.get(cur).isEmpty()) {
            dfs(mp.get(cur).poll());
        }
        res.addFirst(cur);
    }


    public List<String> findItinerary(String[][] tickets) {

        List<String> ret = new LinkedList<>();

        if (null != tickets && tickets.length > 0) {
            Arrays.sort(tickets, (a, b) -> {
                if (a[0].equals(b[0])) {
                    return a[1].compareTo(b[1]);
                } else {
                    return a[0].compareTo(b[0]);
                }
            });
            Map<String, LinkedList<String>> edges = new HashMap<>();
            for (String[] tt : tickets) {
                String src = tt[0];
                String dest = tt[1];
                LinkedList<String> dests = edges.getOrDefault(src, new LinkedList<>());
                dests.add(dest);
                edges.put(src, dests);
            }
            LinkedList<String> path = new LinkedList<>();
            path.add("JFK");
            ret = dfs("JFK", edges, path);
        }
        return ret;
    }

    private List<String> dfs( String src, Map<String, LinkedList<String>> edges, LinkedList<String> path) {
        List<String> ret = new LinkedList<>();
        if( edges.isEmpty() ) {
            ret = path;
        } else {
            LinkedList<String> nexts = edges.getOrDefault(src, new LinkedList<>());
            for (int i = 0; i < nexts.size(); ++i) {
                String next = nexts.remove(i);
                if (nexts.isEmpty()) {
                    edges.remove(src);
                }
                path.add(next);
                List<String> subRet = dfs(next, edges, path);
                if (!subRet.isEmpty()) {
                    ret = path;
                    break;
                }
                path.removeLast();
                nexts.add(i, next);
                edges.put(src, nexts);
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        String[][][] tests = {
                {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}},
                {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}},
                {{"JFK", "MUC"}},
                {{"JFK", "A"},{"JFK", "B"},{"B", "JFK"}}
        };
        Solution sol = new Solution();
        for (String[][] tickets : tests) {
            List<String> ret = sol.findItinerary(tickets);
            System.out.println(ret);
        }
    }
}