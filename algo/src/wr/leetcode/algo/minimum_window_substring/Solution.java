package wr.leetcode.algo.minimum_window_substring;

import java.util.*;

public class Solution {

    public String notNull(String str) {
        return (null == str)? (""):(str);
    }

    public String minWindow(String s, String t) {
        s = notNull(s);
        t = notNull(t);
        String ret = "";
        if (0 != t.length() && s.length() >= t.length()) {
            Map<Character, Integer> target = table(t);
            Map<Character, Integer> dict = new HashMap<>();
            int n = s.length();
            int start = 0;
            int minLen = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                int cnt = dict.getOrDefault(ch, 0) + 1;
                dict.put(ch, cnt);
                while( matches(dict, target) ) {
                    int dist = i-start + 1;
                    if(dist < minLen) {
                        minLen = dist;
                        ret = s.substring(start, i+1);
                    }
                    char c = s.charAt(start++);
                    int count = dict.getOrDefault(c, 0) - 1;
                    //BUG: c instead of CH BABY!!!
                    dict.put(c, count);
                }
            }
        }
        return ret;
    }

    public Map<Character, Integer> table( String t ) {
        Map<Character, Integer> table = new HashMap<>();
        for (char ch : t.toCharArray()) {
            int cnt = table.getOrDefault(ch, 0) + 1;
            table.put(ch, cnt);
        }
        return table;
    }

    public boolean matches(Map<Character, Integer> count, Map<Character, Integer> target) {

        boolean ret = true;
        for ( Character ch : target.keySet() ) {
            int tV = target.get(ch);
            int cV = count.getOrDefault(ch, 0);
            if(cV < tV) {
                ret = false;
                break;
            }
        }
        return ret;
    }


    /*
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

    private String notNull(String t) {
        return (null == t) ? (""):(t);
    }

    public String minWindow(String s, String t) {
        s = notNull(s);
        t = notNull(t);

        Set<Character> keys = new HashSet<>();
        Map<Character, Integer> index = new HashMap<>();
        String ret = null;
        for (char ch : t.toCharArray()) {
            int v = index.getOrDefault(ch, 0) + 1;
            index.put(ch, v);
            keys.add(ch);
        }

        for (int h = 0, e = 0; e < s.length(); e++) {
            char ch = s.charAt(e);
            if( !keys.contains(ch) ) {
                continue;
            }
            int val = index.get(ch) - 1;
            index.put(ch, val);
            if(isWindow(index)) {
                if(null == ret || ret.length() > (e-h+1)) {
                    ret = s.substring(h, e+1);
                }
                while(isWindow(index) && h<= e){
                    if(ret.length() > (e-h+1)) {
                        ret = s.substring(h, e+1);
                    }
                    char hch = s.charAt(h++);
                    if(!keys.contains(hch)) {
                        continue;
                    }
                    int v = index.get(hch) + 1;
                    index.put(hch,v);
                }
            }
        }
        return (null == ret)?(""):(ret);
    }

    public boolean isWindow( Map<Character, Integer> map ) {
        boolean ret = true;
        for ( int v : map.values()) {
            if (v > 0) {
                ret = false;
            }
        }
        return ret;
    }*/



        public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "aa"));
        System.out.println(sol.minWindow("ab", "b"));

    }
}