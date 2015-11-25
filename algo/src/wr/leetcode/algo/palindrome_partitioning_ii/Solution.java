package wr.leetcode.algo.palindrome_partitioning_ii;

public class Solution {

    public String notNull(String s) {
        return (null == s)?(""):(s);
    }

    public int minCut(String s) {

        s = notNull(s);
        boolean[][] table = buildTable(s);
        int n = s.length();

        int[] minCut = new int[n + 1];
        //GOOD: go from backwards to facilitate buildTable calculation
        for (int i = n-1; i >= 0; --i) {
            int min = Integer.MAX_VALUE;
            for (int l = 1; i+l <= n; ++l) {
                if(table[l][i]) {
                    //Good: watch out for single character cut
                    min = Math.min(min, minCut[i+l] + ((i+l== n)?(0):(1)));
                }
            }
            minCut[i] = min;
        }

        return minCut[0];
    }


    public boolean [][] buildTable( String s) {
        int n = s.length();
        boolean [][] table = new boolean[n+1][n+1];

        //using length
        for (int l = 0; l <= n; ++l){
            for (int i = 0; i + l <= n; ++i) {
                boolean val;
                if(l <= 1) {
                    val = true;
                } else {
                    val =  table[l-2][i+1] && (s.charAt(i) == s.charAt(i+l-1));
                }
                table[l][i] = val;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String [] strs = { null, "", "a", "ab", "aab"};
        for (String str : strs) {
            System.out.println(sol.minCut(str));
        }
    }
}
