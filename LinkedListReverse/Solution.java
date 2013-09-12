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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || k<2)
            return head;
        
        ListNode end = head;
        for(int i = 1; i<k && end != null; ++i){
            end = end.next;
        }
        if(end == null)
            return head;
        else{
            end.next = reverseKGroup(end.next, k); 
            return reverseList(head, end);
        }
    }



    private ListNode reverseList(ListNode head, ListNode tail){
        ListNode ret = tail.next;
        List curr = head;
        while(curr != tail.next){
            ListNode tmp = curr.next;
            curr.next = ret;
            ret = curr;
            curr = tmp;
        }
        return ret;
    }
}
