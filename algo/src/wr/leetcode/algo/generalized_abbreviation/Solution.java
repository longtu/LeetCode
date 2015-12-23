package wr.leetcode.algo.generalized_abbreviation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateAbbreviations(String word) {
        if( null == word) {
            word = "";
        }
        return new LinkedList<>(generateAbbreviations(word, word.length()));
    }

    public Set<String> generateAbbreviations(String word, int len) {
        Set<String> ret = new HashSet<>();
        if( 0 == len ) {
            ret.add("");
        } else {
            char ch = word.charAt(len-1);
            Set<String> subStrs = generateAbbreviations(word, len-1);
            for (String str : subStrs) {
                ret.add(str + ch);
                ret.add(appendOne(str));
            }
        }
        return ret;
    }

    private String appendOne(String word) {
        int start = word.length() -1;
        while(start >= 0) {
            char ch = word.charAt(start);
            if( ch >= '0' && ch <= '9') {
                start --;
            } else { //BUG: forgot to break!!!
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(start == word.length() - 1) {
            sb.append(word);
            sb.append(1);
        } else {
            Integer val = Integer.parseInt(word.substring(start + 1, word.length())) + 1;
            sb.append(word.substring(0, start+1));
            sb.append(val);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (String str : new String[] {
                null, "", "word"
        }) {
            System.out.println(sol.generateAbbreviations(str));
        }
    }

}
