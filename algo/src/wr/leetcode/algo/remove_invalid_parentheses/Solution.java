package wr.leetcode.algo.remove_invalid_parentheses;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution sols = new Solution();
        for (String s : new String[] {"()())()","(a)())()", ")(" }) {
            System.out.println(sols.removeInvalidParentheses(s));
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList<>();

        if(null != s) {
            Set<String> tails = new HashSet<>();
            Set<String> visited = new HashSet<>();
            Queue<String> nextQ = new LinkedList<>();
            nextQ.add(s);
            visited.add(s);

            while(!nextQ.isEmpty()) {
                Queue<String> q = nextQ;
                nextQ = new LinkedList<>();
                while(!q.isEmpty()) {
                    String v = q.remove();
                    if(isValid(v)){
                        tails.add(v);
                    }
                    List<String> neighbours = neighbours(v);
                    for (String n : neighbours) {
                        if(!visited.contains(n)) {
                            visited.add(n);
                            nextQ.add(n);
                        }
                    }
                }
                if(!tails.isEmpty()) {
                    ret = new LinkedList<>(tails);
                    break;
                }
            }
        }
        return ret;
    }


    public List<String> neighbours(String str ) {

        List<String> ret = new LinkedList<>();
        int n = str.length();
        for (int i = 0; i < n ; ++i) {
            char ch = str.charAt(i);
            if( '(' == ch || ')' == ch ) {
                ret.add(str.substring(0, i) + str.substring(i+1, n));
            }
        }
        return ret;
    }


    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if( '(' == ch ) {
                st.push('(');
            } else if (')' == ch) {
                if(st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}
