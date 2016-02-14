package wr.leetcode.algo.lowest_common_ancestor_of_a_binary_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret = null;
        if (null != root) {
            if( p == root || q == root ) {
                ret = root;
            } else {
                TreeNode left = lowestCommonAncestor(root.left, p, q);
                TreeNode right = lowestCommonAncestor(root.right, p, q);
                if( null == left && null == right) {
                    ret = null;
                } else if ( null != left ) {
                    ret = left;
                }  else if (null != right ) {
                    ret = right;
                } else {
                    ret = root;
                }
            }
        }
        return ret;
    }

    public class MetaData {
        boolean containsP;
        boolean containsQ;
        TreeNode lca;
    }

    public MetaData contains( TreeNode root, TreeNode p, TreeNode q) {
        MetaData ret = new MetaData();
        boolean containsP = (root == p);
        boolean containsQ = (root == q);
        TreeNode lca = null;

        if(null != root.left) {
            MetaData left = contains(root.left, p, q);
            containsP |= left.containsP;
            containsQ |= left.containsQ;
            if(null != left.lca) {
                lca = left.lca;
            }
        }

        if(null != root.right) {
            MetaData right = contains(root.right, p, q);
            containsP |= right.containsP;
            containsQ |= right.containsQ;
            if(null != right.lca) {
                lca = right.lca;
            }
        }

        if(null == lca && (containsP && containsQ)) {
            lca = root;
        }

        ret.containsP = containsP;
        ret.containsQ = containsQ;
        ret.lca = lca;
        return ret;
    }

    public TreeNode lowestCommonAncestor0(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ret;
        if( null == root || (null == p && null == q)) {
            ret = null;
        } else if (null == p) {
            ret = q;
        } else if (null == q) {
            ret = p;
        } else {
            ret = contains(root,p,q).lca;
        }
        return ret;
    }

}