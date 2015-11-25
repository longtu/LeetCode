package wr.leetcode.algo.course_schedule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean ret = false;
        if(numCourses >= 1 && prerequisites != null && prerequisites.length >= 0) {
            Map<Integer, List<Integer>> table = new HashMap<>();
            Map<Integer, Integer> counts = new HashMap<>();
            Set<Integer> available = IntStream.range(0, numCourses)
                    .boxed()
                    .collect(Collectors.toSet());

            //build tables
            for (int [] pair : prerequisites) {
                int pre = pair[1];
                int curr = pair[0];
                available.remove(curr);
                List<Integer> nexts = table.getOrDefault(pre, new LinkedList<>());
                Integer count = counts.getOrDefault(curr, 0);
                //assuming there is no duplicates in prerequisites entries
                nexts.add(curr);
                table.put(pre, nexts);
                counts.put(curr, count+1);
            }

            Queue<Integer> q = new LinkedList<>(available);
            while(!q.isEmpty()) {
                Integer n = q.remove();
                // reduces one unnecessary check for contains
                for (Integer next : table.getOrDefault(n, new LinkedList<>())) {
                    int count = counts.get(next);
                    count -- ;
                    if(0 == count) {
                        counts.remove(next);
                        q.add(next);
                    } else {
                        counts.put(next, count);
                    }
                }
            }
            ret = counts.isEmpty();
        }
        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = { {0,1}};
        int[][] b = { {1,0}, {0,1}};
        int[][] c = { {0,1}, {0,2}, {0,3}};
        int[][] d = { {1,0}, {2,0}, {3,0}};

        System.out.println(sol.canFinish(2, a));
        System.out.println(sol.canFinish(2, b));
        System.out.println(sol.canFinish(4, c));
        System.out.println(sol.canFinish(4, d));
    }

    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> to = new HashMap<>(numCourses);
        Map<Integer, Integer> from = new HashMap<>(numCourses);

        Set<Integer> reached = IntStream.range(0, numCourses)
            .boxed()
            .collect(Collectors.toSet());

        for (int[] p : prerequisites) {
            int target = p[0];
            int pre = p[1];

            //update to
            if(!to.containsKey(pre)) {
                to.put(pre, new LinkedList<Integer>());
            }
            to.get(pre).add(target);

            //update from
            if (!from.containsKey(target)){
                from.put(target, 0);
            }
            from.put(target, from.get(target) + 1);
            reached.remove(target);
        }

        Queue<Integer> queue = new LinkedList<>(reached);
        while(!queue.isEmpty()) {
            Integer reach = queue.remove();
            List<Integer> tos = to.getOrDefault(reach, new LinkedList<>());
            for ( Integer n : tos) {
                int remaining = from.get(n) - 1;
                if(remaining == 0) {
                    reached.add(n);
                    queue.add(n);
                } else {
                    from.put(n, remaining);
                }
            }
        }
        return (reached.size() == numCourses);
    }*/
}
