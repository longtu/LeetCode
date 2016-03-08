package wr.leetcode.algo.Facebook;

public class FindThief {
    public boolean findThief(int[] sequence, int n) {
        boolean ret = true;
        if ( n > 0 && sequence.length > 0) {
            for (int p = 0; p < n; ++p) {
                if (escape(p, 0, sequence, n)) {
                    ret = false;
                }
            }
        }
        return ret;
    }

    //DFS, 2^K
    public boolean escape (int pos, int t, int [] seq, int n) {
        boolean ret = false;
        int k = seq.length;

        if ( t == k ) {
            ret = true;
        } else {
            int guess = seq[t];
            if (pos != guess) {
                if (pos + 1 < n && escape(pos+1, t+1, seq, n)) {
                    ret = true;
                }
                if (!ret && pos-1 >=0 && escape(pos-1, t+1, seq, n)) {
                    ret = true;
                }
            }
        }
        return ret;
    }

    public boolean findThiefDP (int [] sequence, int n) {
        boolean ret = true;

        if (n > 0 && sequence.length > 0) {
            int k = sequence.length;
            boolean[][] dp = new boolean[k][n];
            for (int i = 0; i < k; ++i) {
                for (int j = 0; j < n; ++j) {
                    boolean val = sequence[i] != j;
                    if (i > 0) {
                        val = val && ((j-1 >=0 && dp[i-1][j-1])
                                || (j+1 <n && dp[i-1][j+1]));
                    }
                    dp[i][j] = val;
                }
            }
            for (int j = 0; j < n; ++j ) {
                if (dp[k-1][j]) {
                    ret = false;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindThief solution  = new FindThief();

        int[][][] tests = {
                {{1,1}, {3}},
                {{1,2,3}, {3}},
        };

        for (int[][] t : tests) {
            System.out.println(solution.findThiefDP(
                    t[0],
                    t[1][0]
            ));
        }
    }
}
