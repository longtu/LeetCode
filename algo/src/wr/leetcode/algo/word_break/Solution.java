package wr.leetcode.algo.word_break;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

		public boolean wordBreak(String s, Set<String> dict) {
			boolean ret = false;
			if(s.length() > 0) {
				int n = s.length();
				Boolean[] dp = new Boolean[n+1];
				dp[n] = true;
				ret = wordBreak(s, 0, dp, dict);
			}
			return ret;
		}

		public boolean wordBreak(String s, int i, Boolean[] dp, Set<String> dict) {
			if(dp[i] == null) {
				boolean ret = false;
				for (int j = i+1; j <= s.length(); ++j) {
					String str = s.substring(i, j);
					if( dict.contains(str) && wordBreak(s, j, dp, dict)) {
						ret = true;
						break;
					}
				}
				dp[i] = ret;
			}
			return dp[i];
		}

    public boolean wordBreakBfs(String s, Set<String> dict) {
 		if(s == null) {
 			s = "";
 		}
 		if(dict == null) {
 			dict = new HashSet<>();
 		}
 		dict.remove("");
 		int n = s.length();
 		Set<Integer> wordLens = dict.stream().map( a -> a.length())
 								.collect(Collectors.toSet());

 		Queue<Integer> queue = new LinkedList<Integer>();
 		Set<Integer> candidates = new HashSet<Integer>();
 		queue.offer(0);
 		candidates.add(0);

 		while(!queue.isEmpty()) {
 			int i = queue.poll();
 			candidates.remove(i);
 			for (int wordLen : wordLens) {
 				if(i+wordLen > n) {
 					continue;
 				}
 				String word = s.substring(i, i+wordLen);
 				if(!dict.contains(word)) {
 					continue;
 				}
 				if (i+wordLen == n) {
 					return true;
 				}
 				if(!candidates.contains(i + wordLen)) {
 					queue.offer(i+wordLen);
 					candidates.add(i+wordLen);
 				}
 			}
 		}
 		return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Set<String> dict = Arrays.asList("wangran", "leet", "code").stream().collect(Collectors.toSet());
        System.out.println(sol.wordBreak("leetwangrancode", dict));
    }
}