package wr.leetcode.algo.contains_duplicate_ii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //edge case of K == 0
    //edge case of duplicates happens within first K

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean ret = false;
        k = Math.abs(k);

        if( null != nums ) {
            Set<Integer> dict = new HashSet<>();
            for( int i = 0; i < nums.length; ++i) {
                int val = nums[i];
                if(dict.contains(val)) {
                    ret = true;
                    break;
                }
                if(i >= k) {
                    dict.remove(nums[i-k]);
                }
                dict.add(val);
            }
        }
        return ret;
    }
}
