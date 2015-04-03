package wr.leetcode.algo.factorial_trailing_zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        if(n < 0) {
            n *= -1;
        }

        int zeros = 0;
        // we have a bug here for overflow
        for ( long mod = 5; mod <= n && mod <= Integer.MAX_VALUE; mod *= 5) {
            zeros += n/mod;
        }
        return zeros;
    }

    public static void main( String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trailingZeroes(1808548329));
    }
}