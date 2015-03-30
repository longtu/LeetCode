package wr.leetcode.algo.convert_sorted_array_to_binary_search_tree;

import wr.leetcode.algo.TreeNode;

public class Solution {

    public TreeNode sortedArrayToBST(int[] num, int startInclusive, int endExclusive) {
        if(startInclusive >= endExclusive) {
            return null;
        }
        int mid = (startInclusive + endExclusive)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, startInclusive, mid);
        node.right = sortedArrayToBST(num,mid+1, endExclusive);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if(null == num) {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length);
    }
}
