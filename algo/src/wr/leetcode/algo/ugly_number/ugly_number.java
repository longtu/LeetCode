package wr.leetcode.algo.ugly_number;

public class ugly_number {
    public boolean isUgly(int num) {
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
