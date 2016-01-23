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

    String notNull( String str ) {
        return (null == str)?(""):(str);
    }

    public boolean isIsomorphic(String s, String t) {
        s = notNull(s);
        t = notNull(t);

        boolean ret;
        if (s.length() != t.length() ) {
            ret = false;
        } else {
            Map<Character, Character> left = new HashMap<>();
            Map<Character, Character> right = new HashMap<>();

            ret = true;
            int n = s.length();
            for ( int i = 0; i < n; ++i ) {
                char l = s.charAt(i);
                char r = t.charAt(i);
                if( (left.containsKey(l) && !left.get(l).equals(r)) ||
                        (right.containsKey(r) && !right.get(r).equals(l)) )  {
                    ret = false;
                    break;
                } else {
                    left.put(l, r);
                    right.put(r,l);
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