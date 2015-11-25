package wr.leetcode.algo.lowest_common_ancestor_of_a_binary_search_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
    /*
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root) {
            return null;
        }
        if( p == null && q == null) {
            throw new IllegalStateException("P and Q are both null!");
        }
        if(p == null ){
            return q;
        }
        if (q == null) {
            return p;
        }
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret;
        if( (null == p && null == q) || null == root) {
            ret = null;
        } else if( null == p) {
            ret = q;
        } else if( null == q) {
            ret = p;
        } else {
            int pDiff = p.val - root.val;
            int qDiff = q.val - root.val;

            if(pDiff * qDiff <= 0) {
                ret = root;
            } else if(pDiff > 0) {
                ret = lowestCommonAncestor(root.right, p, q);
            } else {
                ret = lowestCommonAncestor(root.left, p, q);
            }
        }
        return ret;
    }
}