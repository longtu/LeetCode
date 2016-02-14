package wr.leetcode.algo.closest_binary_search_tree_value;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public int closestValue0(TreeNode root, double target) {
        int close = -1;
        double minDiff = Double.MAX_VALUE;

        TreeNode node = root;
        while(null != node) {
            int val = node.val;
            double diff = target - val;
            double absDiff = Math.abs(diff);
            if(absDiff < minDiff) {
                minDiff = absDiff;
                close = val;
            }
            if(0 == diff) {
                break;
            } else if (diff > 0) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return close;
    }

    public int closestValue(TreeNode root, double target) {
        if (null == root) {
            throw new IllegalStateException("Invalid Input empty root");
        }
        int ret = 0;
        double minDiff = Double.MAX_VALUE;
        while( null != root && minDiff != 0d) {
            double diff = Math.abs(root.val - target);
            if (diff < minDiff) {
                minDiff = diff;
                ret = root.val;
            }
            if (ret < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ret;
    }
}