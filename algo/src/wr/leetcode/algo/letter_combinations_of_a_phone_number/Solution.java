package wr.leetcode.algo.letter_combinations_of_a_phone_number;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<String> letterCombinations(String digits) {
        Map<Character, String> code = new HashMap();
        code.put('2', "abc");
        code.put('3', "def");
        code.put('4', "ghi");
        code.put('5', "jkl");
        code.put('6', "mno");
        code.put('7', "pqrs");
        code.put('8', "tuv");
        code.put('9', "wxyz");
        List<String> ret = new LinkedList();

        if(null == digits ){
            digits = "";
        }

        digits = digits.replaceAll("[01]","");
        if( digits.length() == 0) {
            return ret;
        }

        List<StringBuilder> outputs = new LinkedList();
        outputs.add(new StringBuilder(""));
        for (int i = 0; i < digits.length(); ++i) {
            List<StringBuilder> curr = new LinkedList();
            char [] chs = code.getOrDefault(digits.charAt(i), "").toCharArray();
            for (StringBuilder str : outputs) {
                for(char c : chs) {
                    StringBuilder sb = new StringBuilder(str);
                    sb.append(c);
                    curr.add(sb);
                }
            }
            outputs = curr;
        }
        for(StringBuilder sb : outputs) {
            ret.add(sb.toString());
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("203"));
        System.out.println(sol.letterCombinations(null));
        System.out.println(sol.letterCombinations(""));
    }
}
