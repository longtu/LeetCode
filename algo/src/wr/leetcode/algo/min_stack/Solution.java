package wr.leetcode.algo.min_stack;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
            throw new IllegalStateException("no element in the stack");
        }
        int ret = stack.pop();
        if(ret == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()) {
            throw new IllegalStateException("no element in the stack");
        }
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty()) {
            throw new IllegalStateException("no element in the stack");
        }
        return minStack.peek();
    }
}