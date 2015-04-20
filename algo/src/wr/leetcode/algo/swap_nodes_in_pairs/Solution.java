package wr.leetcode.algo.swap_nodes_in_pairs;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dest = new ListNode(-1);
        ListNode to = dest;

        ListNode node = head;
        while(node != null) {
            ListNode nextNode = node.next;
            if(node.next != null) {
                nextNode = node.next.next;
                to.next = node.next;
                to = to.next;
            }
            to.next = node;
            to = to.next;
            to.next = null;
            node = nextNode;
        }
        return dest.next;
    }
}
