package wr.leetcode.algo.scramble_string;

public class Solution {

    public String notNull(String str) {
        return (null == str)?(""):(str);
    }

    public boolean isScramble(String s1, String s2) {
        s1 = notNull(s1);
        s2 = notNull(s2);

        boolean ret = false;
        if(s1.length() == s2.length()) {
            ret = isScrambleDP(s1, s2);
        }
        return ret;
    }

    public boolean isScrambleDP(String s1, String s2) {
        int n = s1.length();
        boolean dp[][][] = new boolean[n+1][n][n];//BUG: n+1 for outter

        for (int l = 1; l <=n; ++l) {
            for (int i = 0; i+l <= n; ++i ) {
                for (int j = 0; j+l <= n; ++j) {
                    boolean val = s1.substring(i, i+l)
                                    .equals(s2.substring(j,j+l));
                    if(1 == l) {
                        val = val || (s1.charAt(i) == s2.charAt(j));
                    } else {
                        for (int k = 1; k < l; ++k) {
                            val = val
                                || (dp[k][i][j] && dp[l-k][i+k][j+k])
                                || (dp[k][i][j+l-k] && dp[l-k][i+k][j]);
                            if(val) {
                                break;
                            }
                        }
                    }
                    dp[l][i][j] = val;
                }
            }
        }

        return dp[n][0][0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isScramble("great", "rgtae"));
    }

}