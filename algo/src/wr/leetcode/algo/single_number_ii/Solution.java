package wr.leetcode.algo.single_number_ii;

public class Solution {

    //Solution 1: Using bit map and the property of appears exactly three times
    // easy to generalize
    public int singleNumber(int[] nums) {

        int [] bits = new int[32];
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 32; ++j) {
                int val =  (nums[i]>>j) & 1;
                bits[j] = (bits[j] + val)%3;
            }
        }

        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            ret = ret | (bits[i]<<i);
        }
        return ret;
    }






    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.singleNumber(new int[]{3,3,1,3,2,2,2}));
    }
}
