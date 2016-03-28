package wr.leetcode.algo.remove_invalid_parentheses;

import java.util.*;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> visited = new HashSet<>();
        Queue<String> nextQueue = new LinkedList<>();
        nextQueue.offer(s);
        visited.add(s);
        List<String> ret = new LinkedList<>();

        while(!nextQueue.isEmpty()) {
            Queue<String> queue = nextQueue;
            nextQueue = new LinkedList<>();
            while( !queue.isEmpty() ) {
                String v = queue.poll();
                int d = dist(v);
                if( d == 0 ) {
                    ret.add(v);
                } else {
                    for (String n : neighbours(v)) {
                        if (!visited.contains(n) && dist(n) < d) {
                            nextQueue.offer(n);
                            visited.add(n);
                        }
                    }
                }
            }
            if(!ret.isEmpty()) {
                break;
            }
        }
        return ret;
    }

    public List<String> neighbours( String str ) {
        List<String> ret = new LinkedList<>();
        for (int i = 0; i< str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == ')') {
                ret.add(str.substring(0, i) + str.substring(i+1));
            }
        }
        return ret;
    }

    public int dist (String s) {
        int left = 0, right = 0;
        for (char ch : s.toCharArray()) {
            int v =  (ch == '(')? (1):(ch == ')')?(-1):(0);
            left += v;
            if (left < 0) {
                right += 1;
                left = 0;
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "()())()", "(a)())()",")("
        }) {
            System.out.println(sol.removeInvalidParentheses(str));
        }
    }
}