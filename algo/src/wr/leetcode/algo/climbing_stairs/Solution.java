package wr.leetcode.algo.climbing_stairs;

public class Solution {
    public int climbStairs(int n) {
        int ret = 0;
        if(n >= 0) {
            int[] number = new int [4];
            for (int i = 0; i < n+1; ++i) {
                if (i < 2) {
                    number[i%4] = 1;
                } else {
                    number[i%4] = number[(i-1)%4] + number[(i-2)%4];
                }
            }
            ret = number[n%4];
        }
        return ret;
    }
}
