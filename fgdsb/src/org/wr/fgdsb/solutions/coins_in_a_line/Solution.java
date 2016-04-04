package org.wr.fgdsb.solutions.coins_in_a_line;

public class Solution {

    public static int maxSum(int [] nums) {
        if (null == nums) return 0;
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int l = 1; l <=n; l+=1) {
            for (int i = 0; i+l <=n; ++i) {
                int v;
                if (1 == l)
                    v = nums[i];
                else if (2 == l)
                    v = Math.max(nums[i], nums[i+1]);
                else
                    v = Math.max(
                            nums[i] + Math.min(dp[i+1][i+l-2], dp[i+2][i+l-1]),
                            nums[i+l-1] + Math.min(dp[i][i+l-3], dp[i+1][i+l-2])
                    );
                dp[i][i+l-1] = v;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(maxSum( new int[] {5,3,7,10}));
        System.out.println(maxSum( new int[] {8, 15, 3, 7}));
    }
}
