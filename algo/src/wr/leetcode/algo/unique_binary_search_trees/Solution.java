package wr.leetcode.algo.unique_binary_search_trees;

public class Solution {
    public int numTrees(int n) {

        if( n < 0) {
            return 0;
        }
        int [] dp = new int[n+1];
        dp [0] = 1;

        for (int i = 1; i <=n; ++i) {
            int sum = 0;
            for ( int l = 0; l <= i-1; ++l) {
                sum += dp[l] * dp[ i - 1 -l ];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numTrees(0));
        System.out.println(sol.numTrees(1));
        System.out.println(sol.numTrees(2));
        System.out.println(sol.numTrees(3));
    }
}
