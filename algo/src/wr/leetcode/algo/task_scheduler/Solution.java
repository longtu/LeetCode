package wr.leetcode.algo.task_scheduler;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int totalTime( char [] tasks, int coolTime) {
        int h = coolTime + 1;
        Character[] history = new Character[h];
        Map<Character, Integer> dict = new HashMap<>();

        int t = 0;
        int i = 0;
        int n = tasks.length;

        while( i < n ) {
            Character task = tasks[i];
            if (dict.containsKey(task)) {
                task = ' ';
            } else {
                i++;
            }
            history[t%h] = task;
            int add = dict.getOrDefault(task, 0) + 1;
            dict.put(task, add);

            if( t - coolTime >= 0) {
                char dec = history[(t-coolTime)%h];
                int remove = dict.get(dec) - 1;
                if ( 0 == remove) {
                    dict.remove(dec);
                } else {
                    dict.put(dec, remove);
                }
            }
            t++;
            System.out.print(task);
        }
        System.out.println();
        return t;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.totalTime(
                "AABABCD".toCharArray(), 2
        ));

        System.out.println(sol.totalTime(
                "AABA".toCharArray(), 2
        ));
        System.out.println(sol.totalTime(
                "ABCABC".toCharArray(), 3
        ));
        System.out.println(sol.totalTime(
                "AABABCD".toCharArray(), 0
        ));
    }
}
