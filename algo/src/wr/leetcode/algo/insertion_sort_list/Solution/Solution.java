package wr.leetcode.algo.insertion_sort_list.Solution;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode insertionSortList(ListNode head) {

        ListNode ret = new ListNode(-1);
        ListNode helper = ret;

        ListNode node = head;
        while(null != node) {
            ListNode next = node.next;
            ListNode p = helper;
            while(null != p.next && p.next.val < node.val) {
                p = p.next;
            }
            node.next = p.next;
            p.next = node;
            node = next;
        }

        return ret.next;
    }

    /*
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = new ListNode(-1);
        ListNode h = head;
        while( null != h) {
            ListNode hNext = h.next;
            ListNode node = sorted;
            while(null != node.next && node.next.val <= h.val) {
                node = node.next;
            }
            h.next = node.next;
            node.next = h;
            h = hNext;
        }
        return sorted.next;
    }*/
}