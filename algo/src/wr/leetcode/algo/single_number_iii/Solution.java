package wr.leetcode.algo.single_number_iii;

import java.util.Arrays;

//TODO: TAKE ONE STEP FURTHER OVER GENERAL PROPERTY
public class Solution {
    public int[] singleNumber(int[] nums) {
        if(null == nums || nums.length < 2) {
            throw new IllegalArgumentException("Input is invalid!");
        }

        int diff = 0;
        for (int i : nums) {
            diff = diff ^ i;
        }

        int mask = 1;
        while((mask & diff) == 0) {
            mask = mask << 1;
        }

        int left = 0; int right = 0;
        for (int i : nums){
            if( (i & mask) == 0) {
                left = (left ^ i);
            } else {
                right = (right ^ i);
            }
        }
        int[] ret = new int[2];
        ret[0] = left;
        ret[1] = right;

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] n = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(sol.singleNumber(n)));
    }
}
