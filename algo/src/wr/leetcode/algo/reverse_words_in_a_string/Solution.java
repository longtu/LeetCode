package wr.leetcode.algo.reverse_words_in_a_string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        if(null == s || s.isEmpty()) {
            return s;
        }

        String str = s.trim().replaceAll("\\s+", " ");
        String [] words = str.split(" ");

        LinkedList<String> rWrods = new LinkedList<>();
        for (String w : words) {
            rWrods.addFirst(w);
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (String w : rWrods) {
            sb.append(w);
            if( i ++ != rWrods.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("  the sky is blue  "));
        System.out.println(sol.reverseWords("    "));
        System.out.println(sol.reverseWords("   blue  "));

    }
}
