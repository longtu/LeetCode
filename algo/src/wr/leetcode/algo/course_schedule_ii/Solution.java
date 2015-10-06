package wr.leetcode.algo.course_schedule_ii;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    //needs redo!!!
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        LinkedList<Integer> ret = new LinkedList<>();
        while(!queue.isEmpty()) {
            Integer reach = queue.remove();
            ret.add(reach);
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

        return (reached.size() == numCourses)?(
                ret.stream().mapToInt(a->(a)).toArray()
            ):(new int[]{});
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] a = { {1,0}};
        int[][] b = { {1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(sol.findOrder(2, a)));
        System.out.println(Arrays.toString(sol.findOrder(4, b)));
    }

}