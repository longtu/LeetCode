package wr.leetcode.algo.min_stack;

import java.util.Stack;
/*
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
}*/

class MinStack {
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int x) {
        if(stack.isEmpty() || stack.peek() >= x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if(val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}