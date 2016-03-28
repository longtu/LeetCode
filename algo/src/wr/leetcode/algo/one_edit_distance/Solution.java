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
        if(s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }

        int m = s.length();
        int n = t.length();//m >= n

        if ( n - m > 1){
            return false;
        }

        // n == m +1 or n == m
        int i = 0, j = 0;
        while( i< m && (s.charAt(i) == t.charAt(j)) ) {
            i++;
            j++;
        }

        if(i == n) {
            return !(m == n);
        }
        //must be at least one difference smaller than n
        if(m == n) {
            i++; j++;
        } else {
            j++;
        }
        while (i<m && s.charAt(i) == t.charAt(j)) {
            i++; j++;
        }
        return (i == m);
    }

    private String notNull(String str) {
        return (null == str)?(""):(str);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isOneEditDistance("s", "t"));
        System.out.println(sol.isOneEditDistance("s", "tt"));
        System.out.println(sol.isOneEditDistance("ss", "sstt"));
        System.out.println(sol.isOneEditDistance("ss", "st"));
    }

}
