package wr.leetcode.algo.one_edit_distance;

public class Solution {

    //Method2: Optimized for single difference
    public boolean isOneEditDistance(String s, String t) {
        if( null == s ) {
            s = "";
        }
        if( null == t ) {
            t = "";
        }
        if(s.length() < t.length()) {
            return isOneEditDistance(t, s);
        }

        int m = s.length();
        int n = t.length();//m >= n

        if (m - n > 1){
            return false;
        }

        // m == n + 1 or m == n
        int i = 0;
        while( i< n && (s.charAt(i) == t.charAt(i)) ) {
            i++;
        }

        if(i == n) {
            return !(m == n);
        }
        //must be at least one difference smaller than n
        int j = 0;
        while( m-1-j >=0 && n-1-j >=0 && s.charAt(m-1-j) == t.charAt(n-1-j)) {
            j++;
        }
        return (i == m-1-j);
    }





    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isOneEditDistance("s", "t"));
        System.out.println(sol.isOneEditDistance("s", "tt"));
        System.out.println(sol.isOneEditDistance("ss", "sstt"));
        System.out.println(sol.isOneEditDistance("ss", "st"));
    }

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


    //Method1: TLE, naive way, overkill and requires a lot of resource
    public boolean isOneEditDistance0(String s, String t) {
        return 1 == editDistance(s,t);
    }
}
