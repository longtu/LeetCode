package wr.leetcode.algo.sqrtx;

import sun.plugin.dom.exception.InvalidStateException;

public class Solution {
    /*public long mySqrt(long x) {
        long start = 0;
        long end = x;
        long ret = x;
        while(x > 1 && start <= end) {
            long mid = start +((end-start)>>1);
            long right = (mid+1)*(mid+1);
            if(mid*mid <= x && right >x){
                ret = mid;
                break;
            } else if(mid*mid > x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }

    public int mySqrt(int x) {
        if(x < 0) {
            throw new RuntimeException("Invalid Input");
        }
        return (int ) mySqrt((long)x);
    }
    */

    public int mySqrt(int x) {
        return (int)mySqrtLong(x);
    }

    public long mySqrtLong(long x) {
        if (x < 0 ) {
            throw new IllegalStateException("Invalid Input!");
        }
        long ret = -1;
        if( x <= 1) {
            ret = x;
        } else { // x > 1
            long start = 1;
            long end = x;
            while( start <= end) {
                long mid = start + ((end - start) >> 1);
                long mv = mid * mid;
                long ev = (mid + 1) * (mid + 1);

                if (ev <= x) {
                    start = mid + 1;
                } else if (x < mv) {
                    end = mid - 1;
                } else {
                    ret = mid;
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for(int i = 0; i < 101; ++i) {
            System.out.println(i+ ":" + sol.mySqrt(i));
        }
    }


}