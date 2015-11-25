package wr.leetcode.algo.longest_palindromic_substring;

public class Solution {
    public String longestPalindrome(String s) {
        if( null == s ) {
            s = "";
        }
        int maxLen = 0;
        int start = 0;
        int n = s.length();
        boolean [][] table = new boolean[n+1][n+1];

        for (int l = 0; l <= n; ++l ) {
            for ( int i = 0; i + l <= n; ++i ) {
                boolean value;
                if( 0 == l || 1 == l ) {
                    value = true;
                } else {
                    value = (s.charAt(i) == s.charAt(i+l-1))
                                && (table[l-2][i+1]);
                }
                table[l][i] = value;
                if(value) {
                    maxLen = l;
                    start = i;
                }
            }
        }
        return (s.isEmpty()) ? (""): (s.substring(start, maxLen+start));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindrome("efgabccbah"));
    }
}
