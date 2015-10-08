package wr.leetcode.algo.add_two_numbers;

import wr.leetcode.algo.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode left = l1;
        ListNode right = l2;

        ListNode helper = new ListNode(-1);
        ListNode node = helper;
        int carry = 0;
        /**
         * BUG: you might have missed edge case : carry > 0
         */
        while(left != null || right != null || carry > 0) {
            int sum = carry;
            if(null != left){
                sum += left.val;
                left = left.next;
            }
            if (null != right) {
                sum += right.val;
                right = right.next;
            }
            carry = sum/10;
            node.next = new ListNode(sum%10);
            node = node.next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode node = sol.addTwoNumbers(one, two);
        while( null != node ) {
            System.out.println(node.val);
        }
    }
}
