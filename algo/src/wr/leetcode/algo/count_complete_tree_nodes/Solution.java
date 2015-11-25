package wr.leetcode.algo.count_complete_tree_nodes;


import wr.leetcode.algo.TreeNode;

public class Solution {

    public int countNodes(TreeNode root) {
        int ret = 0;
        if(null != root) {
            int l = leftHeight(root);
            int r = rightHeight(root);
            if(r == l) {
                ret += (1<<l) - 1;
            } else {
                ret = 1 + countNodes(root.left) + countNodes(root.right);
            }
        }
        return ret;
    }

    public int leftHeight(TreeNode root) {
        int ret = 0;
        while(null != root) { /*BUG: use iterative to save time*/
            ret += 1;
            root = root.left;
        }
        return ret;
    }

    public int rightHeight(TreeNode root) {
        int ret = 0;
        while(null != root) {
            ret += 1;
            root = root.right;
        }
        return ret;
    }



/*
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
    }*/

}
