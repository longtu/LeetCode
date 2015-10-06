package wr.leetcode.algo.remove_linked_list_elements;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode node = helper;
        while(node.next != null) {
            if(node.next.val == val) {
                node.next = remove(node.next);
            } else {
                node = node.next;
            }
        }
        return helper.next;
    }


    public ListNode remove(ListNode node) {
        ListNode ret = node;
        if(null != node) {
            ret = node.next;
            node.next = null;
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
