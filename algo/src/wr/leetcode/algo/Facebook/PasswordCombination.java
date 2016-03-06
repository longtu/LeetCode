package wr.leetcode.algo.Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PasswordCombination {
    public List<String> password(String str, Map<Character, String> dict) {
        List<String> ret = new LinkedList<>();
        if( null != str) {
            ret = password(str, 0, dict);
        }
        return ret;
    }

    private List<String> password(String str, int index, Map<Character, String> dict ) {
        List<String> ret = new LinkedList<>();
        if( index == str.length() ) {
            ret.add("");
        } else {
            char ch = str.charAt(index);
            List<String> subs = password(str, index+1, dict);
            String chars = dict.getOrDefault(ch, Character.toString(ch));
            for (String sub : subs) {
                for (char c : chars.toCharArray()) {
                    ret.add( c+sub );
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        PasswordCombination sol = new PasswordCombination();

        String str = "facea";
        Map<Character, String> dict = new HashMap<Character, String>();

        //dict.put('f', "f");
        dict.put('a', "aA4");
        //dict.put('c', "c");
        dict.put('e', "eE");

        List<String> result = sol.password(str, dict);

        for (String s : result) {
            System.out.println(s);
        }
    }
}
