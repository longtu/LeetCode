package wr.leetcode.algo.largest_bst_subtree;


import wr.leetcode.algo.TreeNode;

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        return bstTree(root).size;
    }

    public Info bstTree(TreeNode root) {
        Info ret = new Info(true, 0, null, null);
        if ( null != root ) {
            int val = root.val;
            int min = val;
            int max = val;
            int size = 1;
            boolean isBST = true;

            if(null != root.left && null != root.right) {
                Info leftInfo = bstTree(root.left);
                Info rightInfo = bstTree(root.right);
                isBST = leftInfo.isBst && leftInfo.max < val && rightInfo.isBst
                        && rightInfo.min > val;
                size = (isBST)? (size + leftInfo.size + rightInfo.size):
                        (Math.max(leftInfo.size, rightInfo.size));
                min = leftInfo.min;
                max = rightInfo.max;

            } else if (null != root.left) {
                Info leftInfo = bstTree(root.left);
                isBST = leftInfo.isBst && leftInfo.max < val;
                size = (isBST)? (size + leftInfo.size):
                        (leftInfo.size);
                min = leftInfo.min;
            } else if (null != root.right) {
                Info rightInfo = bstTree(root.right);
                isBST = rightInfo.isBst && rightInfo.min > val;
                size = (isBST)? (size + rightInfo.size):
                        (rightInfo.size);
                max = rightInfo.max;
            }
            ret = new Info(isBST, size, min, max);
        }
        return ret;
    }
}

class Info {
    boolean isBst;
    int size;
    Integer min;
    Integer max;

    public Info (boolean isBst, int size, Integer min, Integer max) {
        this.isBst = isBst;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}