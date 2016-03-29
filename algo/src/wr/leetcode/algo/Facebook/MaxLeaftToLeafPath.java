package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

public class MaxLeaftToLeafPath {

    //find max path from one leaf node to another leaf node
    int maxLeafPath(TreeNode root) {
        return maxLeafPathInfo(root).max;
    }

    Info maxLeafPathInfo (TreeNode root) {
        int connected = 0;
        int max = 0;
        if( null != root) {
            int key = root.val;
            Info leftInfo = maxLeafPathInfo(root.left);
            Info rightInfo = maxLeafPathInfo(root.right);
            connected = key + Math.max(rightInfo.connected, leftInfo.connected);
            max = Math.max(leftInfo.max, rightInfo.max);
            if(leftInfo.connected > 0 && rightInfo.connected > 0) {
                max = Math.max(max, key + leftInfo.connected + rightInfo.connected);
            }
        }
        return new Info(connected, max);
    }

    static class Info{
        int connected;
        int max;

        public Info( int connected, int max) {
            this.max = max;
            this.connected = connected;
        }
    }
}
