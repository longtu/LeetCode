package wr.leetcode.algo.unique_word_abbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ValidWordAbbr {

    final Map<String, Set<String>> abbrs;


    //understand the problem: other words!!!!
    public ValidWordAbbr(String[] dictionary) {
        abbrs = new HashMap<>();
        for (String w : dictionary) {
            String abbr = abbr(w);
            Set<String> abbrSet = abbrs.getOrDefault(abbr, new HashSet<>());
            abbrSet.add(w);
            abbrs.put(abbr, abbrSet);
        }
    }

    //understand the problem: other words!!!!
    public boolean isUnique(String word) {
        String abbr = abbr(word);
        //BUG: NPE
        Set<String> words = abbrs.getOrDefault(abbr, new HashSet<>());

        boolean ret = true;
        //BUG: check other has to be nonempty first
        if(!words.isEmpty() && (!words.contains(word) || words.size() > 1)) {
            ret = false;
        }
        return ret;
    }


    public String abbr(String word) {
        if(null == word || word.length() < 3) {
            return word;
        } else {
            return word.charAt(0) + Integer.toString(word.length()-2) + word.charAt(word.length()-1);
        }
    }

    public static void main(String[] args) {
        ValidWordAbbr validWordAbbr = new ValidWordAbbr(
                new String[]{"deer", "door", "cake", "card"}
        );
        String[] words = {"dear","cart","cane","make"};
        for (String w : words) {
            System.out.println(validWordAbbr.isUnique(w));
        }
    }
}
