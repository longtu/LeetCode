package wr.leetcode.algo.valid_palindrome;

public class Solution {
    /*
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

    public boolean isPalindrome(String s) {
        boolean ret = true;
        if( null != s ) {
            int n = s.length();
            int start = 0;
            int end = n-1;
            while(start <= end) {
                char l = s.charAt(start);
                char r = s.charAt(end);
                if( !isValid(l) ) {
                    start ++;
                } else if ( !isValid(r)) {
                    end --;
                } else if (isMatch(l,r)) {
                    start ++;
                    end --;
                } else {
                    ret = false;
                    //BUG: break
                    break;
                }
            }
        }
        return ret;
    }

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

    */
    public boolean isPalindrome(String s) {
        boolean ret = true;
        s = (null == s)?(""):(s);
        int n = s.length();
        int l = 0;
        int r = n-1;

        while( l < r ) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if (!Character.isLetterOrDigit(lc)) {
                l++;
            } else if (!Character.isLetterOrDigit(rc)) {
                r--;
            } else {
                lc = Character.toLowerCase(lc);
                rc = Character.toLowerCase(rc);
                if (lc != rc) {
                    ret = false;
                    break;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
        System.out.println(sol.isPalindrome("0P"));
    }
}