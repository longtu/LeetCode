package wr.leetcode.algo.reverse_words_in_a_string_ii;

public class Solution {
    public void reverseWords(char[] s) {
        if( null == s || 0 == s.length) {
            return;
        }
        int n = s.length;
        reverse(s, 0, n-1);

        for (int start = 0, end = 0; end <= n; ++end) {
            if( n == end || ' ' == s[end]) {
                reverse (s, start, end-1);
                start = end + 1;
            }
        }
    }

    public void reverse(char[] s, int start, int end) {
        while( start < end ) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char [] arr = "the sky is blue".toCharArray();
        sol.reverseWords(arr);
        System.out.println(new String(arr));
    }
}
