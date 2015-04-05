package wr.leetcode.algo.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
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

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("aa"));
    }
}