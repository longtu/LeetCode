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
    //K sorted lists
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
        //merge two sorted Array
        public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
            int i = m;
            int j = n;
            while(i >=1 && j>=1){
                if(A[i-1] > B[j-1]) {
                    A[i+j-1] = A[i-1];
                    i--;
                }
                else {
                    A[i+j-1] = B[j-1];
                    j--;
                }
            }
            while(j >=1 ){
                A[i+j-1] = B[j-1];
                j--;
            }

        }
        //merge two sorted Lists
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
            ListNode helper  = new ListNode(-1);
            ListNode prev = helper;

            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    prev.next = l1;
                    l1 = l1.next;
                }else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
                prev.next = null;
            }
            if(l1 != null) {
                prev.next = l1;
            }else {
                prev.next = l2;
            }
            return helper.next;
        }
}
