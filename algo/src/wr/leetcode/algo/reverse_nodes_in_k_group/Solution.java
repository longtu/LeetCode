package wr.leetcode.algo.reverse_nodes_in_k_group;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode reverseKGroup0(ListNode head, int k) {
        int len = 0;
        ListNode end = head;
        while(end != null && ++len < k) {
            end = end.next;
        }
        if(null == end) {
            return head;
        }
        ListNode tail = end.next;
        ListNode helper = new ListNode(-1);
        ListNode node = head;
        while(helper.next != end) {
            ListNode nodeNext = node.next;
            node.next = helper.next;
            helper.next = node;
            node = nodeNext;
        }
        head.next = reverseKGroup(tail, k);
        return helper.next;
    }




    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode ret = helper;

        if(k <= 1) {
            return head;
        }
        ListNode node = helper.next;
        while(null != node) {
            ListNode nextStart = node;
            int len = 0;
            while( null != nextStart && len < k) {
                nextStart = nextStart.next;
                len ++;
            }
            if(len == k) {
                helper.next = reverseByK(node, k);
            } else {
                helper.next = node;
            }
            while(null != helper.next) {
                helper = helper.next;
            }
            node = nextStart;
        }
        return ret.next;
    }

    ListNode reverseByK(ListNode head, int k) {
        ListNode ret = new ListNode(-1);
        ListNode node = ret;
        while( null != head && k > 0){
            System.out.println("x");
            ListNode headNext = head.next;
            head.next = node.next;
            node.next = head;//
            head = headNext;
            k--;
        }

        return ret.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode h = sol.reverseKGroup(n1, 5);
        while( null != h) {
            System.out.println( "node:" + h.val);
            h = h.next;
        }
    }

}
