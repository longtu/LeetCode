package wr.leetcode.algo.intersection_of_two_linked_lists;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = len(headA);
        int lenB = len(headB);
        if(lenA < lenB) {
            return getIntersectionNode(headB, headA);
        }
        int diff = lenA - lenB; //diff >= 0

        while( null != headA){
            if(diff > 0) {
                headA = headA.next;
                diff --;
            } else {
                if(headA == headB){
                    break;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return headA;
    }

    public int len (ListNode head) {
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
