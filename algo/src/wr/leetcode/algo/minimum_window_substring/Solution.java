package wr.leetcode.algo.minimum_window_substring;

public class Solution {

    public String notNull(String str) {
        return (null == str)? (""):(str);
    }

    public String minWindow(String s, String t) {
        s = notNull(s);
        t = notNull(t);
        String ret = "";
        if (0 != t.length() && s.length() >= t.length()) {
            int[] dict = new int[256];
            int[] target = new int[256];
            int wanted = 0;
            for (char ch : t.toCharArray()) {
                target[ch] += 1;
                if(target[ch] == 1) {
                    wanted += 1;
                }
            }
            int appear = 0;
            int n = s.length();
            int start = -1;
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                if(target[ch] == 0) {
                    continue;
                }
                dict[ch]++;
                if(dict[ch] == target[ch]) {
                    appear += 1;
                }
                while( appear == wanted ) {
                    int dist = i-start;
                    if(dist < minLen) {
                        minLen = dist;
                        ret = s.substring(start+1, i+1);
                    }
                    char c = s.charAt(++start);
                    if(target[c] > 0) {
                        dict[c]--;
                        if(dict[c] < target[c]) {
                            appear --;
                        }
                    }
                }
            }
        }
        return ret;
    }

        public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "aa"));
        System.out.println(sol.minWindow("ab", "b"));

    }
}