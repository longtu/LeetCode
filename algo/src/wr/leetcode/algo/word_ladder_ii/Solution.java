package wr.leetcode.algo.word_ladder_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> findLadders(String start, String end,
         Set<String> dict) {
        List<List<String>> ret = new LinkedList();

        if( null == dict ) {
            return ret;
        }
        dict.add(start);
        dict.add(end);
        return shortest(findLadders(start, end, dict, new LinkedList()));
    }

    public List<List<String>> shortest (List<List<String>> sols) {

        if(sols.isEmpty()) {
            return sols;
        }
        int min = Collections.min(sols, (a, b)->(a.size() - b.size())).size();
        return sols.stream().filter(a->(a.size() == min)).collect(Collectors.toList());
    }

    public List<List<String>> findLadders(String current, String end,
     Set<String> dict, List<String> prefix) {

        List<List<String>> ret = new LinkedList();
        // current not part of dictionary
        if (!dict.contains(current)) {
            return ret;
        }

        if(current.equals(end)) {
            List<String> sol = new LinkedList(prefix);
            sol.add(end);
            ret.add(sol);
            return ret;
        }

        //contains current
        dict.remove(current);
        prefix.add(current);

        Set<String> copy = new HashSet(dict);

        for (String next : copy) {
            if(isLadder(current, next)) {
                List<List<String>> subs = findLadders(next, end, dict, prefix);
                for (List<String> sub : subs) {
                    ret.add(sub);
                }
            }
        }
        prefix.remove(prefix.size()-1);
        dict.add(current);
        return ret;
    }

    public boolean isLadder(String src, String dest) {
        int diff = 0;
        for(int i = 0; i < src.length(); ++i) {
            if (src.charAt(i) != dest.charAt(i)) {
                diff += 1;
            }
        }
        return diff == 1;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        String [] arr = {"hot","dot","dog","lot","log"};
        Set<String> dict= Arrays.stream(arr).collect(Collectors.toSet());
        System.out.println(sol.findLadders("hit", "cog", dict));
    }
}
