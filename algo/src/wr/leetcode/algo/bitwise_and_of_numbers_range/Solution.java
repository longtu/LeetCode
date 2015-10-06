package wr.leetcode.algo.bitwise_and_of_numbers_range;

public class Solution {
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

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(5,7));
        System.out.println(sol.rangeBitwiseAnd(1,2));
    }
}