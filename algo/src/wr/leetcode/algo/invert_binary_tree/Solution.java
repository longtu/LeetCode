package wr.leetcode.algo.invert_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    /*
    public TreeNode invertTree(TreeNode root) {
        if(null == root) {
            return root;
        }
        TreeNode right = invertTree(root.left);
        TreeNode left = invertTree(root.right);
        root.left = left;
        root.right = right;
        return root;
    }*/


    public TreeNode invertTree(TreeNode root) {

        TreeNode ret = root;
        if(null != root) {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
