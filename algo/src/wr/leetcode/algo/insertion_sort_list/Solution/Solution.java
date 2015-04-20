package wr.leetcode.algo.insertion_sort_list.Solution;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode src = new ListNode(-1);
        ListNode dest = new ListNode(-1);
        src.next = head;

        while(src.next != null) {
            ListNode insert = src.next;
            src.next = insert.next;
            ListNode node = dest;
            while(node.next != null) {
                if (node.next.val >= insert.val) {
                    break;
                }
                node = node.next;
            }
            ListNode nodeNext = node.next;
            node.next = insert;
            insert.next = nodeNext;
        }
        return dest.next;
    }
}