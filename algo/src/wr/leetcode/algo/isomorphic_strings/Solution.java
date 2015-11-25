package wr.leetcode.algo.isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    /*
    public boolean isIsomorphic(String s, String t) {
        if( null == s ) {
            s = "";
        }
        if (null == t) {
            t = "";
        }
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> rMap = new HashMap<>();

        boolean ret = true;
        for(int i = 0; i < s.length(); ++i) {
            Character lhs = s.charAt(i);
            Character rhs = t.charAt(i);

            if(rMap.containsKey(rhs) && rMap.get(rhs) != lhs) {
                ret = false;
                break;
            }
            if(map.containsKey(lhs) && map.get(lhs) != rhs) {
                ret = false;
                break;
            }
            map.put(lhs, rhs);
            rMap.put(rhs, lhs);
        }
        return ret;
    }*/


    private String notNull(String s) {
        return (null == s)? (""):(s);
    }

    public boolean isIsomorphic(String s, String t) {

        s = notNull(s);
        t = notNull(t);
        boolean ret = true;
        if(s.length() != t.length()) {
            ret = false;
        } else {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> values = new HashSet<>();
            for (int i = 0; i < s.length(); ++i) {
                char k = s.charAt(i);
                char v = t.charAt(i);

                if(!map.containsKey(k)) {
                    if(values.contains(v)) {
                        ret = false;
                        break;
                    }
                    map.put(k,v);
                    values.add(v);
                } else {
                    if(!map.get(k).equals(v)) {
                        ret = false;
                        break;
                    }
                }
            }
        }
        return ret;
    }





    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isIsomorphic("egg","add"));
        System.out.println(sol.isIsomorphic("foo","bar"));
        System.out.println(sol.isIsomorphic("paper","title"));

    }
}