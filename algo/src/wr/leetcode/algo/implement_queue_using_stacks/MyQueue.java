package wr.leetcode.algo.implement_queue_using_stacks;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> frontStack = new Stack<>();
    Stack<Integer> backStack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        backStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(empty()) {
            throw new IllegalStateException("empty cannot pop!");
        }
        back2front();
        frontStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(empty()) {
            throw new IllegalStateException("empty cannot peek!");
        }
        back2front();
        return frontStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (frontStack.isEmpty() && backStack.isEmpty());
    }

    private void back2front() {
        if(frontStack.isEmpty()) {
            while(!backStack.isEmpty()) {
                frontStack.push(backStack.pop());
            }
        }
    }
}