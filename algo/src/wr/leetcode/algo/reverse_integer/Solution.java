package wr.leetcode.algo.reverse_integer;


import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        long value = x;

        if( x < 0) {
            isNeg = true;
            value = value * -1;
        }
        Queue<Character> queue = new LinkedList<>();
        while ( value > 0){
            long digit = value % 10 ;
            queue.add((char) ('0' + digit));
            value = value / 10;
        }
        if(queue.isEmpty()){
            queue.add('0');
        }

        StringBuilder sb = new StringBuilder();
        if(isNeg) {
            sb.append("-");
        }
        while (!queue.isEmpty()) {
            sb.append(queue.remove());
        }

        Long longRet = Long.valueOf(sb.toString());
        int ret = 0;
        if(longRet <= Integer.MAX_VALUE && longRet >= Integer.MIN_VALUE) {
            ret = longRet.intValue();
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(123));
        System.out.println(sol.reverse(-123));
        System.out.println(sol.reverse(10));
        System.out.println(sol.reverse(100));
        System.out.println(sol.reverse(Integer.MIN_VALUE));
        System.out.println(sol.reverse(Integer.MAX_VALUE));
        System.out.println(sol.reverse(1000000003));
        System.out.println(sol.reverse(0));


    }
}
