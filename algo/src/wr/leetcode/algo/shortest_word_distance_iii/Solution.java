package wr.leetcode.algo.shortest_word_distance_iii;

import java.util.ArrayList;
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
                if(i == j) {
                    continue;
                }
                int d = Math.abs(i - j);
                if (d < dist) {
                    dist = d;
                }
            }
        }
        return dist;

    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if( null == words ) {
            words = new String[0];
        }

        ArrayList<Integer> lefts = positions(words, word1);
        ArrayList<Integer> rights = positions(words, word2);

        return minDist(lefts, rights);
    }

    public ArrayList<Integer> positions( String[] words, String word) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            if(words[i].equals(word)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public int minDist( ArrayList<Integer> left, ArrayList<Integer> right ) {
        int i = 0, j = 0;
        int m = left.size();
        int n = right.size();
        int minDiff = Integer.MAX_VALUE;
        while( i < m && j < n ) {
            int lv = left.get(i);
            int rv = right.get(j);
            int diff = Math.abs(lv-rv);
            if( diff < minDiff && 0 != diff) {
                minDiff = diff;
            }
            if( i < m-1 && j < n-1 ) {
                if(lv<=rv) {
                    i++;
                } else {
                    j++;
                }
            } else if (i == m - 1) {
                j++;
            } else {
                i++;
            }
        }
        return minDiff;
    }


    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        Solution sol = new Solution();
        System.out.println(sol.shortestDistance(words, "coding", "practice"));
        System.out.println(sol.shortestDistance(words, "coding", "makes"));
        System.out.println(sol.shortestDistance(words, "makes", "makes"));

        System.out.println(sol.shortestWordDistance(words, "coding", "practice"));
        System.out.println(sol.shortestWordDistance(words, "coding", "makes"));
        System.out.println(sol.shortestWordDistance(words, "makes", "makes"));
    }
}
