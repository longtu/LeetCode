package wr.leetcode.algo.binary_tree_right_side_view;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
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
}
