package wr.leetcode.algo.kth_smallest_element_in_a_bst;

import wr.leetcode.algo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
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
    }
}
