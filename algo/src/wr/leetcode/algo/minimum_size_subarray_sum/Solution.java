package wr.leetcode.algo.minimum_size_subarray_sum;

public class Solution {


    public int minSubArrayLen(int s, int[] nums) {
        if( null == nums ) {
            nums = new int[0];
        }
        int n = nums.length;
        int start = -1;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            if(0 == i) {
                start = i;
            }
            int val = nums[i];
            sum += val;
            while(sum >= s) {
                int dist = i - start + 1;
                minLen = Math.min(minLen, dist);
                sum -= nums[start ++];
            }
        }
        return (Integer.MAX_VALUE == minLen ) ? (0):(minLen);
    }

    /*
    public int minSubArrayLen(int s, int[] nums) {

        int min = Integer.MAX_VALUE;
        if(null == nums) {
            nums = new int[0];
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        while( end < nums.length ) {
            sum += nums[end ++ ];
            if(sum >= s) {
                min = Math.min(min, end - start);
                while(sum >= s) {
                    sum -= nums[start++];
                    if( sum >= s) {
                        min = Math.min(min, end - start);
                    }
                }
            }
        }
        return (min == Integer.MAX_VALUE)?(0):(min);
    }

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
    }*/

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
