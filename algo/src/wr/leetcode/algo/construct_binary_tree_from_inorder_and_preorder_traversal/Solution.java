package wr.leetcode.algo.construct_binary_tree_from_inorder_and_preorder_traversal;

import wr.leetcode.algo.TreeNode;

import java.util.Arrays;

public class Solution {

    /*
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
    }*/

    public int[] notNull(int[] arr) {
        return (null == arr) ? (new int[0]) : (arr);
    }


    public TreeNode buildTree( int[] preorder, int[] inorder) {
        preorder = notNull(preorder);
        inorder = notNull(inorder);

        TreeNode ret = null;
        if( preorder.length > 0 ) {
            int mid = preorder[0];
            int inorderSplit = find(inorder, mid);
            ret = new TreeNode(mid);
            int[] preLeft = Arrays.copyOfRange(preorder, 1, inorderSplit + 1);
            int[] preRight = Arrays.copyOfRange(preorder, inorderSplit + 1, preorder.length);
            int[] inLeft = Arrays.copyOfRange(inorder, 0, inorderSplit);
            int[] inRight = Arrays.copyOfRange(inorder, inorderSplit+1, inorder.length);
            ret.left = buildTree(preLeft, inLeft);
            ret.right = buildTree(preRight, inRight);
        }
        return ret;
    }
    public int find(int[] arr, int key) {
        int ret = 0;
        for (int i = 0; i < arr.length; ++i) {
            if( key == arr[i]) {
                ret = i;
                break;
            }
        }
        return ret;
    }


    /* NOT BINARY SEARCH TREE!!!!
    public int find(int[] arr, int key) {

        int start = 0;
        int end = arr.length-1;
        int found = 0;
        while(start <= end) {
            int mid = start + ((end-start) >> 1);
            int val = arr[mid];
            if( val > key) {
                end = mid - 1;
            }else if (val < key) {
                start = mid + 1;
            } else {
                found = mid;
                break;
            }
        }
        System.out.println("W " + found);
    }
    */

    public static void main(String[] args) {



        Solution sol = new Solution();
        int[] pre =  {1,2};
        int[] in =  {2,1};

        TreeNode node = sol.buildTree(pre, in);
        System.out.println(node.val);
        System.out.println(node.left);
        System.out.println(node.right);
    }

}
