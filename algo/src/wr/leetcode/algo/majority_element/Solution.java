package wr.leetcode.algo.majority_element;

public class Solution {



    public int majorityElement(int[] nums) {

        if(null == nums || nums.length == 0) {
            throw new IllegalArgumentException("InvalidInput");
        }

        int found = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            int v = nums[i];
            if( v == found) {
                count ++;
            } else if(count > 0) {
                count -- ;
            } else {
                found = v;
                count = 1;
            }
        }
        return found;
    }
}
