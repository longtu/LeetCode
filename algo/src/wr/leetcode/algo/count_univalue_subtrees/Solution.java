package wr.leetcode.algo.count_univalue_subtrees;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        return univalTrees(root).count;
    }

    private MetaData univalTrees(TreeNode root) {
        int count = 0;
        boolean isUnivalue = true;
        if( null != root) {
            if(null != root.left) {
                MetaData leftData  = univalTrees(root.left);
                count += leftData.count;
                isUnivalue = (leftData.isUnivalue) && (root.val == root.left.val)
                                && (isUnivalue);
            }
            if(null != root.right) {
                MetaData rightData = univalTrees(root.right);
                count += rightData.count;
                isUnivalue = (rightData.isUnivalue) && (root.val == root.right.val)
                                && (isUnivalue);
            }
            if(isUnivalue) {
                count += 1;
            }
        }
        return new MetaData(count, isUnivalue);
    }

    public static class MetaData {
        int count;
        boolean isUnivalue;

        public MetaData(int count, boolean isUnivalue) {
            this.count = count;
            this.isUnivalue = isUnivalue;
        }
    }

    public static void main(String[] args) {

    }
}
