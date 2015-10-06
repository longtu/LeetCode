package wr.leetcode.algo.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        s = (null == s) ? (""):(s);
        t = (null == t) ? (""):(t);

        Map<Integer, Integer> charCount = new HashMap<>();
        for (char ch : s.toCharArray()) {
            Integer key = (int)ch;
            int val = 1;
            if(charCount.containsKey(key)) {
                val = charCount.get(key) + 1;
            }
            charCount.put(key, val);
        }

        for (char ch : t.toCharArray()) {
            Integer key = (int)ch;
            if(!charCount.containsKey(key)) {
                return false;
            }
            int val = charCount.get(key) - 1;
            if( 0 == val) {
                charCount.remove(key);
            } else {
                charCount.put(key, val);
            }
        }
        return charCount.isEmpty();
    }
}
