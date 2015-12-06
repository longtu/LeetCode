package wr.leetcode.algo.binary_tree_upside_down;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode ret = null;
        if( null != root ) {
            if (null != root.left) {
                TreeNode left = root.left;
                TreeNode right = root.right;
                root.left = null;
                root.right = null;
                right = upsideDownBinaryTree(right);
                ret = upsideDownBinaryTree(left);
                TreeNode rightMost = findRightMost(ret);
                rightMost.left = right;
                rightMost.right = root;

            } else { //both left and right of root is null
                ret = root;
            }
        }
        return ret;
    }

    public TreeNode findRightMost(TreeNode root) {
        TreeNode node = root;
        while(null != node.right) {
            node = node.right;
        }
        return node;
    }
}