package wr.leetcode.algo.balanced_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {

    public boolean isBalanced(TreeNode root) {
        return balanced(root) >= 0;
    }


    public int balanced(TreeNode root) {

        int ret;
        if(null == root) {
            ret = 0;
        } else {
            int left = balanced(root.left);
            int right = balanced(root.right);
            if(left < 0 || right < 0 || (Math.abs(left-right) > 1)){
                ret = -1;
            } else {
                ret = Math.max(left, right) + 1;
            }
        }
        return ret;
    }
}
