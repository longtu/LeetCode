package wr.leetcode.algo.path_sum_ii;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if( null == root ) {
            return false;
        }
        if(null == root.left && null == root.right) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum-root.val);
    }

}