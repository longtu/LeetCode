package wr.leetcode.algo.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<Character, Integer> table() {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        return dict;
    }

    public boolean isNeg(char prev, char next, Map<Character, Integer> table) {
        return table().get(prev) < table().get(next);
    }


    public int romanToInt(String s) {

        int ret = 0;
        if(null != s && !s.isEmpty()) {
            int n = s.length();
            Map<Character, Integer> table = table();

            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                int val = table.get(ch);
                int sign = 1;

                if(i < n-1 && isNeg( ch, s.charAt(i+1), table)) {
                    sign = -1;
                }
                ret += val * sign;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "I",
                "DCCCXC",
                "DCCVII",
                "DXXX",
                "MDCCC",
                ""
        }) {
            System.out.println(sol.romanToInt(str));
        }
    }
}
