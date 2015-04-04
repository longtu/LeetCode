package wr.leetcode.algo.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int lengthOfLongestSubstring(String s) {

		int ret = 0;
		if(null == s) { return ret; }

		Map<Character, Integer> lastPos = new HashMap();
		int pos = 0;
		for (char ch : s.toCharArray()) {
			if(lastPos.containsKey(ch)) {
				ret = Math.max(ret, pos-lastPos.get(ch));
			} else {
				lastPos.put(ch, pos);
			}
			pos++;
		}
		return ret;
	}
}