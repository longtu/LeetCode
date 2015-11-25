package wr.leetcode.algo.palindrome_number;

public class Solution {

    public boolean isPalindrome(int x) {
        long val = x;
        if(val < 0) {
            val *= -1;
        }
        return reverse(val) == val;
    }

    public long reverse(long x) {

        long ret = 0;
        while(x > 0) {
            ret *= 10;
            ret += x%10;
            x /= 10;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int t : new int[]
                {1, 0 , -1, 12345, Integer.MAX_VALUE, Integer.MIN_VALUE, 98789 }) {
            System.out.println(sol.isPalindrome(t));
        }
    }
}
