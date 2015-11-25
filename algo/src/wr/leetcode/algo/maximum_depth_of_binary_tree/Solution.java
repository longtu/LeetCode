package wr.leetcode.algo.maximum_depth_of_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        int ret;

        if(null == root) {
            ret = 0;
        } else {
            ret = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return ret;
    }
}