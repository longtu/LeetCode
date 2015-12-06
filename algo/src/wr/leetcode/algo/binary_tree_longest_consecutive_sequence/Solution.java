package wr.leetcode.algo.binary_tree_longest_consecutive_sequence;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public int longestConsecutive(TreeNode root) {
        return longestSeq(root).len;
    }

    public MetaData longestSeq(TreeNode root) {
        int len = 0;
        int connected = 0;

        if (null != root) {
            connected = 1;
            len = 1;
            int key = root.val;

            if(null != root.left) {
                MetaData leftData = longestSeq(root.left);
                len = Math.max(len, leftData.len);
                if(root.left.val == key + 1) {
                    connected = Math.max(leftData.connected + 1, connected);
                }
            }
            if(null != root.right) {
                MetaData rightData = longestSeq(root.right);
                len = Math.max(len, rightData.len);
                if(root.right.val == key + 1) {
                    connected = Math.max(rightData.connected + 1, connected);
                }
            }
            len = Math.max(connected, len);
        }
        return new MetaData(len, connected);
    }

    public class MetaData {
        int len;
        int connected;
        public MetaData (int len, int connected) {
            this.len = len;
            this.connected = connected;
        }
    }
}
