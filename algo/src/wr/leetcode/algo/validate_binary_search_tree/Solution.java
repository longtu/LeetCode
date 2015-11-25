package wr.leetcode.algo.validate_binary_search_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return (null == root) || (isValidBST(root, null, null));
    }

    public boolean isValidBST(TreeNode root, Integer lBound, Integer rBound) {
        boolean ret;
        if(null == root) {
            ret = true;
        } else {
            ret = ((null == lBound)||( root.val > lBound)) &&
                ((null == rBound)||( root.val < rBound)) &&
                (isValidBST(root.left, lBound, root.val)) &&
                (isValidBST(root.right, root.val, rBound));
        }
        return ret;
    }
}
