package wr.leetcode.algo.binary_tree_upside_down;

import wr.leetcode.algo.TreeNode;
import wr.leetcode.algo.serialize_and_deserialize_binary_tree.Codec;

public class Solution {

    /*
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
    }*/

    TreeNode upsideDownBinaryTree( TreeNode root) {
        TreeNode ret = null;

        if ( null!= root ) {
            if (null == root.left) {
                ret = root;
            } else {
                TreeNode left = root.left;
                ret = upsideDownBinaryTree(root.left);
                left.left = root.right;
                left.right = root;
                root.left = null;
                root.right = null;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;

        TreeNode newRoot = sol.upsideDownBinaryTree(root);
        Codec codec = new Codec();
        System.out.println(codec.serialize(newRoot));
    }
}