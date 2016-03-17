package wr.leetcode.algo.remove_invalid_parentheses;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sols = new Solution();
        for (String s : new String[] {
                "(a)()",
            }) {
            System.out.println(sols.removeInvalidParentheses(s));
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        System.out.println( "hello" + reversed);
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
            System.out.println("foo " + reversed);
        }
        else {
            System.out.println("bar " + reversed);
            ans.add(reversed);
        }
    }
}
