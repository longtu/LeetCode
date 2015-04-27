package wr.leetcode.algo.evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if (null == tokens) {
            tokens = new String[0];
        }
        Stack<String> stack = new Stack();
        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    token = op(token, stack);
                default:
                    stack.push(token);
            }
        }
        if(stack.isEmpty()) {
            stack.push("0");
        }
        return Integer.parseInt(stack.peek());
    }

    private String op(String token, Stack<String> stack) {
        int b = Integer.parseInt(stack.pop());
        int a = Integer.parseInt(stack.pop());
        int ret;
        switch (token) {
            case "+":
                ret = a + b;
                break;
            case "-":
                ret = a - b;
                break;
            case "*":
                ret = a * b;
                break;
            case "/":
                ret = a / b;
                break;
            default:
                throw new IllegalStateException("Not enough operands in stack!");
        }
        return Integer.toString(ret);
    }
}
