package wr.leetcode.algo.longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> dict = new HashSet<>(nums.length);
        for (int val : nums) {
            dict.add(val);
        }

        int max = Integer.MIN_VALUE;

        for (int val : nums) {
            int count = 1;
            dict.remove(val);

            int next = val +1;
            while(dict.contains(next)) {
                dict.remove(next);
                count ++;
                next = next + 1;
            }

            next = val -1;
            while(dict.contains(next)) {
                dict.remove(next);
                count ++;
                next = next - 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(
            arr
        ));
    }
}
