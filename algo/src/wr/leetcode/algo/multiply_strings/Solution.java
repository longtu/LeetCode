package wr.leetcode.algo.multiply_strings;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String notEmpty(String str) {
        return (null == str || str.isEmpty())?("0"):(str);
    }

    public String removePrefixZeros(String str) {
        int i = 0;
        int n = str.length();
        for (i = 0; i < n; ++i ){
            if('0' != str.charAt(i)) {
                break;
            }
        }
        return (i == n)?("0"):(str.substring(i));

    }

    public String multiply(String num1, String num2) {

        num1 = notEmpty(num1);
        num2 = notEmpty(num2);

        int n = num2.length();

        String ret = "0";
        for (int i = 0; i < n; ++i) {
            int b = num2.charAt(i) - '0';
            String r = multiply(num1, b, n-i-1);
            ret = merge(ret, r);
        }
        return removePrefixZeros(ret);
    }

    public String multiply(String num1, int b, int zeros) {
        List<Integer> digits = new LinkedList<>();
        int n = num1.length();
        int carry = 0;
        int i = n-1;
        while( i >= 0 || carry > 0) {
            int val = carry;
            if( i >= 0) {
                val += (num1.charAt(i--) - '0') * b;
            }
            carry = val / 10;
            val %= 10;
            digits.add(0, val);
        }
        if(!digits.isEmpty()) {
            for (int k = 0; k < zeros; ++k) {
                digits.add(0);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            sb.append(d);
        }
        return sb.toString();
    }

    public String merge(String num1, String num2) {

        List<Integer> digits = new LinkedList<>();

        int i = num1.length() - 1, j = num2.length()-1;
        int carry = 0;
        //BUG: carry > 0 instead of >= 0
        while( i >= 0 || j >=0  || carry > 0) {

            int val = carry;
            if(i >= 0) {
                val += num1.charAt(i) - '0';
                i--;
            }
            if(j >= 0) {
                val += num2.charAt(j) - '0';
                j--;
            }
            carry = val/10;
            val %= 10;
            digits.add(0, val);
        }

        StringBuilder sb = new StringBuilder();
        for (int d : digits) {
            sb.append(d);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("1234567", "4321"));
        System.out.println(sol.multiply("12345670", "004321"));
        System.out.println(sol.multiply(null, ""));
        System.out.println(sol.multiply(null, "1"));
    }
}
