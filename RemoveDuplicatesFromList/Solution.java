/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    //delete duplicates only to make the list unique
    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode curr = helper;
        ListNode next = curr.next;
        while(next!=null){
            if(curr != helper && curr.val == next.val){
                curr.next = next.next;
                next = curr.next;
                continue;
            }
            curr = next;
            next = curr.next;
        }
        return helper.next;
    }

    //delete all entry has duplicates only leaving the unique ones
    public ListNode deleteDuplicates(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode prev = helper;
        ListNode curr = prev.next;

        while(curr != null ){
            ListNode next = curr.next;
            if(next == null || next.val != curr.val){
                prev = curr;
                curr = next;
                continue;
            }
            while(next != null && next.val == curr.val){
                next = next.next;
            }
            prev.next = next;
            curr = next;
        }
        return helper.next;
    }
}
