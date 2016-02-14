package wr.leetcode.algo.number_of_islands_ii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    /*
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> numbers = new LinkedList<>();
        int islands = 0;
        int len = positions.length;
        DisjointSet groups = new DisjointSet();
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};


        for (int i = 0; i < len; ++i) {
            int[] point = positions[i];
            int x = point[0];
            int y = point[1];
            int index = x * n + y;
            int id = groups.groupOf(index);

            if(x > -1 && x < m && y > -1 && y < n && -1 == id) {
                groups.add(index);
                islands ++;

                for (int k = 0; k < 4; ++k) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx > -1 && nx < m && ny > -1 && ny < n) {
                        int nIndex = nx * n + ny;
                        int nId = groups.groupOf(nIndex);
                        if(-1 != nId) {
                            int myId = groups.groupOf(index);
                            if(nId != myId) {
                                islands --;
                                groups.union(nId, myId);
                            }
                        }
                    }
                }
            }
            numbers.add(islands);
        }
        return numbers;
    */

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ret = new LinkedList<>();
        if (m > 0 && n > 0 && null != positions && positions.length > 0) {
            int count = 0;
            DisjointSet set = new DisjointSet();

            int[] xdiff = {-1, 0, 0, 1};
            int[] ydiff = {0, -1, 1, 0};

            for (int [] p : positions) {
                int x = p[0];
                int y = p[1];
                int index = index(x, y, n);
                if(-1 == set.groupOf(index)) { // new node
                    count ++;
                    set.add(index);
                    for (int i = 0; i < 4; ++i) {
                        int dx = xdiff[i] + x;
                        int dy = ydiff[i] + y;
                        int dindx = index(dx, dy, n);
                        int dgroup = set.groupOf(dindx);
                        if (dx >=0 && dx < m && dy >=0 && dy < n && -1 != dgroup &&
                                dgroup != index) {
                            set.union(dgroup, index);
                            count--;
                        }
                    }
                }
                ret.add(count);
            }
        }
        return ret;
    }

    int index(int x, int y, int m ) {
        return x*m + y;
    }


    class DisjointSet {
        Map<Integer, Integer> groups = new HashMap<>();


        public void add (int id) {
            if( !groups.containsKey(id) ) {
                groups.put(id, id);
            }
        }

        public void union (int left, int right ) {
            groups.put(left, right);
        }

        public int groupOf (int id) {
            if( !groups.containsKey(id) ) {
                return -1;
            }
            int group = id;
            while(groups.get(group) != group) {
                group= groups.get(group);
            }
            int parent = id;
            while(parent != group) {
                int nextParent = groups.get(parent);
                groups.put(parent, group);
                parent = nextParent;
            }
            return group;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}, {1,0}, {1,1}};
        System.out.println(sol.numIslands2(3,3,positions));
    }
}



