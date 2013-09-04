public class Solution {
    	    public String longestPalindrome(String s) {
	        if(s == null || s.isEmpty())
	            return "";
	        if(s.length() == 1)
	            return s;
	
	        int len = s.length();
	        boolean [] prev_down = new boolean[len];
	        boolean [] down = new boolean[len];
	
	        int max_len  = 1;
	        int start = 0;
	        int end = 0;
	
	        for(int i = len-1; i>=0; --i){
	            for(int j = i; j<len;++j){
	                if(i == j){
	                    down[j] = true;
	                    continue;
	                }
	                if(j == i+1){
	                    down[j] = (s.charAt(i) == s.charAt(j));
	                    continue;
	                }
	                down[j] = prev_down[j-1] && (s.charAt(i) == s.charAt(j));
	            }
	            for(int k =i; k<len;++k){
	                prev_down[k] = down[k];
	                if(prev_down[k] == true && k-i+1 > max_len){
	                    max_len = k-i+1;
	                    start = i;
	                    end = k;
	                }
	            }
	        }
	        return s.substring(start, end+1);
	    }
}
