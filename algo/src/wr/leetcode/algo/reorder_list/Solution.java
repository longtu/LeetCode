package wr.leetcode.algo.reorder_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
        int len = len(head);
        int join = (len+1)/2;
        ListNode node = head;
        for (int i = 1; i < join; ++i) {
            node = node.next;
        }
        if(node != null) {
            ListNode right = reverse(node.next);
            node.next = null;
            merge(head, right);
        }
    }

    public int len (ListNode head) {
        int len = 0;
        while(null != head) {
            head = head.next;
            len ++;
        }
        return len;
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

    public ListNode merge (ListNode left, ListNode right) {
        ListNode helper = new ListNode(-1);
        while(null != left || null != right) {
            if(null != left) {
                helper.next = left;
                helper = left;
                left = left.next;
            }
            if(null != right) {
                helper.next = right;
                helper = right;
                right = right.next;
            }
        }
        return helper.next;
    }
}
