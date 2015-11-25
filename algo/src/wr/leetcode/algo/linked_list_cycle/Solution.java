package wr.leetcode.algo.linked_list_cycle;

import wr.leetcode.algo.ListNode;

public class Solution {


    public boolean hasCycle(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode fast = helper;
        ListNode slow = helper;

        while(null != fast) {
            fast = fast.next;
            if(null != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            if(slow == fast) {
                break;
            }
        }
        return (slow == fast);
    }


}
