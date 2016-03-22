package wr.leetcode.algo.word_break_II;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> ret = new LinkedList<>();
        int n = s.length();
        if (n > 0) {
            LinkedList<String> [] dp = new LinkedList[n+1];
            dp[n] = new LinkedList<>();
            dp[n].add("");
            ret = wordBreak(s, 0, dict, dp);
        }
        return ret;
    }

    public List<String> wordBreak(String s, int i, Set<String> dict, LinkedList<String> [] dp) {
        LinkedList<String> ret = new LinkedList<>();
        if(dp[i] == null) {
            for (int j = i+1; j <= s.length(); ++j) {
                String str = s.substring(i, j);
                if(dict.contains(str)) {
                    List<String> subSols = wordBreak(s, j, dict, dp);
                    for (String subSol : subSols) {
                        String sub = str + ((subSol.isEmpty())?(""):(" ")) + subSol;
                        ret.add(sub);
                    }
                }
            }
            dp[i] = ret;
        }
        return dp[i];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict = new HashSet<>();
        for (String w : new String[] {"cat", "cats", "and", "sand", "dog" }) {
            dict.add(w);
        }
        for (String s : new String[] {"","catsanddog", "cats", "catss" }) {
            System.out.println(sol.wordBreak(s, dict));
        }

        dict = Arrays.asList("a", "aa", "ba").stream().collect(Collectors.toSet());
        long time = System.currentTimeMillis();
        System.out.println(sol.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));
        System.out.println(System.currentTimeMillis() - time);
    }
}