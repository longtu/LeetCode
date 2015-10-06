package wr.leetcode.algo.minimum_size_subarray_sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if( null == nums || 0 == nums.length) {
            return 0;
        }
        int lhs = 0, rhs = 0, sum = 0, min = Integer.MAX_VALUE;

        while( rhs <= nums.length && lhs < nums.length) {
            if(sum < s) {
                if(rhs < nums.length) {
                    sum += nums[rhs];
                }
                rhs++;
            } else {
                if(rhs - lhs < min) {
                    min = rhs - lhs;
                }
                sum -= nums[lhs++];
            }
        }
        return (min == Integer.MAX_VALUE)?(0):(min);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(3, new int[]{1,2,3}));
        System.out.println(sol.minSubArrayLen(4, new int[]{1,2,3}));
        System.out.println(sol.minSubArrayLen(5, new int[]{1,2,3}));
        System.out.println(sol.minSubArrayLen(6, new int[]{1,2,3}));
        System.out.println(sol.minSubArrayLen(7, new int[]{1,2,3}));
        System.out.println(sol.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));

    }
}
