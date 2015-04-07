package wr.leetcode.algo.implement_strstr;

public class Solution {
    public int strStr(String haystack, String needle) {
    	if (null == haystack) {
    		haystack = "";
    	}
    	if ( null == needle || "" == needle) {
    		return 0;
    	}

    	int ret = -1;
    	for (int i = 0; i < haystack.length() + 1- needle.length(); ++i) {
    		int j = 0;
            for (j = 0; j < needle.length(); ++j) {
    			if(haystack.charAt(i+j) != needle.charAt(j)) {
    				break;
    			}
    		}
    		if(j == needle.length()) {
    			ret = i;
    			break;
    		}
    	}
    	return ret;
    }
}
