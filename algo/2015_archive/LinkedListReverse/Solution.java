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
        //this value needs to be protected
        ListNode end =tail.next;
        ListNode curr = head;
        while(curr != end){
            ListNode tmp = curr.next;
            curr.next = ret;
            ret = curr;
            curr = tmp;
        }
        return ret;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode helper = new ListNode(-1);

        helper.next = head;
        ListNode prev, start, end;
        ListNode curr = helper;
        for(int i = 0; i <=n; ++i, curr = curr.next){
            if(curr == null)
                throw new RuntimeException("Invalid input");
            if(i == m -1){
                prev = curr;
            }
            if(i == m){
                start = curr;
            }
            if(i == n){
                end = curr;
            }
        }
        prev.next = reverseList(start, end);
        return helper.next;
    }
}
