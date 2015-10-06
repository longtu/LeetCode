package wr.leetcode.algo.contains_duplicate_iii;

import java.util.PriorityQueue;

public class Solution {
    /* This needs a redo!!! problem solving is wrong!!! */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean ret = false;
        k = Math.abs(k);

        if(null != nums && k != 0 && t >= 0) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->(a-b));
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

            for(int i = 0; i < nums.length; ++i) {
                int val = nums[i];

                if(!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                    int min = minHeap.peek();
                    int max = maxHeap.peek();
                    if (((long)val - (long)min) * ((long)val - (long)max) <= 0 ) {
                        System.out.println(val);
                        System.out.println(i);
                        System.out.println(minHeap);
                        System.out.println(maxHeap);
                        ret = true;
                        break;
                    }
                }
                if( i >= k){
                    minHeap.remove(nums[i-k] - t);
                    maxHeap.remove(nums[i-k] + t);
                }
                minHeap.add(val-t);
                maxHeap.add(val+t);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {0,10,22,15,0,5,22,12,1,5};
        System.out.println(sol.containsNearbyAlmostDuplicate(arr, 3, 3));
    }
}
