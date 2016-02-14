package wr.leetcode.algo.number_of_connected_components_in_an_undirected_graph;

import java.util.*;

public class Solution {

    /*
    public int countComponents(int n, int[][] input) {
        int ret = 0;
        if(n > 0) {
            Map<Integer, Set<Integer>> edges = edges(input);
            Set<Integer> visited = new HashSet<>();
            DisjointSet groups = new DisjointSet(n);
            for (int i = 0; i < n; ++i) {
                if(i == groups.groupId(i)) {
                    bfs(groups, edges, visited, i);
                    ret ++;
                }
            }
        }
        return ret;
    }

    private void bfs(DisjointSet groups, Map<Integer, Set<Integer>> edges,
            Set<Integer> visited, int start ) {

        int groupId = groups.groupId(start);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int v = queue.poll();
            groups.join(groupId, v);
            for (int n : edges.getOrDefault(v, new HashSet<>())) {
                if(!visited.contains(n)) {
                    queue.offer(n);
                    visited.add(n);
                }
            }
        }
    }

    private Map<Integer, Set<Integer>> edges ( int[][] input) {
        Map<Integer, Set<Integer>> edges = new HashMap<>();
        if( null != input) {
            for (int [] edge : input ) {
                int start = edge[0];
                int end = edge[1];
                Set<Integer> startSets = edges.getOrDefault(start, new HashSet<>());
                startSets.add(end);
                edges.put(start, startSets);
                Set<Integer> endSets = edges.getOrDefault(end, new HashSet<>());
                endSets.add(start);
                edges.put(end, endSets);
            }
        }
        return edges;
    }

}

class DisjointSet {
    final int [] group;

    public DisjointSet(int n ) {
        group = new int[n];
        for (int i = 0; i < n; ++i) {
            group[i] = i;
        }
    }

    public int groupId (int index ) {
        int i = index;
        while(group[i] != i) {
            i = group[i];
        }
        int groupId = i;
        while(group[index] != index) {
            int next = group[index];
            group[index] = groupId;
            index = next;
        }
        return groupId;
    }

    public void join ( int index, int newId) {
        group[newId] = groupId(index);
    }*/


    class DisjointSet {
        int [] group;

        public DisjointSet( int n ) {
            group = new int[n];
            for (int i = 0; i <n; ++i) {
                group[i] = i;
            }
        }

        public void join(int left, int right) {
            group[group(right)] = group(left);
        }

        public int group(int k) {
            int key = k;
            while( group[key] != key ) {
                key = group[key];
            }
            int ret = key;
            key = k;
            while(group[key] != ret) {
                int next = group[key];
                group[key] = ret;
                key = next;
            }
            return ret;
        }
    }

        public int countComponents(int n, int[][] edges) {
            int ret = 0;
            if (n > 0 && null != edges && edges.length > 0) {
                DisjointSet set = new DisjointSet(n);
                for (int [] e : edges) {
                    int st = e[0];
                    int ed = e[1];
                    set.join(st, ed);
                }
                Set<Integer> groups = new HashSet<>();
                for (int i = 0; i < n; ++i) {
                    int id = set.group(i);
                    groups.add(id);
                }
                ret = groups.size();
            }
            return ret;
        }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countComponents(5,
                new int[][]{
                        {0,1},{1,2},{3,4}
                }));

        System.out.println(sol.countComponents(5,
                new int[][]{
                        {0,1},{1,2},{3,4},{2,3}
                }));
    }

}