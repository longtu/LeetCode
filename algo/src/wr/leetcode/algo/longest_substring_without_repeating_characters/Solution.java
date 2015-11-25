package wr.leetcode.algo.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {




    public int lengthOfLongestSubstring(String s) {
        if( null == s) {
            s = "";
        }
        int n = s.length();
        Map<Character, Integer> dict = new HashMap<>();
        int max = 0;
        int start = -1;
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if( 0 == i) {
                start = i;
            }
            if(dict.containsKey(ch)) {// has duplicates
                int newStart = dict.get(ch) + 1;
                for (int j = start; j < newStart; ++j) {
                    dict.remove(s.charAt(j));
                }
                start = newStart;
            }
            dict.put(ch, i);
            int dist = (i-start + 1);
            max = Math.max(max, dist);
        }
        return max;
    }

    /*
    public int lengthOfLongestSubstring(String s) {
        if(null == s) {
            s = "";
        }
        int maxLen = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                maxLen = Math.max(i - start + 1, maxLen);
            } else {
                int newStart = map.get(ch) + 1;
                for(; start <= newStart; ++i) {
                    map.remove(s.charAt(start));
                }
            }
            map.put(ch, i);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        int ret = 0;
        Set<Character> dict= new HashSet();

        for(int end = 0, start = 0 ; end <= s.length() ; ++ end) {
            if(end > 0) {
                Character ch = s.charAt(end-1);
                if(dict.contains(ch)) {
                    while(s.charAt(start) != ch)
                        dict.remove(s.charAt(start++));
                    start ++;
                }
                dict.add(ch);
            }
            ret = Math.max(ret, end-start);
        }
        return ret;
    }


    public int lengthOfLongestSubstring0(String s) {

        int ret = 0;
        if(null == s) { return ret; }

        Map<Character, Integer> lastPos = new HashMap();
        int start = -1;
        int thisLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(lastPos.containsKey(ch)) {
                start = Math.max(start, lastPos.get(ch));
                thisLen = i - start;
            } else {
                thisLen++;
            }
            ret = Math.max(ret, thisLen);
            lastPos.put(ch, i);
        }
        return ret;
    }
    */



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("aa"));
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
    }
}