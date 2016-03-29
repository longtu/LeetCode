package wr.leetcode.algo.Facebook;

public class InsertSortedCircularList {
    ListNode insert(ListNode head, ListNode newNode) {
        if( null == head) {
            newNode.next = newNode;
            return newNode;
        } else {
            ListNode node = head;
            int key = newNode.value;
            if(key <= node.value) {
                newNode.next = node;
                ListNode tail = node;
                while( tail.next != head) {
                    tail = tail.next;
                }
                tail.next = newNode;
                return newNode;
            } else {
                while(node.next.value < key && node.next != head) {
                    node = node.next;
                }
                newNode.next = node.next;
                node.next = newNode;
                return head;
            }
        }
    }

}
