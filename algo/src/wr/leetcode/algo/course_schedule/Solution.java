package wr.leetcode.algo.course_schedule;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
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
}
