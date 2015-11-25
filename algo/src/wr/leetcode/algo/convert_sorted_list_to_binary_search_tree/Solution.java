package wr.leetcode.algo.convert_sorted_list_to_binary_search_tree;

import wr.leetcode.algo.ListNode;
import wr.leetcode.algo.TreeNode;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int len = len(head);
        if ( 0 == len) {
            return null;
        }
        int mid = len/2;
        ListNode midNode = head;
        for (int i = 0; i < mid; ++i) {
            ListNode next = midNode.next;
            if( i == mid - 1 ) {
                midNode.next = null;
            }
            midNode = next;
        }
        TreeNode node = new TreeNode(midNode.val);
        if(len > 1) {
            node.left = sortedListToBST(head);
            node.right = sortedListToBST(midNode.next);
        }
        return node;
    }

    public int len (ListNode head){
        int ret = 0;
        while(null != head ) {
            head = head.next;
            ret ++;
        }
        return ret;
    }
}