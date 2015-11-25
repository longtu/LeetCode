package wr.leetcode.algo.linked_list_cycle_ii;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(null == head) {
            return null;
        }
        //at least one node
        while( null != fast ) {
            fast = fast.next;
            if(null != fast) {
                fast = fast.next;
                slow = slow.next;
            }
            if(fast == slow) {
                break;
            }
        }

        ListNode ret = null;
        if(fast == slow) {
            fast = head;
            while(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            ret = fast;
        }
        return ret;
    }



    public ListNode detectCycle0(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while(null != fast) {
            fast = fast.next;
            if(null != fast) {
                fast = fast.next;
                slow = slow.next;
                if( slow == fast) {
                    break;
                }
            }
        }
        if(null != fast) {
            fast = head;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
        }
        return fast;
    }
}
