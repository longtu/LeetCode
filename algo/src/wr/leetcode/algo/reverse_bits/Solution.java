package wr.leetcode.algo.reverse_bits;

//reverse look up!!!!
public class Solution {

    /*
    public int reverseBits(int n) {

        int mask = 0x00000001;
        int ret = 0x00000000;

        while(mask != 0) {
            int bit = n & mask;
            if(bit != 0){
                ret |=  1;
            }
            mask = mask << 1;
            if(mask != 0) {
                ret = ret << 1;
            }
        }
        return ret;
    }*/

    public int reverseBits(int n) {
        int tmp = n;
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            ret <<= 1;
            int bit = tmp & 1;
            tmp >>>= 1;
            ret |= bit;
        }

        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseBits(43261596));
        System.out.println(sol.reverseBits(964176192));
    }
}
