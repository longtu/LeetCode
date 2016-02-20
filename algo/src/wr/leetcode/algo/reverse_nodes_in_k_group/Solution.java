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
        head.next = reverseKGroup0(tail, k);
        return helper.next;
    }




    public ListNode reverseKGroup1(ListNode head, int k) {
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
                helper.next = reverseByK1(node, k);
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

    ListNode reverseByK1(ListNode head, int k) {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ret = new ListNode(-1);
        ListNode tail = ret;
        if (k <= 1 ) {
            return head;
        }
        while(null != head) {
            if (hasMoreThanK(head, k)) {
                ListNode group = new ListNode(-1);
                for (int i = 0; i <k; ++i) {
                    ListNode next = head.next;
                    head.next = group.next;
                    group.next = head;
                    head = next;
                }
                tail.next = group.next;
                while( null != tail.next ) {
                    tail = tail.next;
                }
            } else {
                tail.next = head;
                head = null;
            }
        }
        return ret.next;
    }

    public boolean hasMoreThanK (ListNode head, int k) {
        boolean ret = false;
        for (int i = 0; i < k && null != head; ++i) {
            head = head.next;
            if (k-1 == i) {
                ret = true;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode h = sol.reverseKGroup(n1, 2);
        while( null != h) {
            System.out.println( "node:" + h.val);
            h = h.next;
        }
    }

}
