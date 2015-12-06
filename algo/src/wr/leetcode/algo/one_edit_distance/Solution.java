package wr.leetcode.algo.one_edit_distance;

public class Solution {
    public int editDistance( String s, String t) {
        if( null == s ) {
            s = "";
        }
        if( null == t ) {
            t = "";
        }

        int m = s.length();
        int n = t.length();

        int [][] dist = new int[m+1][n+1];

        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <=n; ++j) {
                int dst;
                if(0 == i && 0 == j) {
                    dst = 0;
                } else {
                    dst = Integer.MAX_VALUE;
                    if( i > 0) {
                        dst = Math.min(dst, dist[i-1][j] + 1);
                    }
                    if( j > 0) {
                        dst = Math.min(dst, dist[i][j-1] + 1);
                    }
                    if( i > 0 && j > 0) {
                        if( s.charAt(i-1) == t.charAt(j-1) ) {
                            dst = Math.min(dst, dist[i-1][j-1]);
                        } else {
                            dst = Math.min(dst, dist[i-1][j-1] + 1);
                        }
                    }
                }
                dist[i][j] = dst;
            }
        }

        return dist[m][n];
    }


    public boolean isOneEditDistance(String s, String t) {
        return 1 == editDistance(s,t);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isOneEditDistance("s", "t"));
        System.out.println(sol.isOneEditDistance("s", "tt"));
    }
}
