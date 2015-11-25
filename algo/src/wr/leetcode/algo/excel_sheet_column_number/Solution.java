package wr.leetcode.algo.excel_sheet_column_number;

public class Solution {

    public int titleToNumber(String s) {
        int ret = 0;
        s = s.trim();
        if( null != s && !s.isEmpty() ) {
            int n = s.length();
            for ( int i = 0; i < n; ++i ) {
                ret *= 26;
                int val = (s.charAt(i) - 'A' + 1);
                ret += val;
            }
        }
        return ret;
    }



    /*
    public int titleToNumber(String s) {

        if(null == s) {
        	return 0;
        }
        s = s.trim();

        int ret = 0;
        for (char ch : s.toCharArray() ) {
        	ret *= 26;
        	ret += (ch - 'A' + 1);
        }

        return ret;
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.titleToNumber(""));
        System.out.println(sol.titleToNumber("  A"));
        System.out.println(sol.titleToNumber("B"));
        System.out.println(sol.titleToNumber(" AA"));
        System.out.println(sol.titleToNumber("AB"));

    }
}