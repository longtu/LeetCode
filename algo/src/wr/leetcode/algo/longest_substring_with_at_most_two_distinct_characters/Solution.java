package wr.leetcode.algo.longest_substring_with_at_most_two_distinct_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLen = 0;
        if(null != s && !s.isEmpty()) {
            int left = -1;  //exclusive
            int right = -1; //inclusive
            int n = s.length();
            Map<Character, Integer> count = new HashMap<>();
            for (right = 0; right < n; ++right) {
                char ch = s.charAt(right);
                int cnt;
                if(count.containsKey(ch)) {
                    cnt = count.get(ch) + 1;
                } else if(count.size() < 2 ){ //only 1 or 0 elements
                    cnt = 1;
                } else { //exactly 2 elements
                    while(count.size() == 2) {
                        char c = s.charAt(++left);
                        int cv = count.get(c) - 1;
                        if(0 == cv) {
                            count.remove(c);
                        } else {
                            count.put(c, cv);
                        }
                    }
                    cnt = 1;
                }
                count.put(ch, cnt);
                int len = right - left;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String[] arrs = { null,"", "eceba", "aaa", "aaaabbb","aaaabbbbcc"};
        Solution sol = new Solution();
        for (String a : arrs) {
            System.out.println(sol.lengthOfLongestSubstringTwoDistinct(a));
        }
    }

}
