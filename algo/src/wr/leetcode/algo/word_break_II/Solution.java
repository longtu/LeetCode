package wr.leetcode.algo.word_break_II;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<String> wordBreak(int i, String local, Set<String> dict, Set<Integer> wordLens, String target) {
        int n = target.length();
        List<String> ret = new LinkedList<>();

        for (int wordLen : wordLens) {
            if(i+wordLen > n) {
                continue;
            }
            String word = target.substring(i, i+wordLen);
            if(!dict.contains(word)) {
                continue;
            }
            if (i+wordLen == n) {
                String str = local + " " + word;
                ret.add( str.trim() );
                continue;
            }
            ret.addAll(wordBreak(i + wordLen, local + " " + word,  dict, wordLens, target));
        }
        return ret;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if(s == null) {
            s = "";
        }
        if(dict == null) {
            dict = new HashSet<>();
        }
        dict.remove("");
        int n = s.length();

        if(!validateVocabulary(s, dict)) {
            return new LinkedList<>();
        }

        Set<Integer> wordLens = dict.stream().map( a -> a.length())
                .collect(Collectors.toSet());
        return wordBreak(0, "", dict, wordLens, s);
    }

    public boolean validateVocabulary(String s, Set<String> dict)
    {
        Set<Integer> vocabulary = dict.stream().flatMap(a -> a.chars().boxed()).collect(Collectors.toSet());
        if (s.chars().boxed().filter( a -> !vocabulary.contains(a)).findAny().isPresent())
            return false;

        Set<Character> ends = dict.stream().map(a -> a.charAt(a.length() - 1)).collect(Collectors.toSet());
        if (!ends.contains(s.charAt(s.length()-1)))
            return false;

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict = Arrays.asList("a","aa","ba").stream().collect(Collectors.toSet());
        System.out.println(sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
    }
}