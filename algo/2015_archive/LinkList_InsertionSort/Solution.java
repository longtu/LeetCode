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

    /*
     * Remove from prev
     * */
    private void removeNode (ListNode prev){
        ListNode nRemove = prev.next;
        if(nRemove == null)
            return;
        prev.next = nRemove.next;
    } 

    private void insertNode (ListNode prev, ListNode node){
        ListNode next = prev.next;
        prev.next = node;
        node.next = next;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(-1);
        helper.next = head;

        ListNode nextNode = null;
        ListNode node = head;
        ListNode nodePrev = helper;
        while(node != null){
            ListNode prev = helper;
            ListNode next = helper.next;
            while(next.val < node.val){
                prev = prev.next;
                next = next.next;
            }
            nextNode = node.next;

            //need to remove from prev
            nodePrev = helper;
            while(nodePrev.next != node)
                nodePrev = nodePrev.next;

            removeNode(nodePrev);
            insertNode(prev,node);
            node = nextNode;
        }
        return helper.next;
    }
}
