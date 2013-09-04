public class Solution {
    public boolean canJump(int[] A) {
	        if(null == A || 0 == A.length)
	            return true;
	        int i = 0;
	        int max = 0;
	        while(i <= max){
	            if(i == A.length-1)
	                return true;
                //A[i]+i !!!!!!!!! instead of A[i]
	            if(A[i]+i > max){
	                max = A[i]+i;
	            }
	            i++;
	        }
	        return false;
	        
	    }
        
        public int jump(int[] A) {
	    	if(A == null || A.length <2)
	    		return 0;
	    	int start = 0;
	    	int end = 1;
	    	int jump = 0;
	    	while(start < end){
	    		int nextStart = end;
	    		int  nextEnd = end;
	    		for (int i = start; i<end; ++i){
	    			if(i == A.length-1)
	    				return jump;
                    //i+A[i] +1 instead of i+A[i] !!!!!!!!!
	    			if(i+A[i]+1 > nextEnd)
	    				nextEnd = i+A[i]+1;
	    		}
    			++jump;
	    		start = nextStart;
	    		end=nextEnd;
	    	}
	    	return -1;
	    }
}
