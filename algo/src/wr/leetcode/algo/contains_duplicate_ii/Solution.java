package wr.leetcode.algo.contains_duplicate_ii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /*
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
    }*/

    public boolean containsNearbyDuplicate0(int[] nums, int k) {

        Map<Integer, Integer> dic = new HashMap<>();
        if( null == nums ) {
            nums = new int[0];
        }
        boolean ret = false;
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            if (dic.containsKey(n)){
                int prev = dic.get(n);
                if( i-prev <= k) {
                    ret = true;
                }
            }
            dic.put(n, i);
        }
        return ret;
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if( null == nums ) {
            nums = new int[0];
        }
        Set<Integer> dic = new HashSet<>();
        boolean ret = false;
        for (int i = 0; i < nums.length; ++i) {
            int key = nums[i];
            if (dic.contains(key)) {
                ret = true;
                break;
            } else {
                dic.add(key);
            }
            if(dic.size() == k + 1) {
                dic.remove(nums[i-k]);
            }
        }
        return ret;
    }
}
