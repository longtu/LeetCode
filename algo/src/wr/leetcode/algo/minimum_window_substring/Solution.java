package wr.leetcode.algo.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String S, String T) {

        String ret = "";
        if (null == S || null == T) {
            return ret;
        }
        Map<Character, Integer> tchars = new HashMap<>();
        for(Character ch : T.toCharArray()) {
            tchars.put(ch, tchars.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> dic = new HashMap();

        int start = 0;
        int end = 0;
        int n = S.length();
        boolean found = false;

        while (end <= n) {
            if (end > 0) {
                char ch = S.charAt(end - 1);
                if (tchars.containsKey(ch)) {
                    dic.put(ch, dic.getOrDefault(ch, 0) + 1);
                }
            }
            if (hasFound(tchars, dic)) {
                if (!found || (ret.length() > end - start)) {
                    found = true;
                    ret = S.substring(start, end);
                }
                start++;
                while (start <= end) {
                    char ch = S.charAt(start - 1);
                    if (tchars.containsKey(ch)) {
                        dic.put(ch, dic.get(ch) - 1);
                    }
                    if (hasFound(tchars, dic)) {
                        if (ret.length() > end - start) {
                            ret = S.substring(start, end);
                        }
                    } else {
                        break;
                    }
                    start++;
                }
            }
            end++;
        }
        return ret;
    }

    private boolean hasFound( Map<Character,Integer> src, Map<Character, Integer> dest ){
        for ( Map.Entry<Character, Integer> entry : src.entrySet()) {
            Integer destCount = dest.get(entry.getKey());
            if(destCount == null || destCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "aa"));
        System.out.println(sol.minWindow("ab", "b"));

    }
}