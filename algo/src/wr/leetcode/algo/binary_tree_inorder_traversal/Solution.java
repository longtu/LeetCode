package wr.leetcode.algo.binary_tree_inorder_traversal;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ret = new LinkedList<>();

        stackSubLefts(st, root);
        while(!st.isEmpty()) {
            TreeNode n = st.pop();
            ret.add(n.val);
            stackSubLefts(st, n.right);
        }
        return ret;
    }

    public void stackSubLefts(Stack<TreeNode> st, TreeNode root) {
        TreeNode node = root;
        while(null != node) {
            st.push(node);
            node = node.left;
        }
    }
}
