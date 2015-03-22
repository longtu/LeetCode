package wr.leetcode.algo.word_break;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public Solution() {
    }

    public boolean wordBreak(String s, Set<String> dict) {
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