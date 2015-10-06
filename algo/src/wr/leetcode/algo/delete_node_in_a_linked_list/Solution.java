package wr.leetcode.algo.delete_node_in_a_linked_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        if(null!= node && null != node.next) {
            ListNode next = node.next;
            node.next = next.next;
            node.val = next.val;
            next.next = null;
        }
    }
}