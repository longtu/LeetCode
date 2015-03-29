package wr.leetcode.algo.binary_tree_level_order_traversal_ii;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
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
    }
}