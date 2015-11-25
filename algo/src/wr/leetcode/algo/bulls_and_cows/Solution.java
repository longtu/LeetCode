package wr.leetcode.algo.bulls_and_cows;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        if(null != secret) {
            int n = secret.length();
            int bulls = 0;
            Map<Character, Integer> secretDigit = new HashMap<>();
            Map<Character, Integer> guessDigit = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                char ch = secret.charAt(i);
                if(ch == guess.charAt(i)) {
                    //BUG: += 1 instead of 0
                    bulls += 1;
                } else {
                    addToMap(secretDigit, ch);
                    addToMap(guessDigit, guess.charAt(i));
                }
            }
            int cows = getCows(secretDigit, guessDigit);
            sb.append(bulls);
            sb.append('A');
            sb.append(cows);
            sb.append('B');
        }
        return sb.toString();
    }

    public void addToMap(Map<Character, Integer> dict, char ch ) {
        int count = dict.getOrDefault(ch, 0) + 1;
        dict.put(ch, count);
    }

    public int getCows(Map<Character, Integer> src, Map<Character, Integer> dest ) {
        int cows = 0;
        for (Character ch : src.keySet() ) {
            int min = Math.min(src.get(ch), dest.getOrDefault(ch, 0));
            cows += min;
        }
        return cows;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getHint("",""));
        System.out.println(sol.getHint("1807","7810"));
        System.out.println(sol.getHint("1123","0111"));

    }


}
