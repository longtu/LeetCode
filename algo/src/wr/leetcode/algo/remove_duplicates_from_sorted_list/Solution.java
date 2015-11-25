package wr.leetcode.algo.remove_duplicates_from_sorted_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode deleteDuplicates0(ListNode head) {
        ListNode src = new ListNode(-1);
        ListNode ret = new ListNode(-1);
        ListNode dest = ret;
        src.next = head;

        ListNode node = src.next;
        while(node != null) {
            ListNode nodeNext = node.next;
            if(dest == ret || node.val != dest.val) {
                dest.next = node;
                dest = dest.next;
                dest.next = null;
            }
            node = nodeNext;
        }
        return ret.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(-1);
        ListNode ret = helper;
        helper.next = null;

        ListNode node = head;
        while(null != node) {
            if( (null == helper.next) || (helper.next.val != node.val)) {
                if( null != helper.next) {
                    helper = helper.next;
                }
                helper.next = node;
            }
            node = node.next;
        }
        return ret.next;
    }

}
