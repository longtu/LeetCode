package wr.leetcode.algo.binary_tree_preorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
   /* public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		if(null == root) {
			return ret;
		}

    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	while(!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		ret.add(node.val);
    		if(null != node.right) {
    			stack.push(node.right);
    		}
			if(null != node.left) {
    			stack.push(node.left);
    		}
    	}
    	return ret;
    }
    */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		if(null != root){
			st.push(root);
		}

		while(!st.isEmpty()){
			TreeNode node = st.pop();
			ret.add(node.val);
			if(null != node.right) {
				st.push(node.right);
			}
			if(null != node.left) {
				st.push(node.left);
			}
		}

		return ret;
	}
}