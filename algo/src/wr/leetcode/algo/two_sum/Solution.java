package wr.leetcode.algo.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        int [] ret = new int[2];

        for (int i = 0; i < nums.length; ++i) {
            dict.put(nums[i], i);
        }

        for ( int i = 0; i < nums.length; ++i) {
            Integer index = dict.get(target - nums[i]);
            if(null != index && index > i) {
                ret[0] = i + 1;
                ret[1] = index + 1;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(
                        sol.twoSum(
                                new int[] {2,7,11,15}
                                ,9
                        )
                )
        );
    }
}
