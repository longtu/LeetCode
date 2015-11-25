package wr.leetcode.algo.divide_two_integers;



public class Solution {

    public int divide(int up, int below) {

        long dividend = up;
        long divisor = below;

        boolean isNeg = (dividend < 0 && divisor > 0)
                            || (dividend > 0 && divisor <0);
        dividend = (dividend < 0) ? (0 - dividend) : (dividend);
        divisor = (divisor < 0) ? (0 - divisor) : (divisor);
        DivData ret = divideLong(dividend, divisor);

        if(isNeg) {
            ret.result = 0 - ret.result;
        }
        if(ret.result > Integer.MAX_VALUE || ret.result < Integer.MIN_VALUE) {
            ret.result = Integer.MAX_VALUE;
        }
        return (int) (ret.result);
    }

    public DivData divideLong(long dividend, long divisor) {
        if( 0 == divisor ) {
            throw new IllegalStateException("Invalid Input!");
        }
        DivData ret = new DivData();

        if( dividend < divisor) {
            ret.residu = dividend;
        } else if (dividend >= divisor && dividend < divisor + divisor ) {
            ret.result = 1;
            ret.residu = dividend - divisor;
        } else { // dividend > 2* divisor
            DivData parent = divideLong(dividend, divisor + divisor);
            DivData child = divideLong(parent.residu, divisor);
            ret.residu = child.residu;
            ret.result = parent.result + parent.result + child.result;
        }
        return ret;
    }


    class DivData {
        long result = 0;
        long residu = 0;
    }

    /*
    public long divide(long dividend, long divisor) {
        if(0 == divisor) {
            throw new IllegalArgumentException("Invalid Input");
        }
        if(dividend < 0 && divisor < 0 ) {
            return divide(0-dividend, 0-divisor);
        }
        if(dividend < 0) {
            return 0 - divide(0-dividend, divisor);
        }
        if(divisor < 0) {
            return 0 - divide(dividend, 0-divisor);
        }
        return dividePos(dividend, divisor).result;
    }

    public int divide(int dividend, int divisor) {
        long ret = divide((long)dividend, (long)divisor);

        if(ret > Integer.MAX_VALUE ||  ret < Integer.MIN_VALUE) {
            ret = Integer.MAX_VALUE;
        }
        return (int)ret;
    }

    public MetaData dividePos(long dividend, long divisor) {
        if (dividend < divisor) {
            return new MetaData(0, dividend);
        } else if (dividend < divisor + divisor ) {
            return new MetaData(1, dividend - divisor);
        } else {
            MetaData parent = dividePos(dividend, divisor + divisor);
            MetaData current = dividePos(parent.remain, divisor);
            return new MetaData(parent.result + parent.result + current.result,
                current.remain);
        }
    }

    class MetaData {
        long result;
        long remain;
        public MetaData(long result, long remain) {
            this.result = result;
            this.remain = remain;
        }
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.divide(100, 33));
    }
}
