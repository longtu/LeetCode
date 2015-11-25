package wr.leetcode.algo.length_of_last_word;

public class Solution {
    public int lengthOfLastWord(String s) {

        if( null == s) {
            s = "";
        }
        int n = s.length();
        int start = -1;
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if( ' ' != ch && (i == 0 || s.charAt(i-1) == ' ') ) {
                start = i;
            }
        }
        int len = 0;
        if(-1 != start) {
            int i;
            for (i = start; i < n && (' ' != s.charAt(i)); ++i);
            len = i-start;
        }
        return len;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLastWord("Hello World"));
    }
}
