package wr.leetcode.algo.number_of_1_bits;

public class Solution {
    /*
    public int hammingWeight(int n) {
        int sum = 0;
        for( int i = 0; i < 32; ++i) {
            sum += n & 1;
            n = n >>1;
        }
        return sum;
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();
        int tst = 0x80000000;
        System.out.println(sol.hammingWeight(tst));
    }

    public int hammingWeight(int n) {
        int ret = 0;
        while(n != 0) {
            ret += (n&1);
            n = n >> 1;
        }
        return ret;
    }
}