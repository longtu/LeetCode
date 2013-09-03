public class Solution {
	    public int numDecodings(String s) {
	        if(s == null)
	            return 0;
	        return getDecodingWays(s, s.length());
	        
	    }

	    private int getDecodingWays(String s, int index)
	    {
	        int pre = 0;
	        int prepre = 0;
	        int res = 0;

	        for(int i = 0; i<= index; i++){
	        	res = 0;
	            if(i==0){
	            	pre = 1;
	                continue;
	            }
	            if(i==1){
	                if(s.charAt(i-1) != '0')
	                res = res +pre;
	                pre = res;
	                prepre = 1;
	                continue;
	            }
	            else{
	                if(s.charAt(i-2)=='1' || (s.charAt(i-2)=='2' &&(s.charAt(i-1)>='0' && s.charAt(i-1) <='6')))
	                    res = res+prepre;
	                if(s.charAt(i-1) != '0')
	                	res = res +pre;
	                prepre = pre;
	                pre = res;
	            }
	        }
	        return res;
	    }
}
