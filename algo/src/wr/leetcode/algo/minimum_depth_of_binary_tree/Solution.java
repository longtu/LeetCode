package wr.leetcode.algo.minimum_depth_of_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        int ret;
        if( null == root) {
            ret = 0;
        } else {
            if( null ==  root.left && null == root.right) {
                ret = 1;
            } else if (null == root.left) {
                ret = 1 + minDepth(root.right);
            } else if (null == root.right) {
                ret = 1 + minDepth(root.left);
            } else {
                ret = 1 + Math.min(minDepth(root.left), minDepth(root.right));
            }
        }
        return ret;
    }
}
