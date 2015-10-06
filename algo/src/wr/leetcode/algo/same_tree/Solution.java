package wr.leetcode.algo.same_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q) {
            return true;
        }

        if( null == p || null == q) {
            return false;
        }

        return (p.val == q.val) && (isSameTree(p.left, q.left))
                && (isSameTree(p.right, q.right));

    }
}
