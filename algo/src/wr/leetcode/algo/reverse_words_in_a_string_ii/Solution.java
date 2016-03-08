package wr.leetcode.algo.reverse_words_in_a_string_ii;

public class Solution {
    /*
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
    }*/

    public void reverseWords(char[] s) {
        if(null == s || 0 == s.length) {
            return;
        }
        int n = s.length;
        reverse(s, 0, n-1);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            char ch = s[i];
            if( ch == ' ') {
                reverse(s,j, i-1);
                j = i+1;
            }
        }
        reverse(s, j, n-1);
    }

    public void reverse(char[] arr, int start, int end) {
        while( start < end) {
            swap(arr, start++, end--);
        }
    }

    private void swap(char[] arr, int l, int r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        char [] arr = "the sky is blue".toCharArray();
        sol.reverseWords(arr);
        System.out.println(new String(arr));
    }
}
