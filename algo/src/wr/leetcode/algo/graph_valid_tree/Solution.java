package wr.leetcode.algo.graph_valid_tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    /**
     * BFS solution
     */
    public boolean validTree0(int n, int[][] edges) {
        if( null == edges ) {
            edges = new int[0][0];
        }

        int edgeCount = edges.length;
        boolean ret = true;
        if( n > 0 ) {
            //BUG: (did not confirm with requirements) duplicate edges may exist?
            if( edgeCount != n-1) {
                ret = false;
            } else {
                Map<Integer, Set<Integer>> neighbours = neighbours(edges);
                Set<Integer> visited = new HashSet<>();
                bfs(0, neighbours, visited);
                ret = (visited.size() == n);
            }
        }
        return ret;
    }

    public Map<Integer, Set<Integer>> neighbours ( int[][] edges ) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        for ( int[] edge : edges ) {
            int s = edge[0];
            int e = edge[1];
            Set<Integer> es = neighbours.getOrDefault(s, new HashSet<>());
            es.add(e);
            neighbours.put(s, es);
            Set<Integer> ss = neighbours.getOrDefault(e, new HashSet<>());
            ss.add(s);
            neighbours.put(e, ss);
        }
        return neighbours;
    }

    public void bfs( int v, Map<Integer, Set<Integer>> neighbours, Set<Integer> visited) {
        visited.add(v);
        for (Integer n: neighbours.getOrDefault(v, new HashSet<>())) {
            if(!visited.contains(n)) {
                bfs(n, neighbours, visited);
            }
        }
    }

    /**
     * UnionFind simple solution
     */

    public boolean validTree(int n, int[][] edges) {
        if( null == edges ) {
            edges = new int[0][0];
        }

        int edgeCount = edges.length;
        boolean ret = true;
        if( n > 0 ) {
            if( edgeCount != n-1) {
                ret = false;
            } else {
                ret = validTree(edges, new UnionFind(n), n);
            }
        }
        return ret;
    }

    public boolean validTree(int[][] edges, UnionFind uf, int n ) {
        for (int[] e : edges) {
            int st = e[0];
            int ed = e[1];
            uf.merge(st, ed);
        }

        Set<Integer> scc = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            scc.add(uf.groupOf(i));
        }
        return scc.size() == 1;
    }

    class UnionFind {

        int[] groupId;

        public UnionFind(int n) {
            groupId = new int[n];
            for (int i = 0; i < n; ++i) {
                groupId[i] = i;
            }
        }

        public void merge(int l, int r) {
            int lId = groupOf(l);
            int rId = groupOf(r);
            groupId[rId] = lId;
        }

        public int groupOf( int i) {
            int ret = i;
            while( ret != groupId[ret]) {
                ret = groupId[ret];
            }
            while( groupId[i] != ret) {
                int next = groupId[i];
                groupId[i] = ret;
                i = next;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] a = {
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };

        int[][] b = {
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };

        System.out.println(sol.validTree(5, a));
        System.out.println(sol.validTree(5, b));

    }
}
