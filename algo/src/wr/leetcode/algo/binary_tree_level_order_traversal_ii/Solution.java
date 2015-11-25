package wr.leetcode.algo.binary_tree_level_order_traversal_ii;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	/*
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if (null == root) {
 			return ret;
 		}

 		Stack<List<Integer>> stack = new Stack<>();
 		Queue<TreeNode> next = new LinkedList<>();
 		next.add(root);

 		while(!next.isEmpty()) {
 			List<Integer> curr = new LinkedList<>();
	 		Queue<TreeNode> line = next;
 			next = new LinkedList<>();
 			while(!line.isEmpty()) {
 				TreeNode node = line.poll();
 				curr.add(node.val);
 				if(null != node.left) {
 					next.add(node.left);
 				}
 				if(null != node.right) {
 					next.add(node.right);
 				}
 			}
 			stack.push(curr);
 		}
 		while(!stack.isEmpty()) {
 			ret.add(stack.pop());
 		}

 		return ret;
    }*/
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();
        if(null != root) {
            nextQ.add(root);
        }

        while(!nextQ.isEmpty()) {
            Queue<TreeNode> q = nextQ;
            nextQ = new LinkedList<>();
            List<Integer> line = new LinkedList<>();
            while(!q.isEmpty()) {
                TreeNode node = q.remove();
                line.add(node.val);
                if(null != node.left) {
                    nextQ.add(node.left);
                }
                if(null != node.right) {
                    nextQ.add(node.right);
                }

            }
            ret.addFirst(line);
        }
        return ret;
	}
}