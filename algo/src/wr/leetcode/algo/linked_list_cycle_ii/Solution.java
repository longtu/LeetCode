package wr.leetcode.algo.linked_list_cycle_ii;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if(null == fast ) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
            //fast/slow meets, there is a cycle
            if(fast == slow) {
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
