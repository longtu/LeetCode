package wr.leetcode.algo.sort_list;

import wr.leetcode.algo.ListNode;

public class Solution {
    public ListNode sortList(ListNode head) {
        int len = len(head);
        return sortList(head, len);
    }

    public int len(ListNode head) {
        int len = 0;
        while(null != head) {
            len ++;
            head = head.next;
        }
        return len;
    }

    public ListNode sortList(ListNode head, int len) {
        if(len == 0) {
            return null;
        }
        if(len ==1) {
            head.next = null;
            return head;
        }
        int leftLen = (len)/2;
        int rightLen = len - leftLen;
        ListNode rightHead = head;
        for(int i = 0; i < leftLen; ++i ){
            rightHead = rightHead.next;
        }
        ListNode left = sortList(head,leftLen);
        ListNode right = sortList(rightHead,rightLen);

        ListNode helper = new ListNode(-1);
        ListNode node = helper;
        while(left != null || right != null) {
            if(left == null) {
                node.next = right;
                right = right.next;
            } else if (right == null){
                node.next = left;
                left = left.next;
            } else {
                if(left.val < right.val) {
                    node.next = left;
                    left = left.next;
                } else {
                    node.next = right;
                    right = right.next;
                }
            }
            node = node.next;
        }
        return helper.next;
    }

}
