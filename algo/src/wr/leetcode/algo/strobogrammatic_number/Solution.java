package wr.leetcode.algo.strobogrammatic_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private Map<Character, Character> mirror() {
        Map<Character, Character> mirror = new HashMap<>();
        mirror.put('1','1');
        mirror.put('8', '8');
        mirror.put('6', '9');
        mirror.put('9', '6');
        //BUG: 0 is also!!!
        mirror.put('0', '0');
        return mirror;
    }


    public boolean isStrobogrammatic(String num) {
        boolean ret = true;
        if(null != num && !num.isEmpty()) {
            Map<Character, Character> mirror = mirror();
            int start = 0;
            int end = num.length() - 1;
            while (start <= end) {
                char left = num.charAt(start++);
                char right = num.charAt(end--);
                if(!mirror.containsKey(left) || right != mirror.get(left)) {
                    ret = false;
                    break;
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "",
                null,
                "1",
                "8",
                "6",
                "9",
                "69",
                "88",
                "818",
                "916"
        }) {
            System.out.println(sol.isStrobogrammatic(str));
        }
    }
}
