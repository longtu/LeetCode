package wr.leetcode.algo.plus_one;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> ret = new ArrayList<>();
        if( null == digits ) {
            digits = new int[0];
        }
        int n = digits.length;
        int carry = 1;
        int val;
        int i = n - 1;
        while(i >=0 || carry > 0) {
            //BUG: RESET val = 0
            val = 0;
            if( i >= 0) {
                val += digits[i];
                i--;
            }
            val += carry;
            carry = val/10;
            val %= 10;
            ret.add(0, val);
        }
        int len = ret.size();
        int [] arr = new int[len];
        for (int k = 0; k < len; ++k) {
            arr[k] = ret.get(k);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.plusOne( null )));
        System.out.println(Arrays.toString(sol.plusOne(new int[]{} )));
        System.out.println(Arrays.toString(sol.plusOne(new int[]{ 9,9,9} )));
        System.out.println(Arrays.toString(sol.plusOne(new int[]{0} )));
        System.out.println(Arrays.toString(sol.plusOne(new int[]{1,2,3} )));

    }
}
