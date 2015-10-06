package wr.leetcode.algo.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean ret = false;
        if(null != nums ) {
            Set<Integer> dict = new HashSet<Integer>();
            for(int val : nums) {
                if(dict.contains(val)) {
                    ret = true;
                    break;
                }
                dict.add(val);
            }
        }
        return ret;
    }
}
