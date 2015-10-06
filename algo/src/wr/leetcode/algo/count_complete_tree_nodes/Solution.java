package wr.leetcode.algo.count_complete_tree_nodes;


import wr.leetcode.algo.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
        int val = 0;
        if(null != root) {
            val = countNodes(root, null, null);
        }
        return val;
    }

    public int countNodes(TreeNode root, Integer lh, Integer rh) {
        int val = 0;
        if(null != root) {
            lh = (null == lh)?(leftHeight(root)):(lh);
            rh = (null == rh)?(rightHeight(root)):(rh);
            if (lh == rh) {
                val = 1;
                for(int i = 0; i < lh; ++i){
                    val *= 2;
                }
                val = val - 1;
            } else {
                val = 1 + countNodes(root.left, lh-1, null)
                 + countNodes(root.right, null, rh-1);
            }
        }
        return val;
    }

    public int leftHeight(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return  1 + leftHeight(root.left);
    }
    public int rightHeight(TreeNode root) {
        if(null == root) {
            return 0;
        }
        return  1 + rightHeight(root.right);
    }
}
