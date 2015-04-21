package wr.leetcode.algo.valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        if(null == s) {
            s = "";
        }

        Stack<Character> stack = new Stack();
        Character expect;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    expect = null;
                    break;
                case '}':
                    expect = '{';
                    break;
                case ')':
                    expect = '(';
                    break;
                case ']':
                    expect = '[';
                    break;
                default:
                    return false;
            }
            if(null != expect) {
                if(stack.isEmpty() || !stack.peek().equals(expect)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
