package wr.leetcode.algo.bitwise_and_of_numbers_range;

import java.util.Arrays;

public class Solution {


    public int rangeBitwiseAnd0(int m, int n) {
        int zeroMask = 0xffffffff;
        int ret = 0;

        for (int i = 0; i < Integer.SIZE; ++i) {
            int bitMask = (1 << i );
            int bitVal = bitMask & n;

            if( 0 != bitVal) {
                int prev = (n & (zeroMask<<i)) - 1;
                if(prev < m) {
                    ret |= bitMask;
                    break;
                }
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(5,7));
        System.out.println(sol.rangeBitwiseAnd(1,2));
        System.out.println(sol.rangeBitwiseAnd(2147483647,2147483647));
    }


    public int rangeBitwiseAnd(int m, int n) {

        int tailMask = 0xFFFFFFFE;
        int tailSet = 0x00000000;
        int ret = n;
        while(tailMask != 0x00000000) {
            int noTail = n & tailMask;
            int val = noTail | tailSet;
            if(val >=m) {
                ret = noTail & ret;
            } else {
                break;
            }
            tailMask = tailMask << 1;
            tailSet = (tailSet<<1) + 1;
        }
        return ret;
    }
}