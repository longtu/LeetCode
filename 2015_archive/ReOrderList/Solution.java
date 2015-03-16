/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    private int getSize(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head=head.next;
        }
        return len;
    }

    private ListNode reverseList(ListNode head){
        ListNode ret = new ListNode(-1);
        ListNode prev = ret.next;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null ){
            next = curr.next;
            curr.next = prev;
            ret.next = curr;
            curr = next;
            prev = ret.next;
        }
        return ret.next;
    }

    private void mergeList(ListNode left, ListNode right){
        ListNode ret = new ListNode(-1);
        while(left != null){
            ret.next = left;
            left = left.next;
            ret = ret.next;
            if(right != null){
                ret.next = right;
                right = right.next;
                ret = ret.next;
            }
        }
    }

    public void reorderList(ListNode head) {
        int size = getSize(head);
        if(size < 2)
            return;
        int halfSize = (size+1)/2;
        ListNode left = head;
        ListNode right = head;
        ListNode tmp = head;
        for (int i = 0; i< halfSize; ++i){
            if(i > 0)
                tmp = tmp.next;
            right = right.next;
        }
        tmp.next = null;
        right = reverseList(right);
        mergeList(left, right);
    }
}


