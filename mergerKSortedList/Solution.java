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
	    class HeapKey{
	        int listIndex;
	        ListNode node;
	        HeapKey(int listIndex, ListNode node){
	        	this.listIndex = listIndex;
	        	this.node = node;
	        }
	    }

	    public ListNode mergeKLists(ArrayList<ListNode> lists) {
	    	ListNode helper = new ListNode(-1);
	    	ListNode prev = helper;
	    	if(lists == null || lists.size() == 0)
	    	    return helper.next;

            //missing null check here:
	    	PriorityQueue<HeapKey> heap = new PriorityQueue<HeapKey>(lists.size(), new Comparator<HeapKey>(){
	    		@Override
	    		public int compare(HeapKey arg0, HeapKey arg1) {
	    			HeapKey src = (HeapKey) arg0;
	    			HeapKey dest = (HeapKey) arg1;
	    			return src.node.val - dest.node.val;
	    		}
	    	});
	    	//initialize
	    	for(int i = 0; i<lists.size(); ++i){
	    		if(lists.get(i) != null)
	    			heap.add(new HeapKey(i,lists.get(i)));
	    	}
	        while(!heap.isEmpty()){
	        	HeapKey min = heap.poll();
	        	prev.next = min.node;
	        	prev = prev.next;
	        	lists.add(min.listIndex,prev.next);
	        	if(prev.next != null){
	        		heap.add(new HeapKey(min.listIndex,prev.next));
	        	}
	        	prev.next = null;
	        }
	        return helper.next;
	    }
}
