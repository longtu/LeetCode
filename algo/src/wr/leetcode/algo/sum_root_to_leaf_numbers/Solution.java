package wr.leetcode.algo.sum_root_to_leaf_numbers;

import wr.leetcode.algo.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
 		if(null == root) {
 			return 0;
 		}
 		return sumNumbers(0, root);
    }
    private int sumNumbers(int base, TreeNode root) {
    	if(null == root) {
    		return 0;
    	}
    	base = base*10 + root.val;
    	if(null == root.left && null == root.right){
    		return base;
    	}
    	return sumNumbers(base, root.left) + sumNumbers(base, root.right);
    }
}