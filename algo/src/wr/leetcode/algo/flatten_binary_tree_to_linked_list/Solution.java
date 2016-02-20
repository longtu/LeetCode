package wr.leetcode.algo.flatten_binary_tree_to_linked_list;

import wr.leetcode.algo.TreeNode;

public class Solution {
    /*
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree( TreeNode node) {

        if((null == node) || (null == node.left && null == node.right)) {
            return node;
        }

        if(null == node.left) {
            TreeNode rightTail = flattenTree(node.right);
            return rightTail;
        }
        if(null == node.right) {
            TreeNode leftTail = flattenTree(node.left);
            node.right = node.left;
            node.left = null;
            return leftTail;
        }
        //neither is null
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = null;
        leftTail.right = tmp;
        return rightTail;
    }
    */

    /*
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree (TreeNode root) {
        TreeNode tail = root;

        if( null != root ) {
            TreeNode right = root.right;
            root.right = null;
            if (null != root.left) {
                TreeNode left = root.left;
                root.left = null;
                TreeNode leftEnd = flattenTree(left);
                tail.right = left;
                tail = leftEnd;
            }
            if (null != right) {
                TreeNode rightEnd = flattenTree(right);
                tail.right = right;
                tail = rightEnd;
            }
        }
        return tail;
    }*/
    public void flatten(TreeNode root) {
        flattenNode(root);
    }

    public TreeNode flattenNode (TreeNode root) {
        TreeNode ret = null;
        if ( null != root ) {
            ret = root;
            if (null != root.right) {
                ret = flattenNode(root.right);
            }
            if ( null != root.left) {
                TreeNode leftEnd = flattenNode(root.left);
                leftEnd.right = root.right;
                root.right = root.left;
                root.left = null;
                if( ret == root) {
                    ret = leftEnd;
                }
            }
        }
        return ret;
    }

}