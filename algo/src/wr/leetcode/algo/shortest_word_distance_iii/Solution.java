package wr.leetcode.algo.shortest_word_distance_iii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> left = positions(words, word1);
        ArrayList<Integer> right = positions(words, word2);
        return minDist(left, right);
    }

    ArrayList<Integer> positions(String[] words, String key) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String w = words[i];
            if(key.equals(w)) {
                ret.add(i);
            }
        }
        return ret;
    }

    int minDist(ArrayList<Integer> left, ArrayList<Integer> right) {
        int leftLen = left.size();
        int rightLen = right.size();
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        while(i < leftLen && j < rightLen) {
            int lv = left.get(i);
            int rv = right.get(j);
            int diff = Math.abs(lv-rv);
            if (diff < minDiff && diff != 0) {
                minDiff = diff;
            }

            if(lv <= rv) {
                i++;
            } else {
                j++;
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

    }
}
