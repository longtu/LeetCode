package wr.leetcode.algo.power_of_two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean ret = false;
        if(n > 0) {
            ret = (n & (n-1)) == 0;
        }
        return ret;
    }
}
