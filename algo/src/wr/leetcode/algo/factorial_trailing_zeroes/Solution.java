package wr.leetcode.algo.factorial_trailing_zeroes;

public class Solution {

    public int trailingZeroes(int n) {
        int sum = 0;

        //BUG: overflow baby!!
        long val = n;
        long mod = 5;
        while( mod <= val ) {
            sum += n/mod;
            mod *= 5;
        }

        return sum;
    }




    public static void main( String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trailingZeroes(2147483647));
    }

    /*

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
    */
}