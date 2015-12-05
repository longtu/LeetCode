package wr.leetcode.algo.shortest_word_distance;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {

        Set<Integer> lefts = new HashSet<>();
        Set<Integer> rights = new HashSet<>();

        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            if(word1.equals(w)) {
                lefts.add(i);
            }
            if(word2.equals(w)) {
                rights.add(i);
            }
        }

        int dist = Integer.MAX_VALUE;
        for ( int i : lefts) {
            for (int j : rights) {
                int d = Math.abs(i - j);
                if (d < dist) {
                    dist = d;
                }
            }
        }
        return dist;

    }


    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        Solution sol = new Solution();
        System.out.println(sol.shortestDistance(words, "coding", "practice"));
        System.out.println(sol.shortestDistance(words, "coding", "makes"));
    }
}
