package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

public class SinkZero {
    /**
     * Worst case O(N*N)
     *
     */
    public void sinkZero(TreeNode root) {
        if (null == root) {
            return;
        }

        if (0 == root.val) {
            TreeNode nonZero = findNonZero(root);
            if (null != nonZero) {
                int val = nonZero.val;
                nonZero.val = 0;
                root.val = val;
            } else {
                //BUG: should return to avoid unnecessary recursive
                return;
            }
        }
        sinkZero(root.left);
        sinkZero(root.right);
    }

    public TreeNode findNonZero(TreeNode root) {
        if (null == root) {
            return null;
        }
        if (null != root.left) {
            TreeNode left = findNonZero(root.left);
            if (null != left) {
                return left;
            }
        }
        if (null != root.right) {
            TreeNode right = findNonZero(root.right);
            if (null != right) {
                return right;
            }
        }
        if ( 0 != root.val ) {
            return root;
        }
        return null;
    }
}
