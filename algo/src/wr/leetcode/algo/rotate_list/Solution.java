package wr.leetcode.algo.rotate_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
		int len = len(head);
		if(0 == len) {
			return;
		}
    	k = k%len;

    	ListNode helper = new ListNode(-1);
    	helper.next = head;
    	ListNode fast = helper;
    	ListNode slow = helper;

    	int i = 0;
    	while(fast.next != null) {
    		i++;
    		fast = fast.next;
    		if(i > k) {
    			slow = slow.next;
    		}
    	}
    	fast.next = helper.next;
    	helper.next = slow.next;
    	slow.next = null;
    	return helper.next;
    }

    public int len( ListNode head){
        int len = 0;
        while(head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
