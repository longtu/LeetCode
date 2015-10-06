package wr.leetcode.algo.perfect_squares;

public class Solution {
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        dp[0] = 0;
        for (int x = 1; x <= n; ++x ) {
            int min = Integer.MAX_VALUE;
            for (int i = 1;  i*i <= x; ++i) {
                min = Math.min(min, dp[x - i * i] + 1);
            }
            dp[x] = min;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

       /* System.out.println(sol.numSquares(12));
        System.out.println(sol.numSquares(13));
        System.out.println(sol.numSquares(1));
        System.out.println(sol.numSquares(2));
        System.out.println(sol.numSquares(3));
        System.out.println(sol.numSquares(4));
        */
        System.out.println(sol.numSquares(52));
    }
}
