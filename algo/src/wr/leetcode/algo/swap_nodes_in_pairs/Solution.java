package wr.leetcode.algo.swap_nodes_in_pairs;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode swapPairs0(ListNode head) {
        ListNode dest = new ListNode(-1);
        ListNode to = dest;

        ListNode node = head;
        while(node != null) {
            ListNode nextNode = node.next;
            if(node.next != null) {
                nextNode = node.next.next;
                to.next = node.next;
                to = to.next;
            }
            to.next = node;
            to = to.next;
            node = nextNode;
        }
        return dest.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode ret = new ListNode(-1);
        ListNode tail = ret;
        while( null != head ) {
            ListNode pair = new ListNode(-1);
            for (int i = 0; i < 2 && null != head; ++i) {
                ListNode next = head.next;
                head.next = pair.next;
                pair.next = head;
                head = next;
            }
            tail.next = pair.next;
            while(null != tail.next) {
                tail = tail.next;
            }
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        ListNode ret = sol.swapPairs(one);
        while(null != ret) {
            System.out.println(ret.val);
            ret = ret.next;
        }

    }
}
