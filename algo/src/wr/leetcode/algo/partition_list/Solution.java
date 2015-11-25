package wr.leetcode.algo.partition_list;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode smallEnd = small;
        ListNode big = new ListNode(-1);
        ListNode bigEnd = big;

        while (null != head) {
            ListNode next = head.next;
            if(head.val >= x) {
                head.next = bigEnd.next;
                bigEnd.next = head;
                bigEnd = bigEnd.next;
            } else {
                head.next = smallEnd.next;
                smallEnd.next = head;
                smallEnd = smallEnd.next;
            }
            head = next;
        }
        smallEnd.next = big.next;
        return small.next;
    }

    /*
    public ListNode partition(ListNode head, int x) {

        ListNode bigHead = new ListNode(-1);
        ListNode big = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode small = smallHead;
        small.next = head;

        while(small.next != null){
            if(small.next.val >= x) {
                big.next = small.next;
                small.next = small.next.next;
                big = big.next;
                big.next = null;
            } else {
                small = small.next;
            }
        }
        small.next = bigHead.next;
        return smallHead.next;
    }*/
}