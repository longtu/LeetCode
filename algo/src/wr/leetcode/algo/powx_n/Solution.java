package wr.leetcode.algo.powx_n;

public class Solution {
    public double pow(double x, int n) {
        return pow(x, new Long(n));
    }

    public double pow(double x, long n) {
        double ret;
        if( 0 == n) {
            ret = 1;
        } else if (n < 0) {
            ret = 1.0/pow(x, 0-n);
        } else {
            double half = pow(x, n/2);
            ret = half * half;
            if(n%2 == 1){
                ret *= x;
            }
        }
        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pow(2,-2));
        System.out.println(sol.pow(2,-1));
        System.out.println(sol.pow(2,0));
        System.out.println(sol.pow(2,1));
        System.out.println(sol.pow(2,2));
        System.out.println(sol.pow(2,3));
        System.out.println(sol.pow(2,4));

    }




}
