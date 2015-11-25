package wr.leetcode.algo.jump_game;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean canJump(int[] nums) {
        boolean ret = false;
        if(null == nums || 0 == nums.length) {
            return ret;
        }

        int i = 0;
        int max = 0;
        while(i <= max) {
            int step = 0;
            if(i < nums.length) {
                step = nums[i];
            }
            max = Math.max(max, i + step);
            if(max >= nums.length - 1) {
                ret = true;
            }
            i++;
        }
        return ret;
    }
}
