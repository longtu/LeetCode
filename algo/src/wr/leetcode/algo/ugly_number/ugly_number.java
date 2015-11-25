package wr.leetcode.algo.ugly_number;

import wr.leetcode.algo.Solution;

import java.util.Arrays;

public class ugly_number {


    public boolean isUgly(int num) {
        boolean ret = false;
        if( num > 0 ) {
            boolean[] ugly = new boolean [num+1];
            Arrays.fill(ugly, false);
            int[] factors = new int[] {2,3,5};
            for (int i = 1; i <= num; ++i) {
                if( 1 == i) {
                    ugly[i] = true;
                }
                if(ugly[i]) {
                    for ( int f : factors) {
                        int key = f * i;
                        if (key <= num) {
                            ugly[key] = true;
                        }
                    }
                }
            }
            ret = ugly[num];
        }
        return ret;
    }


    public static void main(String[] args) {
        ugly_number sol = new ugly_number();
        for (int i = 1; i < 1000; ++i) {
            if(sol.isUgly(i) != sol.isUgly0(i))
                System.out.println(i);
        }

    }

    public boolean isUgly0(int num) {
        if( num <= 0 ) {
            return false;
        }
        if( 1 == num) {
            return true;
        } else if ( num % 2 == 0) {
            return isUgly( num/2 );
        } else if (num % 3 == 0) {
            return isUgly( num/3);
        } else if (num % 5 == 0) {
            return isUgly( num/5);
        } else {
            return false;
        }
    }
}
