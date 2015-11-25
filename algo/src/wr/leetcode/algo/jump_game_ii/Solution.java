package wr.leetcode.algo.jump_game_ii;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.jump(new int[] {2,3,1,1,4}));
    }


    public int jump(int[] nums) {

        if( null == nums){
            return 0;
        }

        int n = nums.length;
        int i = 0;
        int step = 0;
        int thisMax;
        int nextMax = 0;

        while( i <= nextMax ) {
            thisMax = nextMax;
            while(i <= thisMax) {
                if(n-1 == i) {
                    return step;
                } else {
                    nextMax = Math.max(i+nums[i], nextMax);
                }
                i++;
            }
            step++;
        }
        return step;
    }
}
