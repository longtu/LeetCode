package wr.leetcode.algo.flip_game_ii;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> generatePossibleNextMoves(String s, Map<String, List<String>> map) {

        if(map.containsKey(s)) {
            return map.get(s);
        }

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
        map.put(s, ret);

        return ret;
    }


    //BUG: Method1 no caching TLE
    public boolean canWin(String s) {

        Map<String, Boolean> res = new HashMap<>();
        Map<String, List<String>> moves = new HashMap<>();
        return canWin(s, res, moves);
    }


    public boolean canWin(String s, Map<String, Boolean> map, Map<String, List<String>> nexts) {

        Boolean ret = false;
        if(map.containsKey(s)){
            ret = map.get(s);
        } else {
            List<String> nextMoves = generatePossibleNextMoves(s, nexts);
            for (String move : nextMoves) {
                if(!canWin(move, map, nexts)){
                    ret = true;
                }
            }
            map.put(s,ret);
            return ret;
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canWin("++++"));
        System.out.println(sol.canWin("+++++++++++++++++++++"));
    }
}
