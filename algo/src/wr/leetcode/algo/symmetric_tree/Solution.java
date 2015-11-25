package wr.leetcode.algo.symmetric_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return (null == root) || (isSymmetric(root.left, root.right));
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        boolean ret = true;
        if( null == left && null == right) {
            ret = true;
        } else if (null == left || null == right) {
            ret = false;
        } else {
            ret = (left.val == right.val)
             && (isSymmetric(left.left, right.right))
             && (isSymmetric(left.right, right.left));
        }
        return ret;
    }
}
