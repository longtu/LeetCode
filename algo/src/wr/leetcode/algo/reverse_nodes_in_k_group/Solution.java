package wr.leetcode.algo.reverse_nodes_in_k_group;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = 0;
        ListNode end = head;
        while(end != null && ++len < k) {
            end = end.next;
        }
        if(null == end) {
            return head;
        }
        ListNode helper = new ListNode(-1);
        ListNode node = head;
        while(helper.next != end) {
            ListNode nodeNext = node.next;
            node.next = helper.next;
            helper.next = node;
            node = nodeNext;
        }
        head.next = reverseKGroup(end.next, k);
        return helper.next;
    }
}
