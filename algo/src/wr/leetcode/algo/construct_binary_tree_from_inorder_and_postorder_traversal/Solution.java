package wr.leetcode.algo.construct_binary_tree_from_inorder_and_postorder_traversal;

import wr.leetcode.algo.TreeNode;

import java.util.Arrays;

public class Solution {

    /*
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(null == inorder || null == postorder || 0 ==inorder.length || 0 == postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int iStartInclusive, int iEndExclusive,
                              int[] postorder, int pStartInclusive, int pEndExclusive) {

        if(pStartInclusive >= pEndExclusive) {
            return null;
        }

        int split = 0;
        for ( int i = iStartInclusive; i< iEndExclusive; ++i) {
            if(inorder[i] == postorder[pEndExclusive-1]){
                split = i;
            }
        }

        TreeNode node = new TreeNode( postorder[pEndExclusive-1] );
        node.left = buildTree(inorder, iStartInclusive, split, postorder, pStartInclusive, pStartInclusive + (split-iStartInclusive));
        node.right = buildTree(inorder, split+1, iEndExclusive, postorder, pStartInclusive + (split-iStartInclusive), pEndExclusive-1);
        return node;
    }*/


    public int[] notNull(int[] arr) {
        return (null == arr) ? (new int[0]) : (arr);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorder = notNull(inorder);
        postorder = notNull(postorder);

        TreeNode node = null;
        if(inorder.length > 0) {
            int n = postorder.length;
            int root = postorder[n-1];
            int inorderSplit = 0;
            for (int i = 0; i < n; ++i) {
                if(root == inorder[i]) {
                    inorderSplit = i;
                    break;
                }
            }
            node = new TreeNode(root);
            node.left = buildTree(Arrays.copyOfRange(inorder, 0, inorderSplit),
                    Arrays.copyOfRange(postorder,0,inorderSplit));
            node.right = buildTree(Arrays.copyOfRange(inorder, inorderSplit+1, n),
                    Arrays.copyOfRange(postorder,inorderSplit,n-1));
        }
        return node;
    }

}
