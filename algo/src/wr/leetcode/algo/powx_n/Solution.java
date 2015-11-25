package wr.leetcode.algo.powx_n;

public class Solution {
    /*
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
    }*/

    public double myPow(double x, int n) {
        return myLongPow(x, n);
    }


    public double myLongPow(double x, long n) {
        double ret;
        if(0 == x || 1 == n) {
            ret = x;
        } else if (n < 0 ){
            ret = 1.0/myLongPow(x, 0 - n);
        } else if ( n == 0 ) {
            ret = 1;
        } else {
            long h = n/2;
            double hPow = myLongPow(x, h);
            ret = hPow * hPow * myLongPow(x, n - h*2);
        }
        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myPow(2,-2));
        System.out.println(sol.myPow(2, -1));
        System.out.println(sol.myPow(2, 0));
        System.out.println(sol.myPow(2, 1));
        System.out.println(sol.myPow(2, 2));
        System.out.println(sol.myPow(2, 3));
        System.out.println(sol.myPow(2,4));

    }




}
