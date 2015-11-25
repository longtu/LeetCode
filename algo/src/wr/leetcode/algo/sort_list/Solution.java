package wr.leetcode.algo.sort_list;

import wr.leetcode.algo.ListNode;

public class Solution {


    public int len(ListNode head) {
        int len = 0;
        while(null != head) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode sortList(ListNode head) {
        ListNode ret;
        int len = len(head);
        //BUG: has to be greater than 1 to recur
        if(1 >= len) {
            ret = head;
        } else {//mid >=1
            int mid = (len+1)/2;
            ListNode node = head;
            ListNode right = null;
            for (int i = 0; i < mid; ++i) {
                if(mid-1 == i) {
                    right = node.next;
                    node.next = null;
                    System.out.println(node.val);
                }
                //BUG: node = node.next;
                node = node.next;
            }
            ListNode left = sortList(head);
            right = sortList(right);
            ret = merge(left, right);
        }
        return ret;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode ret = new ListNode(-1);
        ListNode node = ret;

        while(null != left && null != right) {
            if( left.val <= right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        while(null != left || null != right) {
            if(null != left) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        return ret.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        two.next = one;
    }

        /*
    public ListNode sortList(ListNode head) {

        int len = len(head);
        if( len <= 1 ) {
            return head;
        }

        int half = (len-1)/2;
        ListNode lt = head;
        for ( int i = 0; i < half; ++i) {
            lt = lt.next;
        }
        ListNode rh = lt.next;
        lt.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rh);
        return merge(left, right);
    }

    public int len(ListNode head) {
        int len = 0;
        while(null != head) {
            len ++;
            head = head.next;
        }
        return len;
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode ret = new ListNode(-1);
        ListNode helper = ret;

        ListNode lh = left;
        ListNode rh = right;

        while(null != lh || null != rh) {
            if( null != lh && null != rh) {
                if(lh.val <= rh.val) {
                    ListNode lhNext = lh.next;
                    lh.next = helper.next;
                    helper.next = lh;
                    helper = helper.next;
                    lh = lhNext;
                }  else {
                    ListNode rhNext = rh.next;
                    rh.next = helper.next;
                    helper.next = rh;
                    helper = helper.next;
                    lh = rhNext;
                }
                continue;
            }
            else if( null == lh ) {
                helper.next = rh;
                break;
            } else {
                helper.next = lh;
                break;
            }
        }
        return ret.next;
    }*/
}
