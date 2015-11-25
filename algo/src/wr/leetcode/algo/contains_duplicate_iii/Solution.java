package wr.leetcode.algo.contains_duplicate_iii;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    /* This needs a redo!!! problem solving is wrong!!! */
    /*
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
    */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean ret = false;
        if( null != nums && nums.length >= 2 && t >= 0 && k > 0) {
            TreeSet<Integer> map = new TreeSet<>();
            for ( int i = 0; i < nums.length; ++i) {
                if( i > k ) {
                    map.remove( nums[i-k-1] );
                }
                Integer val = (nums[i]);
                Integer floor = map.floor(val);
                if(null != floor && (long)val- (long)floor <=t) {
                    ret = true;
                    break;
                }
                Integer ceiling = map.ceiling(val);
                /*BUG: Integer Overflow*/
                if(null != ceiling && (long)ceiling - (long)val <= t) {
                    ret = true;
                    break;
                }
                map.add(val);
                /*BUG: if the size is 1, first/last is the same element!!!
                 *SHOULD NOT COMPARE THE RANGE but specific
                if( (map.size() > 1) && (map.last() - map.first() <= t)) {
                    ret = true;
                    break;
                }
                */
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,3,1};
        System.out.println(sol.containsNearbyAlmostDuplicate(arr, 1,1));
    }
}
