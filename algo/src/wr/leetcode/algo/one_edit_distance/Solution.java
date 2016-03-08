package wr.leetcode.algo.one_edit_distance;

public class Solution {

    //Method2: Optimized for single difference
    public boolean isOneEditDistance0(String s, String t) {
        if( null == s ) {
            s = "";
        }
        if( null == t ) {
            t = "";
        }
        if(s.length() < t.length()) {
            return isOneEditDistance0(t, s);
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

    public boolean isOneEditDistance(String s, String t) {
        s = notNull(s);
        t = notNull(t);

        int m = s.length();
        int n = t.length();

        if (m < n) {
            return isOneEditDistance(t,s);
        }
        // m >= n
        if (m - n > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        boolean ret;
        if (m == n) {
            while(i<m && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            if(i != m){
                i++;
                j++;
                while(i<m && s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                }
                ret = (i == m);
            } else {
                ret = false;
            }
        } else { //m == n + 1
            while(i <n && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            if(i == n){
                ret = true;
            } else {
                i++;
                while(i<m && s.charAt(i) == t.charAt(j)) {
                    i++;
                    j++;
                }
                ret = (i == m);
            }
        }
        return ret;
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
