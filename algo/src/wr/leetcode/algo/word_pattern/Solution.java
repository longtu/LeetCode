package wr.leetcode.algo.word_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
/*
    public String notNull (String str) {
        return (null == str) ? (""):(str);
    }

    public boolean wordPattern(String pattern, String str) {
        pattern = notNull(pattern);
        str = notNull(str);

        String[] words = str.split(" ");
        Map<String, Character> map = new HashMap<>();
        Set<Character> keys = new HashSet<>();
        boolean ret = true;

        if(pattern.length() != words.length) {
            ret = false;
        } else {
            for (int i = 0; i < words.length; ++i) {
                String word = words[i];
                char ch = pattern.charAt(i);
                if(!map.containsKey(word)) {
                    if(keys.contains(ch)) {
                        ret = false;
                        break;
                    } else {
                        map.put(word, ch);
                        keys.add(ch);
                    }
                } else if(!map.get(word).equals(ch)) {
                    ret = false;
                    break;
                }
            }
        }
        return ret;
  }*/



    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> l2r = new HashMap<>();
        Set<Character> rs = new HashSet<>();

        String[] strs = str.split(" ");
        boolean ret = true;
        if(strs.length != pattern.length()) {
            ret = false;
        } else {
            for (int i = 0; i < strs.length; ++i) {
                String s = strs[i];
                char p = pattern.charAt(i);
                if( l2r.containsKey(s) ) {
                    char ch = l2r.get(s);
                    if(ch!= p) {
                        ret = false;
                        break;
                    }
                } else {
                    if(rs.contains(p)) {
                        ret = false;
                        break;
                    }
                    l2r.put(s, p);
                    rs.add(p);
                }
            }
        }
        return ret;
    }






    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog dog dog dog"));
    }
}
