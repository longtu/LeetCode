package wr.leetcode.algo.reorder_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        int len = len(head);
        if( 0 == len) {
            return;
        }

        int half = (len-1)/2;
        ListNode lt = head;
        for (int i = 0; i < half; ++i) {
            lt = lt.next;
        }
        ListNode rh = reverse(lt.next);
        lt.next = null;

        ListNode ret = new ListNode(-1);
        ListNode helper = ret;
        ListNode lhNext;
        for (ListNode lh = head ; null != lh; lh = lhNext) {
            lhNext = lh.next;
            lh.next = helper.next;
            helper.next = lh;
            helper = helper.next;
            if(null != rh) {
                ListNode rhNext = rh.next;
                rh.next = helper.next;
                helper.next = rh;
                helper = helper.next;
                rh = rhNext;
            }
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode helper = new ListNode(-1);
        while(null != head) {
            ListNode headNext = head.next;
            head.next = helper.next;
            helper.next = head;
            head = headNext;
        }
        return helper.next;
    }

    public int len(ListNode head) {
        int len = 0;
        while(null != head) {
            len ++;
            head = head.next;
        }
        return len;
    }
}
