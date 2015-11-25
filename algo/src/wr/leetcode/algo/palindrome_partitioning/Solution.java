package wr.leetcode.algo.palindrome_partitioning;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ret = new LinkedList<>();
        if( null != s && !s.isEmpty()) {
            boolean[][] table = table(s);
            ret = partitionRec(s, table, 0);
        }
        return ret;
    }

    public List<List<String>> partitionRec(String s, boolean[][] table, int k) {
        List<List<String>> ret =  new LinkedList<>();
        int n = s.length();
        if( k == n ) {
            ret.add(new LinkedList<>());
        } else {
            for (int l = 1; k+l <= n; ++l) {
                if( table[l][k]){
                    List<List<String>> subs = partitionRec(s, table, k+l);
                    for (List<String> sub : subs) {
                        List<String> r = new LinkedList<>(sub);
                        r.add(0, s.substring(k, k+l));
                        ret.add(r);
                    }
                }
            }
        }
        return ret;
    }

    public boolean [][] table (String s ) {
        int n = s.length();
        boolean [][] table = new boolean [n+1][n+1];
        //BUG:Recursive loop is wrong OMG
        // CANNOT USE i/j where i/j are row/column has to be length!!!
        for (int l = 0; l <= n; ++l) {
            for (int i = 0; i + l <= n; ++i) {
                boolean val = false;
                if( 0 == l || 1 == l) {
                    val = true;
                } else {
                    val = (s.charAt(i) == s.charAt(i+l-1) &&
                        table[l-2][i+1]);
                }
                table[l][i] = val;
            }
        }
        return table;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab"));
    }
        /*
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList();
        if(null == s || s.length() == 0) {
            return ret;
        }
        boolean[][] conn = getConn(s);
        return partition(s, 0, conn);
    }

    public List<List<String>> partition(String s, int start, boolean[][] conn) {
        List<List<String>> sols = new LinkedList();
        if(start == s.length()){
            sols.add(new LinkedList());
        } else {
            for (int l = 1; start+l-1 < s.length(); ++l) {
                if(!conn[l][start] ){
                    continue;
                }
                List<List<String>> subs = partition(s, start + l, conn);
                for (List<String> sub : subs){
                    List<String> sol = new LinkedList(sub);
                    sol.add(0, s.substring(start, start + l ));
                    sols.add(sol);
                }
            }
        }
        return sols;
    }

    public boolean[][] getConn(String s) {
        int len = s.length();
        boolean[][] conn = new boolean[len+1][len+1];

        for (int l = 0; l <= len; ++l){
            for (int start = 0; start + l <= len; ++start) {
                if(1 == l || 0 == l) {
                    conn[l][start] = true;
                } else {
                    conn[l][start] = conn[l-2][start+1] && (s.charAt(start) == s.charAt(start+l-1));
                }
            }
        }
        return conn;
    }*/
}
