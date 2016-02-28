package wr.leetcode.algo.Linkedin;

/* Write a function to compute the maximum length palindromic sub-sequence of an array.
A palindrome is a sequence which is equal to its reverse.
A sub-sequence of an array is a sequence which can be constructed by removing elements of the array.
Ex: Given [4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4] should return 10 (all 4's) */
public class LongestPalindromeSubsequence {

    public int maxLengthPalindrome(int[] values) {
        int ret = 0;
        values = (null == values)?(new int[0]):(values);
        int n = values.length;

        if (n > 0) {
            int[][] dp = new int[n][n];
            for (int l = 0; l <n; ++l) {
                for(int i = 0; i+l <n; ++i) {
                    int val;
                    int j = i+l;
                    if (0 == l) {
                        val = 1;
                    } else if (1 == l) {
                        val = (values[i] == values[j])?(2):(0);
                    } else {
                        val = dp[i+1][j-1] + ((values[i] == values[j])?(2):(0));
                        val = Math.max(val, dp[i][j-1]);
                        val = Math.max(val, dp[i+1][j]);
                    }
                    dp[i][j] = val;//BUG: Forgot to put back val
                }
            }
            ret = dp[0][n-1];
        }
        return ret;
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence solution = new LongestPalindromeSubsequence();

        for (int[] arr : new int[][] {
                {4,1,2,3,4,5,6,5,4,3,4,4,4,4,4,4,4},
                {4},
                {4,1,2,3},
                {4,1,2,3,4},
                {},
                {4,4,2,2,2,2,4}
        }) {
            System.out.println(solution.maxLengthPalindrome(arr));
        }

    }
}

