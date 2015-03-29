package wr.leetcode.algo.binary_tree_level_order_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<>();
        if( null == root) {
        	return ret;
        }

        Queue<TreeNode> next = new LinkedList<>();
      	List<Integer> line = new LinkedList();
        Queue<TreeNode> queue;
        next.add(root);
        while(!next.isEmpty()) {
        	queue = next;
        	next = new LinkedList<>();
        	while(!queue.isEmpty() ) {
        		TreeNode node = queue.poll();
        		line.add(node.val);
        		if( null != node.left) {
        			next.add(node.left);
        		}
        		if( null != node.right) {
        			next.add(node.right);
        		}
        	}
        	ret.add(line);
        	line = new LinkedList();
		}
		return ret;
    }
}