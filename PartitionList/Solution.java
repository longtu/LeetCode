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
    public ListNode partition(ListNode head, int x) {

        ListNode helperSmaller = new ListNode(-1);
        ListNode smallerPrev = helperSmaller;
        ListNode helperOld = new ListNode(-1);
        helperOld.next = head;
        ListNode prev = helperOld;
        ListNode curr = prev.next;
        for(;curr!=null;curr = prev.next){
            if(curr.val < x){
                prev.next = curr.next;
                curr.next = null;
                smallerPrev.next = curr;
                smallerPrev = smallerPrev.next;
                continue;
            }
            prev = prev.next;
        }

        if(smallerPrev != helperSmaller){
            smallerPrev.next = helperOld.next;
            return helperSmaller.next;
        }
        return helperOld.next;
        
    }
}
