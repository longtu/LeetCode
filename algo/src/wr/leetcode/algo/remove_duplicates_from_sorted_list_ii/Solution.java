package wr.leetcode.algo.remove_duplicates_from_sorted_list_ii;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode deleteDuplicatesWEAK(ListNode head) {

        ListNode helper = new ListNode(-1);
        ListNode n = helper;

        ListNode node = head;
        while (node != null) {
            if(null == node.next || node.val != node.next.val) {
                n.next = node;
                n = n.next;
            } else {
                int val = node.val;
                while(null != node && node.val == val) {
                    node = node.next;
                }
                continue;
            }
            node = node.next;
        }
        n.next = null;
        return helper.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode prev = helper;
        while(prev.next != null) {
            ListNode node = prev.next;
            int count = 0;
            while(node != null && node.val == prev.next.val){
                node = node.next;
                count ++;
            }
            if(count != 1) {
                prev.next = node;
            } else {
                prev = prev.next;
            }
        }
        return helper.next;
    }
}
