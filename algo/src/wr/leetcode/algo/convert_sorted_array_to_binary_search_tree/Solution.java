package wr.leetcode.algo.convert_sorted_array_to_binary_search_tree;

import wr.leetcode.algo.TreeNode;

import java.util.Arrays;

public class Solution {

    /*

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
    */


    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode ret;
        if(null == nums || 0 == nums.length) {
            ret = null;
        } else {
            int mid = (nums.length - 1)/2;
            ret = new TreeNode(nums[mid]);
            ret.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
            ret.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, nums.length));
        }
        return ret;
    }
}
