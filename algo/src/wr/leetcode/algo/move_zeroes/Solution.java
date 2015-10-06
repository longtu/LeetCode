package wr.leetcode.algo.move_zeroes;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums) {
            nums = new int[0];
        }
        int head = 0;
        int tail = 0;
        while( head < nums.length ) {
            if( nums[head] != 0) {
                nums[tail++] = nums[head];
            }
            head++;
        }
        while(tail < nums.length) {
            nums[tail++] = 0;
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        int [] nums = {0,1,0,3,12};
        sol.moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
