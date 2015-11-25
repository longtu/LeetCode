package wr.leetcode.algo.remove_duplicates_from_sorted_list_ii;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dest = new ListNode(-1);
        ListNode ret = dest;
        dest.next = null;

        ListNode node = head;
        int count = 0;
        ListNode pr = null;
        while( null != node ) {
            if( null == pr ) {
                pr = node;
                count = 1;
            } else if ( pr.val == node.val) {
                count ++;
            } else {
                if (1 == count) {
                    dest.next = pr;
                    pr.next = null;
                    dest = dest.next;
                }
                pr = node;
                count = 1;
            }
            node = node.next;
        }
        if (1 == count) {
            dest.next = pr;
            pr.next = null;
        }
        return ret.next;
    }
}
