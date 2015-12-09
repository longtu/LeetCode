package wr.leetcode.algo.flip_game;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new LinkedList<>();
        if( null == s ) {
            s = "";
        }
        int n = s.length();
        for (int i = 1; i < n; ++i) {
            if( s.charAt(i) == '+' && s.charAt(i-1) == '+' ) {
                ret.add(s.substring(0, i-1) + "--" + s.substring(i+1, n));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generatePossibleNextMoves("++++"));
    }
}