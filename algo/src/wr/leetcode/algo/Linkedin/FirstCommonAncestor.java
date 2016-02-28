package wr.leetcode.algo.Linkedin;

import wr.leetcode.algo.TreeNode;

public class FirstCommonAncestor {
    public TreeNode firstCommonAncestor(TreeNode root, TreeNode left, TreeNode right) {
        TreeNode ret = null;
        if ( null != root && root != left && root != right) {
            if (root.left == left || root.right == right || root.left == right || root.right == left) {
                ret = root;
            } else {
                TreeNode ln = firstCommonAncestor(root.left, left, right);
                TreeNode rn = firstCommonAncestor(root.right, left, right);
                if (ln != null && rn != null) {
                    ret = root;
                } else if (ln != null) {
                    ret = ln;
                } else if (rn != null) {
                    ret = rn;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node4.left = node7;
        node4.right = node8;


        FirstCommonAncestor ancestor = new FirstCommonAncestor();

        for (TreeNode[] nodes : new TreeNode[][] {
                {node4, node8},
                {node3, node7},
                {node1, node5},
                {node7, node6},
                {node8, node4},
                {node5, node6},
                {node8, node7},
                {node4, node7},
        }) {
            TreeNode node = ancestor.firstCommonAncestor(node1, nodes[0], nodes[1]);
            System.out.println((null == node)?("null"):(node.val));
        }
    }

    
}
