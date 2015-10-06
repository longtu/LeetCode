package wr.leetcode.algo.lowest_common_ancestor_of_a_binary_search_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {
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
    }
}