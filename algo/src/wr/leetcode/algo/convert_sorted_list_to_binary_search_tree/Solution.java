package wr.leetcode.algo.convert_sorted_list_to_binary_search_tree;

import wr.leetcode.algo.ListNode;
import wr.leetcode.algo.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, len(head));
    }

    public TreeNode sortedListToBST(ListNode head, int len) {
        if(len == 0) {
            return null;
        }
        int leftLen = (len+1)/2;
        ListNode node = head;
        for (int i = 1; i < leftLen; ++i) {
            node = node.next;
        }
        TreeNode left = sortedListToBST(head, leftLen - 1);
        TreeNode right = sortedListToBST(node.next, len - leftLen - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        root.right = right;
        return root;
    }

    public int len (ListNode node) {
        int len = 0;
        while(node != null) {
            len ++;
            node = node.next;
        }
        return len;
    }
}