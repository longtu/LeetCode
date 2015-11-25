package wr.leetcode.algo.distinct_subsequences;

public class Solution {

    public String notNull(String s ) {
        return (null == s) ? (""):(s);
    }


    public int numDistinct(String s, String t) {
        s = notNull(s);
        t = notNull(t);

        int m = s.length();
        int n = t.length();

        int ret = 0;
        if(m != 0 || n != 0) {
            int[][] glo = new int[m + 1][n + 1];
            int[][] loc = new int[m + 1][n + 1];

            for (int i = 0; i <= m; ++i) {
                for (int j = 0; j <= n; ++j) {
                    int val = 0;
                    if (0 == i && 0 == j) {
                        val = 1;
                    } else if (i > 0 && j > 0 && (s.charAt(i - 1) == t.charAt(j - 1))) {
                        val = glo[i - 1][j - 1];
                    }
                    loc[i][j] = val;
                    //glo[i][j] = loc[i][j] + glo[i-1][j] BUG: i-1 out of boundary
                    glo[i][j] = loc[i][j] + ((i > 0) ? (glo[i - 1][j]) : (0));
                }
            }
            ret = glo[m][n];
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDistinct("",""));
        System.out.println(sol.numDistinct("rabbbit","rabbit"));
    }
}
