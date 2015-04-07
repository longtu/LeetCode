package wr.leetcode.algo.valid_palindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        boolean ret = true;
        if(null==s) {
        	return ret;
        }
        int start = 0;
        int end = s.length()-1;
        while(start < end ) {
        	if(!isValid(s.charAt(start))) {
        		start ++;
        		continue;
        	}
        	if(!isValid(s.charAt(end))) {
        		end --;
        		continue;
        	}
        	if(!isMatch(s.charAt(start), s.charAt(end))){
        		ret = false;
        		break;
        	} else {
	        	start++;
    	    	end--;
        	}
        }
        return ret;
    }

    private boolean isValid( char ch) {
    	return ((ch >= 'a') && (ch <= 'z')) ||
    			((ch >= 'A') && (ch <= 'Z')) ||
    			((ch >= '0') && (ch <= '9'));
    }


    private boolean isMatch( char left, char right) {
    	return (left == right) ||
    			(left == right + 'Z' - 'z') ||
    			(right == left + 'Z' - 'z');
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
    }
}