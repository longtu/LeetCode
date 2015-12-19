package wr.leetcode.algo.burst_balloons;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    //Method2: bottom up
    //This solution is tricky in that it consider range(l,r) exclusively
    public int maxCoins(int[] input) {
        int ret = 0;
        if( null != input && input.length > 0 ) {
            int n = input.length;
            int[] nums = new int[n+2];
            Arrays.fill(nums, 1);
            System.arraycopy(input,0, nums, 1, n);

            int [][] dp = new int[n+2][n+2];

            for (int len = 3; len <= n+2; ++len) {
                for (int l = 0; l+len-1 <= n+1; ++l) {
                    int r = l + len -1;
                    for (int k = l+1; k < r; ++k) {
                        dp[l][r] = Math.max(dp[l][r],
                                nums[l] * nums[r] * nums[k] + dp[l][k] + dp[k][r]);
                    }
                }
            }
            ret = dp[0][n+1];

        }
        return ret;
    }




        public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr = {
                {},
                {4},
                {3, 1, 5, 8},
                {7,9,8,0,7,1,3,5,5,2,3},
                {8,2,6,8,9,8,1,4,1,5,3,0,7,7,0,4,2,2,5}
        };
        for (int [] a : arr) {

            System.out.println(sol.maxCoins(a));

        }

    }


    //Method1: with memoization
    public int maxCoins0(int[] nums, Map<String, Integer> cache) {
        int ret = 0;
        String key = Arrays.toString(nums);
        if (cache.containsKey(key)) {
            ret = cache.get(key);
        } else {
            if( 1 == nums.length ) {
                ret = nums[0];
            } else {
                int n = nums.length;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < n; ++i) {
                    int[] subNums = new int[n-1];
                    System.arraycopy(nums, 0, subNums, 0, i);
                    System.arraycopy(nums, i+1, subNums, i, n-1-i);
                    int sum = maxCoins0(subNums, cache) + nums[i] *
                            ((i-1 < 0)?(1):(nums[i-1])) *
                            ((i+1 == n)?(1):(nums[i+1]));
                    if( sum > max) {
                        max = sum;
                    }
                }
                ret = max;
            }
            cache.put(key, ret);
        }
        return ret;
    }

    public int maxCoins0(int[] nums) {

        int ret = 0;
        if( null != nums && 0 < nums.length ) {
            ret = maxCoins0(nums, new HashMap<>());
        }
        return ret;
    }

}
