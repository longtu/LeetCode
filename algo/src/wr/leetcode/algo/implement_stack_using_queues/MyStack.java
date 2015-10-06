package wr.leetcode.algo.implement_stack_using_queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> pushQ = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        pushQ.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if( this.empty()) {
            throw new IllegalStateException("Invalid state!");
        }
        Queue<Integer> popQ = new LinkedList<>();
        while (pushQ.size() != 1) {
            popQ.add(pushQ.remove());
        }
        pushQ = popQ;
    }

    // Get the top element.
    public int top() {
        int ret = -1;
        if( this.empty()) {
            throw new IllegalStateException("Invalid state!");
        }
        Queue<Integer> popQ = new LinkedList<>();
        while (!pushQ.isEmpty()) {
            ret = pushQ.remove();
            popQ.add(ret);
        }
        pushQ = popQ;
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return (pushQ.isEmpty());
    }
}