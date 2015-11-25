package wr.leetcode.algo.recover_binary_search_tree;

import wr.leetcode.algo.TreeNode;

import java.util.*;

public class Solution {
    /*
    public void recoverTree(TreeNode root) {

        if(null == root || (root.left == root.right && root.right== null)) {
            return;
        }

        List<TreeNode> conflictors = new LinkedList<>();
        recover(root, conflictors, null);
        TreeNode left, right;
        if(conflictors.size() == 2){
            left = conflictors.get(0);
            right = conflictors.get(1);
        } else {
            left = conflictors.get(0);
            right = conflictors.get(3);
        }
        int tmp = left.val;
        left.val =right.val;
        right.val = tmp;
    }

    public TreeNode recover(TreeNode root, List<TreeNode> conflicts, TreeNode prev) {
        if(root == null) {
            return null;
        }
        TreeNode leftNeighbour = prev;
        if(root.left != null) {
            leftNeighbour = recover(root.left, conflicts, prev);
        }
        if (leftNeighbour != null && leftNeighbour.val > root.val) {
            conflicts.add(leftNeighbour);
            conflicts.add(root);
        }
        if(root.right != null) {
            TreeNode last = recover(root.right, conflicts, root);
            return last;
        }
        return root;
    }*/


    public void recoverTree(TreeNode root) {

        List<TreeNode> ret = new LinkedList<>();
        TreeNode[] prev = new TreeNode[1];
        recoverTree(root, prev , ret);
        if(2 == ret.size()) {
            TreeNode left = ret.get(0);
            TreeNode right = ret.get(1);
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }
    }

    public void recoverTree(TreeNode root, TreeNode[] preNode, List<TreeNode> nodes) {
        if( null == root) {
            return;
        }
        recoverTree(root.left, preNode, nodes);
        int val = root.val;
        TreeNode pre = preNode[0];
        if(null != pre && val < pre.val) {
            if(0 == nodes.size()) {
                nodes.add(pre);
                nodes.add(root);
            } else {
                nodes.remove(1);
                nodes.add(root);
            }
        }
        preNode[0] = root;
        recoverTree(root.right, preNode, nodes);
    }
}