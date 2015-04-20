package wr.leetcode.algo.remove_duplicates_from_sorted_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode src = new ListNode(-1);
        ListNode dest = new ListNode(-1);
        ListNode ret = dest;
        src.next = head;

        ListNode node = src.next;
        while(node != null) {
            if(dest.next != null && dest.next.val == node.val) {
                node = node.next;
            }
            if(node != null) {
                dest.next = node;
                dest = dest.next;
             }
        }
        dest.next = null;
        return ret.next;
    }

}
