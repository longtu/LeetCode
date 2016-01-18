package wr.leetcode.algo.power_of_three;

public class Solution {
    //Recursive:
    public boolean isPowerOfThree(int n) {
        boolean ret = false;
        if( 1 == n) {
            ret = true;
        } else if (n > 0 && 0 == n%3) {
            ret = isPowerOfThree(n/3);
        }
        return ret;
    }

    //Math Trick
    public boolean isPowerOfThree0(int n) {
        return n >0 && (n == Math.pow(3, Math.round(Math.log(n)/Math.log(3))));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

    }

}
