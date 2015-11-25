package wr.leetcode.algo.reverse_linked_list_ii;

import wr.leetcode.algo.ListNode;

public class Solution {
/*
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dest = new ListNode(-1);
        ListNode ret = dest;
        ListNode node = head;
        for(int i = 1; i < m; ++i ) {
            ListNode nodeNext = node.next;
            dest.next = node;
            dest = dest.next;
            dest.next = null;
            node = nodeNext;
        }

        ListNode reverse = new ListNode(-1);
        ListNode lastReverse = node;
        for(int i = m; i<=n; ++i) {
            ListNode nodeNext = node.next;
            node.next = reverse.next;
            reverse.next = node;
            node = nodeNext;
        }
        dest.next = reverse.next;
        lastReverse.next = node;
        return ret.next;
    }
    */


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode l,r ;

        ListNode node = helper;
        for (int i = 0; i < m - 1; ++i){
            node = node.next;
        }
        l = node;

        ListNode rHead = new ListNode(-1);
        rHead.next = null;
        node = l.next;
        for (int i = m; i <= n; ++i) {
            ListNode next = node.next;
            node.next = rHead.next;
            rHead.next = node;
            node = next;
        }
        r = node;

        l.next.next = r;
        l.next = rHead.next;
        return helper.next;
    }

}