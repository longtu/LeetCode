package wr.leetcode.algo.inorder_successor_in_bst;

import wr.leetcode.algo.TreeNode;

import java.util.Stack;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        if(null != root && null != p) {
            Stack<TreeNode> bigger = new Stack<>();
            TreeNode match = null;
            TreeNode node = root;
            while( null != node ) {
                int key = node.val;
                if(p == node) {
                    match = node;
                    break;
                } else if (key > p.val) {
                    bigger.push(node);
                    //BUG: p.left -> node.left;
                    node = node.left;
                } else {
                    //BUG: p.right -> node.right;
                    node = node.right;
                }
            }
            //BUG: if not found, return null! check for requirements!
            //this can also happen even if there is node with duplicate keys
            if(null != match) {
                //LeftMost of right Child
                if(null != match.right) {
                    ret = leftMostChild(match.right);
                }

                //most recent right parent
                if(!bigger.isEmpty()){
                    if(null == ret || bigger.peek().val < ret.val) {
                        ret = bigger.peek();
                    }
                }
            }
        }
        return ret;
    }

    public TreeNode leftMostChild(TreeNode root) {
        TreeNode node = root;
        while(null != node.left) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();



        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode zero = new TreeNode(0);
        TreeNode two = new TreeNode(2);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        four.left = three;
        four.right = five;
        two.left = zero;
        two.right = four;
        eight.left = seven;
        eight.right = nine;
        six.left = two;
        six.right = eight;


        System.out.println(sol.inorderSuccessor(six, two).val);
        System.out.println(sol.inorderSuccessor(six, five).val);
        System.out.println(sol.inorderSuccessor(six, nine));
        System.out.println(sol.inorderSuccessor(six, zero).val);
        System.out.println(sol.inorderSuccessor(six, six).val);
        System.out.println(sol.inorderSuccessor(eight, six));

    }
}
