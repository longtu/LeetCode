package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.binary_search_tree_iterator.BSTIterator;
import wr.leetcode.algo.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class ExtractLeaves {

    /**
     * V1: use a list to return
     */
    public List<TreeNode> getLeaves (TreeNode root) {
        List<TreeNode> ret = new LinkedList<>();
        getLeaves(root, ret);
        return ret;
    }

    public void getLeaves(TreeNode root, List<TreeNode> leaves) {
        if (null != root) {
            if( null == root.left && null == root.right) {
                leaves.add(root);
            }
            if( null != root.left) {
                getLeaves(root.left, leaves);
            }
            if( null != root.right) {
                getLeaves(root.right, leaves);
            }
        }
    }

    /**
     * Re-use the tree structure
     *
     * This solution can add all the nodes, but it breaks the original tree structure,
     * in order to make the original tree happy, need to extract the leaf nodes.
     */
    public TreeNode getLeavesV2 (TreeNode root) {
        BSTIterator iterator = new BSTIterator(root);
        TreeNode helper = new TreeNode(-1);
        TreeNode ret = helper;

        while(iterator.hasNext()) {
            TreeNode node = iterator.nextNode();
            if(null == node.left && null == node.right) {
                helper.right = node;
                if (ret != helper) {
                    node.left = helper;
                }
                helper = helper.right;
            }
        }
        return ret.right;
    }

    /**
     * remove nodes using return values.
     */
    public TreeNode extractLeaves(TreeNode root) {
        TreeNode [] arr = new TreeNode[1];
        TreeNode helper = new TreeNode(-1);
        arr[0] = helper;
        extractLeaves(root, helper, arr);
        return helper.right;
    }

    public TreeNode extractLeaves(TreeNode root, TreeNode helper, TreeNode[] prevArr) {
        if( null == root ) {
            return root;
        }
        TreeNode ret = root;
        if( null == root.left && null == root.right) {
            TreeNode prev = prevArr[0];
            prev.right = root;
            prevArr[0] = root;
            if( prev != helper ) {
                root.left = prev;
            }
            ret = null;
        } else {
            root.left = extractLeaves(root.left, helper, prevArr);
            root.right = extractLeaves(root.right, helper, prevArr);
        }
        return ret;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.right = new TreeNode(10);

        ExtractLeaves sol = new ExtractLeaves();

        System.out.println("Inorder traversal of given tree is : ");
        inorder(root);
        System.out.println("");
        System.out.println("Extracted double link list is : ");
        TreeNode head = sol.extractLeaves(root);
        printDLL(head);
        System.out.println("");
        System.out.println("Inorder traversal of modified tree is : ");
        inorder(root);

    }

    public static void  printDLL(TreeNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }

    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

}
