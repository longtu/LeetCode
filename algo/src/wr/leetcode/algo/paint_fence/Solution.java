package wr.leetcode.algo.paint_fence;

public class Solution {
    public int numWays0(int n, int k) {
        int ways = 0;

        if( n > 0 && k > 0) {
            if( n == 1) {
                ways = k;
            } else if (n == 2) {
                //BUG: MemoryLE for n = 2 k = 46340
                ways = k*k;
            } else { // n >= 2
                int[][][] dp = new int[2][k][k];
                int[][] sum = new int[2][k];
                for (int i = 2; i <=n; ++i) {
                    for(int x = 0; x < k; ++x) {
                        sum[i%2][x] = 0;
                    }
                    for (int x = 0; x < k; ++x){
                        for (int y = 0; y < k; ++y) {
                            int val;
                            if( 2 == i) {
                                val = 1;
                            } else {
                                //BUG: TLE: optimization using sum to save a K loop
                                val = sum[(i-1)%2][y];
                                if( x==y ) {
                                    val -= dp[(i-1)%2][y][y];
                                }
                            }
                            dp[i%2][x][y] = val;
                            sum[i%2][x] += val;
                        }
                    }
                }

                for (int x = 0; x < k; ++x) {
                    for (int y = 0; y < k; ++y) {
                        ways += dp[n%2][x][y];
                    }
                }
            }
        }
        return ways;
    }


    public int numWays(int n, int k) {
        int ret = 0;
        int [] dp = new int[n+1];

        for (int i = 1; i <= n; ++i ) {
            int val;
            if ( 1 == i) {
                val = 1;
            } else if ( 2 == i) {
                val = k;
            } else {
                val = (k-1) * (dp[n-1] + dp[n-2]);
            }
            dp[i] = val;
        }
        ret = dp[n] * k;
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numWays(3, 3));
        System.out.println(sol.numWays(2, 2));
        System.out.println(sol.numWays(2, 3));
        System.out.println(sol.numWays(2, 4));
        System.out.println(sol.numWays(2, 46340));
        System.out.println(sol.numWays(3, 1290));
        //2147395600
        //2146687710

        System.out.println(sol.numWays(4, 2));
        System.out.println(sol.numWays(2, 1));

    }
}
