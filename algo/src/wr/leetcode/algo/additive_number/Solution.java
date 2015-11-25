package wr.leetcode.algo.additive_number;

import java.util.LinkedList;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        boolean ret = false;
        //BUG: check for and instead of || !!!!
        if( null != num && num.length() > 2 ) {
            int n = num.length();
            for (int i = 1; i < n && !ret; ++i){
                for (int j = i + 1; j < n && !ret; ++j) {
                    String left = num.substring(0, i);
                    String right = num.substring(i, j);
                    if(isInvalid(left) || isInvalid(right)) {
                        continue;
                    }
                    if(probe(right, sum(left, right), num.substring(j))) {
                        ret = true;
                    }
                }
            }
        }
        return ret;
    }

    public boolean probe(String prev, String prefix, String subString ) {
        boolean ret = false;
        if(subString.equals(prefix)) {
            ret = true;
        } else if(subString.startsWith(prefix)){
            int n = prefix.length();
            String next = sum(prev, prefix);
            ret = probe(prefix, next, subString.substring(n));
        }
        return ret;
    }

    public boolean isInvalid(String str) {
        return str.startsWith("0") && !str.equals("0");
    }

    public String sum( String left, String right) {

        int m = left.length();
        int n = right.length();

        LinkedList<Integer> sum = new LinkedList<>();
        int carry = 0;
        while(m > 0 || n > 0 || carry > 0) {
            if( m > 0 ) {
                carry += left.charAt(m-1) - '0';
                m--;
            }
            if( n > 0 ) {
                carry += right.charAt(n-1) - '0';
                n--;
            }
            sum.add(0, carry%10);
            carry /= 10;
        }
        StringBuilder sb = new StringBuilder();
        while(!sum.isEmpty()) {
            sb.append(sum.removeFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isAdditiveNumber("112358"));
        System.out.println(sol.isAdditiveNumber("199100199"));
        System.out.println(sol.isAdditiveNumber("1023"));
        System.out.println(sol.isAdditiveNumber(""));
        System.out.println(sol.isAdditiveNumber(null));
        System.out.println(sol.isAdditiveNumber("1"));
        System.out.println(sol.isAdditiveNumber("11"));
        System.out.println(sol.isAdditiveNumber("112"));

    }

}
