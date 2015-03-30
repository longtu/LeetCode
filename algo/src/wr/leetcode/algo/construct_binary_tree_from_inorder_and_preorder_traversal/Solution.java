package wr.leetcode.algo.construct_binary_tree_from_inorder_and_preorder_traversal;

import wr.leetcode.algo.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null == preorder || null == inorder || 0 == preorder.length || 0 == inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTree(int [] preorder, int pStartInclusive, int pEndExclusive,
                              int [] inorder,  int iStartInclusive, int iEndExclusive) {

        if(iStartInclusive >= iEndExclusive) {
            return null;
        }

        int sep = 0;
        for (int i = 0; i < iEndExclusive; ++i) {
            if(inorder[i] == preorder[pStartInclusive]) {
                sep = i;
                break;
            }
        }

        TreeNode node = new TreeNode(inorder[sep]);
        node.left = buildTree(preorder,pStartInclusive +1, sep - iStartInclusive + pStartInclusive +1,inorder, iStartInclusive, sep );
        node.right = buildTree(preorder, sep - iStartInclusive + pStartInclusive +1, pEndExclusive, inorder, sep+1, iEndExclusive );
        return node;
    }
}
