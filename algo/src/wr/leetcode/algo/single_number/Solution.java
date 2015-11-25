package wr.leetcode.algo.single_number;

public class Solution {
    public int singleNumber(int[] nums) {

        if( null == nums || 0 == nums.length ) {
            throw new IllegalArgumentException("Invalid Input!");
        } else {
            int ret = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                ret ^= nums[i];
            }
            return ret;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();


        System.out.println( sol.singleNumber( new int[] {1,2,3,4,5,4,3,2,1}));
    }
}
