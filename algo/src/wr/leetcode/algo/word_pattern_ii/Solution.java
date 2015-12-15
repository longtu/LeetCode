package wr.leetcode.algo.word_pattern_ii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(null == pattern){
            pattern = "";
        }
        if(null == str) {
            str = "";
        }
        return wordPatternMatch(new HashMap<>(), new HashMap<>(), pattern, str);
    }

    public boolean wordPatternMatch(Map<Character, String> mapping,
        Map<String, Character> reverseMapping, String pattern, String str) {

        boolean match = false;
        if(pattern.isEmpty()) {
            match = str.isEmpty();
        } else {
            Character ch = pattern.charAt(0);
            if(mapping.containsKey(ch)) {
                String prefix = mapping.get(ch);
                match = str.startsWith(prefix) && wordPatternMatch( mapping, reverseMapping,
                    pattern.substring(1), str.substring(prefix.length()) );
            } else {//build reverse mapping
                //BUG: we reduces the pattern by 1 already:
                //pattern.length() -> pattern.length() - 1
                int patternCount = pattern.length() - 1;
                for (int i = 1; i + patternCount <= str.length() && !match; ++i) {
                    String w = str.substring(0, i);
                    if(!reverseMapping.containsKey(w)) {
                        mapping.put(ch, w);
                        reverseMapping.put(w, ch);
                        match = wordPatternMatch(mapping, reverseMapping,
                            pattern.substring(1), str.substring(i));
                        //BUG: mapping needs reset !!!
                        mapping.remove(ch);
                        reverseMapping.remove(w);
                    }
                }
            }
        }
        return match;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] test = {
                {"abab","redblueredblue"},
                {"aaaa","asdasdasdasd"},
                {"aabb","xyzabcxzyabc"},
                {"",""},
                {"d","e"},
                {"abb","dogcatcat"},
                {"abba","dogcatcatdog"},

        };

        for (String[] testCase : test) {
            System.out.println(sol.wordPatternMatch(testCase[0], testCase[1]));
        }
    }
}
