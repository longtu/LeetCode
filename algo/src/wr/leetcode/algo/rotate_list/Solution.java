package wr.leetcode.algo.rotate_list;

import wr.leetcode.algo.ListNode;

public class Solution {

    public int len (ListNode head ) {
        int ret = 0;
        while(null != head){
            head = head.next;
            ret ++;
        }
        return ret;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode ret = null;
        int len = len(head);
        if( 0 < len ) {
            k = k%len;
            ListNode fast = head;
            ListNode slow = head;
            int count = 0;
            while(count++ < k) {
                fast = fast.next;
            }
            while(null != fast.next) {
                fast = fast.next;
                slow = slow.next;
            }
            //GOOD: the order below matters
            fast.next = head;
            ret = slow.next;
            slow.next = null;
        }
        return ret;
    }

    /*
    public ListNode rotateRight0(ListNode head, int k) {
		int len = len(head);
		if(0 == len) {
			return head;
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



    public ListNode rotateRight(ListNode head, int k) {
        int len = len(head);
        ListNode ret = new ListNode(-1);
        if( 0 != len ) {
            k = k % len;
            ListNode helper = new ListNode(-1);
            helper.next = head;
            ListNode slow = helper;
            ListNode fast = helper;
            for (int i = 0; i < k ; ++i) {
                fast = fast.next;
            }
            while( null != fast.next ) {
                fast = fast.next;
                slow = slow.next;
            }
            ret.next = slow.next;
            slow.next = null;
            fast.next = head;
        }
        return ret.next;
    }*/
}
