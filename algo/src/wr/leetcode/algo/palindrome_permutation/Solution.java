package wr.leetcode.algo.palindrome_permutation;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(null == s) {
            return true;
        }
        Map<Character, Integer> count = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int cnt = count.getOrDefault(ch, 0) + 1;
            count.put(ch, cnt);
        }
        long odds = count.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter((a) -> (1 == a%2))
                .count();

        return odds < 2;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (String str : new String[] {
            "code","aab","carerac","",null
        }) {
            System.out.println(sol.canPermutePalindrome(str));
        }
    }
}
