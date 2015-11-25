package wr.leetcode.algo.palindrome_linked_list;

import wr.leetcode.algo.ListNode;

class Solution {

    public int len(ListNode node) {
        int len = 0;
        while(null != node) {
            node = node.next;
            len++;
        }
        return len;
    }

    public boolean isPalindrome(ListNode head) {
        boolean ret = true;
        int len = len(head);
        if( len > 1 ) {
            int half = len/2;
            ListNode helper = new ListNode(-1);
            int count = 0;
            while( count++ < half ) {
                ListNode next = head.next;
                head.next = helper.next;
                helper.next = head;
                head = next;
            }
            if(1 == len%2) {
                head = head.next;
            }
            ListNode l = helper.next;
            ListNode r = head;
            while( l != null) {
                if(l.val != r.val) {
                    ret = false;
                    break;
                }
                l = l.next;
                r = r.next;
            }
        }
        return ret;
    }







    /*
    public boolean isPalindrome(ListNode head) {
        boolean ret = true;
        int len = size(head);
        if( len  > 1 ) {
            int half = (len + 1)/2;
            ListNode r = head;
            for (int i = 0; i < half; ++i) {
                r = r.next;
            }
            ListNode rr = reverse(r);
            ListNode h = head;
            int end = len/2 - 1;
            for (int i = 0; i <= end; ++i) {
                System.out.println(h.val + ":" + rr.val);
                if( rr.val != h.val) {
                    ret = false;
                    break;
                } else {
                    rr = rr.next;
                    h = h.next;
                }
            }
        }
        return ret;
    }

    public int size ( ListNode head) {
        int len = 0;
        while(null != head) {
            len++;
            head = head.next;
        }
        return len;
    }

    public ListNode reverse(ListNode head) {
        ListNode helper = new ListNode(-1);
        while(null != head){
            ListNode next = head.next;
            head.next = helper.next;
            helper.next = head;
            head = next;
        }
        return helper.next;
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        System.out.println(sol.isPalindrome(n1));
    }
}