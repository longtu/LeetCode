package wr.leetcode.algo.word_pattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

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
  }
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.wordPattern("abba", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog dog dog dog"));
    }
}
