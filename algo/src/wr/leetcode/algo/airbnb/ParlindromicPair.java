package wr.leetcode.algo.airbnb;

import java.util.*;

public class ParlindromicPair {
    List<String> getPalindromaticPairs(String[] input) {
        Set<String> result = new HashSet<>();

        if (input != null && input.length > 0) {
            // Step 1: put the reversed order of each word into the map
            Map<String, Integer> map = new HashMap<>();

            for (String str : input) {
                String reStr = reverse(str);
                Integer indices = map.getOrDefault(reStr, 0) + 1;
                map.put(reStr, indices);
            }

            // Step 2: Iterate each word
            for (String str : input) {
                // Get all the prefix/postfix of str, and append to the end
                for (int j = 0; j <= str.length(); j++) {
                    String prefix = str.substring(0, j);
                    String postfix = str.substring(j);
                    String reverse = reverse(str);
                    if (map.containsKey(prefix) && isPalindrome(postfix)) {
                        if (map.get(prefix) > 1 || !prefix.equals(reverse)) {
                            String palin = str + reverse(prefix);
                            result.add(palin);
                        }
                    }
                    if (map.containsKey(postfix) && isPalindrome(prefix)) {
                        if (map.get(postfix) > 1 || !postfix.equals(reverse)) {
                            String palin = reverse(postfix) + str;
                            result.add(palin);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<String>> pairPalindrome(List<String> words){
        List<List<String>> res = new ArrayList<List<String>>();
        if(words == null || words.size() == 0){
            return res;
        }
        HashSet<String> hashset = new HashSet<String>();
        for(String word : words){
            hashset.add(word);
        }
        for(String word : words){
            int N = word.length();
            for(int i = 0; i < N; i++){
                String prefix = word.substring(0, i);
                String suffix = word.substring(i, N);
                String reverseSuffix = reverse(suffix);
                if(isPalindrome(prefix) && hashset.contains(reverseSuffix)){

                    List<String> sol = new ArrayList<String>();
                    sol.add(reverseSuffix);
                    sol.add(word);
                    res.add(sol);
                }
            }
        }
        return res;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    private boolean isPalindrome(String s) {
        s = (null == s)?(""):(s);
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        ParlindromicPair solution = new ParlindromicPair();
        String[][] inputs = {
                {},
                {"a","b","c"},
                {"a","b","a","cd","dc"},
                {"abc", "cba", "bbc"},
                {"aabc", "cb"},
                {"cbaa", "bc"}
        };

        for (String[] input : inputs) {
            List<List<String>> res = solution.pairPalindrome(Arrays.asList(input));
            System.out.println(res);
            List<String> result = solution.getPalindromaticPairs(input);
            System.out.println(result);
            System.out.println("====");
        }
    }
}
