package wr.leetcode.algo.odd_even_linked_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        odd.next = head;
        ListNode h = odd;
        ListNode even = new ListNode(-1);
        ListNode eh = even;

        int cnt = 1;
        while(null != h.next) {
            if((cnt & 1) == 0) {
                ListNode next = h.next.next;
                h.next.next = eh.next;
                eh.next = h.next;
                eh = eh.next;
                h.next = next;
            } else {//BUG: this line below should not apply to both branches
                h = h.next;
            }
            cnt++;
        }

        h.next = even.next;
        return odd.next;
    }
}
