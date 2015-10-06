package wr.leetcode.algo.reverse_linked_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = null;

        ListNode node = head;
        ListNode next = null;
        while(node != null) {
            next = node.next;
            node.next = helper.next;
            helper.next = node;
            node = next;
        }
        return helper.next;
    }
}
