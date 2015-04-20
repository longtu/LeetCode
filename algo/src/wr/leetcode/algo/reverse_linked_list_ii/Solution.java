package wr.leetcode.algo.reverse_linked_list_ii;

import wr.leetcode.algo.ListNode;

public class Solution {

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
}