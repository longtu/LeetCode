package wr.leetcode.algo.path_sum;

import wr.leetcode.algo.TreeNode;

public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean ret = false;

        if(null != root) {
            sum -= root.val;
            if(null == root.left && null == root.right) {
                ret = (sum == 0);
            } else {
                if (null != root.left) {
                    ret |= hasPathSum(root.left, sum);
                }
                if (null != root.right) {
                    ret |= hasPathSum(root.right, sum);
                }
            }
        }
        return ret;
    }
}
