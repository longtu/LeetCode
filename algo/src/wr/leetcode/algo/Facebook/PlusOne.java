package wr.leetcode.algo.Facebook;

public class PlusOne {
    //Plus one without add
    static int plusOne (int x) {
        int one = 1;
        int mask = 0xFFFFFFFF;

        while( (one & x) != 0 ) {
            mask <<= 1;
            one <<= 1;
            x &= mask;
        }

        return x|one;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 256; ++i) {
            System.out.println(plusOne(i));
        }
        System.out.println(plusOne(0xffffffff));
    }
}
