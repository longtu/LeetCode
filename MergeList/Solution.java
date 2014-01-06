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

    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        int flag = 1;
        boolean hasCycle = false;
        while(fastNode != null){
            fastNode = fastNode.next;
            flag ^= 1;
            if(flag == 1)
                slowNode = slowNode.next;
            if(fastNode == slowNode){
                hasCycle = true;
                break;    
            }
        }
        if(!hasCycle)
            return null;
        
        fast = head;
        while(fastNode != slowNode){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

    }
}
