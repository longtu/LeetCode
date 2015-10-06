package wr.leetcode.algo.house_robber;

public class Solution {
    public int rob(int[] nums) {
        int sum = 0;
        if (null != nums && nums.length > 0) {
            int n = nums.length;
            int[] g = new int [4];
            int[] l = new int [4];
            for (int i = 0; i < n; ++i) {
                l[i%4] =  ((i>=2)?(g[(i-2)%4]):(0)) + nums[i];
                g[i%4] = Math.max( ((i>=1)?(g[(i-1)%4]):(0)), l[i%4]);
            }
            sum = g[(n-1)%4];
        }
        return sum;
    }

}
