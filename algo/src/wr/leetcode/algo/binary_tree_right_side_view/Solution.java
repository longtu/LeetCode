package wr.leetcode.algo.binary_tree_right_side_view;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    /*
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new LinkedList();
        if(null == root) {
            return ret;
        }
        Queue<TreeNode> queue;
        Queue<TreeNode> next = new LinkedList();
        next.offer(root);
        while(!next.isEmpty()) {
            ret.add(next.peek().val);
            queue = next;
            next = new LinkedList();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(null != node.right) {
                    next.offer(node.right);
                }
                if(null != node.left) {
                    next.offer(node.left);
                }
            }
        }
        return ret;
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> nextq = new LinkedList<>();
        List<Integer> ret = new LinkedList<>();
        if( null != root) {
            nextq.add(root);
        }

        while(!nextq.isEmpty()) {
            Queue<TreeNode> q = nextq;
            nextq = new LinkedList<>();
            Integer rightMost = null;
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                rightMost = node.val;
                if( null != node.left ) {
                    nextq.add(node.left);
                }
                if( null != node.right) {
                    nextq.add(node.right);
                }
            }
            if(null != rightMost) {
                ret.add(rightMost);
            }
        }
        return ret;
    }*/

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ret = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();
        if( null != root ) {
            nextQ.offer(root);
        }

        while( !nextQ.isEmpty() ) {
            Queue<TreeNode> q = nextQ;
            nextQ = new LinkedList<>();
            Integer rightmost = null;
            while( !q.isEmpty() ) {
                TreeNode node = q.poll();
                rightmost = node.val;
                if( null != node.left ) {
                    nextQ.offer(node.left);
                }
                if( null != node.right ) {
                    nextQ.offer(node.right);
                }
            }
            if( null != rightmost ) {
                ret.add(rightmost);
            }
        }
        return ret;
    }
}
