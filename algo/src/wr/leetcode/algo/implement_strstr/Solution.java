package wr.leetcode.algo.implement_strstr;

public class Solution {



    public String notNull( String str) {
        return (null == str)?(""):(str);
    }

    public int strStr(String haystack, String needle) {
        int ret = -1;
        needle = notNull(needle);
        if(null != haystack) {
            int m = haystack.length();
            int n = needle.length();
            for (int i = 0; i + n <= m; ++i) {
                int j = 0;
                for (int k = i ; j < n; ++j,++k) {
                    if( haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == n) {
                    ret = i;
                    break;
                }
            }
        }
        return ret;
    }



    /*
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
    }*/
}
