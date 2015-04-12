package wr.leetcode.algo.palindrome_partitioning;

import java.util.LinkedList;
import java.util.List;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab"));
    }
}
