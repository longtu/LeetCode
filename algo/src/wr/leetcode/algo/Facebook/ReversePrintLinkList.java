package wr.leetcode.algo.Facebook;


import wr.leetcode.algo.ListNode;

public class ReversePrintLinkList {

    public static void printNode ( ListNode head ) {
        printNodeRec(head);
        System.out.println();
    }

    public static void printNodeRec ( ListNode head ) {

        if ( null == head ) {
            return;
        }
        printNodeRec(head.next);
        System.out.print(head.val + ",");
    }

    public static void main(String[] args) {
        ListNode t1 = null;
        ListNode t2 = new ListNode(2);

        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
        ListNode t6 = new ListNode(6);
        t3.next = t4;
        t4.next = t5;
        t5.next = t6;

        printNode(t1);
        printNode(t2);
        printNode(t3);

    }

}
