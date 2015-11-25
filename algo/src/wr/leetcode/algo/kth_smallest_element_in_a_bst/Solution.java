package wr.leetcode.algo.kth_smallest_element_in_a_bst;

import wr.leetcode.algo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    /*
    public int kthSmallest(TreeNode root, int k) {

        List<TreeNode> nodes = new ArrayList<>(k);
        inOrder(root, nodes, k);
        return nodes.get(k-1).val;
    }

    public void inOrder(TreeNode root, List<TreeNode> res, int k) {
        if( null == root) {
            return;
        }

        if( null != root.left ) {
            inOrder(root.left, res,k);
            if( k == res.size() ) {
                return;
            }
        }
        res.add(root);
        if( k == res.size() ) {
            return;
        }

        if(null != root.right) {
            inOrder(root.right, res,k);
        }
    }*/

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        int ret = 0;
        int i = 0;
        TreeNode node;
        pushAll(root, st);
        while(!st.isEmpty()) {
            node = st.pop();
            i++;
            if( k == i) {
                ret = node.val;
            }
            pushAll(node.right, st);
        }
        return ret;
    }

    public void pushAll(TreeNode root, Stack<TreeNode> st) {
        TreeNode node = root;
        while(null != node) {
            st.push(node);
            node = node.left;
        }
    }
}
