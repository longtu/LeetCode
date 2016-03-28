package wr.leetcode.algo.multiply_strings;


public class Solution {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int [] res = new int[m+n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int k = i+j+1;
                res[k] += (num1.charAt(i) - '0') * (num2.charAt(j)- '0');
            }
        }
        int carry = 0;
        for (int k = m+n-1; k >=0; --k) {
            res[k] += carry;
            carry = res[k]/10;
            res[k] = res[k]%10;
        }
        int k = 0;
        while( k < m+n && res[k] ==0) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        while (k < m + n) {
            sb.append(res[k++]);
        }
        if(sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.multiply("1234567", "4321"));
        System.out.println(sol.multiply("12345670", "004321"));
        System.out.println(sol.multiply("", ""));
        System.out.println(sol.multiply("", "1"));
        System.out.println(sol.multiply("345", "678"));
    }
}
