package wr.leetcode.algo.shortest_word_distance_ii;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordDistance {

    Map<String, Set<Integer>> dict = new HashMap<>();


    public WordDistance(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; ++i) {
            String w = words[i];
            Set<Integer> set = dict.getOrDefault(w, new HashSet<>());
            set.add(i);
            //BUG: forgot to put back!!!!
            dict.put(w, set);
        }
    }

    public int shortest(String word1, String word2) {
        Set<Integer> lefts = dict.get(word1);
        Set<Integer> rights = dict.get(word2);

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
        WordDistance sol = new WordDistance(words);
        System.out.println(sol.shortest("coding", "practice"));
        System.out.println(sol.shortest("coding", "makes"));
    }
}
