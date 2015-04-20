package wr.leetcode.algo.merge_two_sorted_lists;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode helper = new ListNode(-1);
        ListNode head = helper;
        while(l1 != null || l2 != null) {
            if(null == l1) {
                helper.next = l2;
                break;
            } else if (null == l2) {
                helper.next = l1;
                break;
            } else {
                if(l1.val <= l2.val) {
                    helper.next = l1;
                    l1 = l1.next;
                } else {
                    helper.next = l2;
                    l2 = l2.next;
                }
                helper = helper.next;
            }
        }
        return head.next;
    }
}
