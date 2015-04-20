package wr.leetcode.algo.remove_duplicates_from_sorted_list_ii;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode helper = new ListNode(-1);
        ListNode n = helper;

        ListNode node = head;
        while (node != null) {
            if(null == node.next || node.val != node.next.val) {
                n.next = node;
                n = n.next;
                n.next = null;
            } else {
                int val = node.val;
                while(null != node && node.val == val) {
                    node = node.next;
                }
                continue;
            }
            node = node.next;
        }
        return helper.next;
    }
}
