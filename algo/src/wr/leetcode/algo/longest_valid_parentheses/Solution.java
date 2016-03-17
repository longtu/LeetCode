package wr.leetcode.algo.longest_valid_parentheses;

import java.util.Stack;

public class Solution {

    public int longestValidParentheses1(String s) {
        int ret = 0;
        if(null != s && !s.isEmpty()) {
            Stack<Integer> st = new Stack<>();
            int n = s.length();
            int start = 0;
            while(start < n) {
                char ch = s.charAt(start);
                if('(' == ch) {
                    st.push(start);
                } else { // ch == ')'
                    if( !st.isEmpty() && s.charAt(st.peek()) == '(') {
                        st.pop();
                        ret = Math.max(ret, start
                         - ((st.isEmpty())?(-1):(st.peek())));
                    } else {
                        st.push(start);
                    }
                }
                start ++;
            }
        }
        return ret;
    }




    public int longestValidParentheses0(String s) {
        int ret = 0;
        if(null != s && !s.isEmpty()) {
            int n = s.length();

            int [] loc = new int [n];

            for (int i = 0; i < n; ++i ) {
                char ch = s.charAt(i);
                int val = 0;
                if(ch == ')' && i > 0) {
                    int j = i - 1 - loc[i-1];
                    if( j >= 0 && s.charAt(j) == '(') {
                        val = loc[i - 1] + 2;
                        if (j - 1 >= 0) {   //BUG: this is nested condition check
                            val += loc[j - 1];
                        }
                    }
                }
                loc[i] = val;
                System.out.println(val);
                ret = Math.max(loc[i], ret);
            }
        }
        return ret;
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if( ch == '(' || st.isEmpty() || s.charAt(st.peek()) == ')') {
                st.push(i);
            } else {
                st.pop();
                int len = i - ((st.isEmpty())?(-1):(st.peek()));
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses(")()())()()("));
    }
}
