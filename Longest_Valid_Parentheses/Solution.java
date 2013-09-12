public class Solution {
	    class Record{
            //When you propose a compound structure, think about
            //whether all of the information is needed here or not
            //val here is actually not being used at all
	        public int index;
	        public char val;
	        public Record(int index, char val){
	            this.index = index;
	            this.val = val;
	        }
	    }
	    public int longestValidParentheses(String s) {
	        if(s == null || s.length() == 0)
	            return 0;

	        char [] arr = s.toCharArray();
	        int [] flag = new int[arr.length];
	        Stack<Record> stack = new Stack<Record>();

	        for( int i = 0; i < arr.length; ++i){
	            if(arr[i] == '('){
	                stack.push(new Record(i, arr[i]));
	            }
	            else{
                    //peek will throw stack empty exception
	                if(stack.isEmpty()){
	                    continue;
	                }
	                Record top = stack.pop();
	                flag [i] = 1;
	                flag [top.index] = 1;
	            }
	        }

	        int start = 0, end = 0; 
	        int max = 0;
	        while(end < flag.length){
	            while(end < flag.length && flag[end] == 0){
	                end++;
	                start++;
	            }
	            while(end < flag.length && flag[end] == 1){
	                end++;
	            }
	            int dist = (end - start);
	            if(dist > max)
	                max = dist;
	            start = end;
	        }
	        return max;
	    }

	}
}
//another way is to:
public int longestValidParentheses(String s) {
    int maxLen = 0, last = -1;
    Stack<Integer> lefts = new Stack<Integer>();
    for (int i=0; i<s.length(); ++i) {
        if (s.charAt(i)=='(') {
            lefts.push(i);
        } else {
            if (lefts.isEmpty()) {
                // no matching left
                last = i;
            } else {
                // find a matching pair
                lefts.pop();
                if (lefts.isEmpty()) {
                    maxLen = Math.max(maxLen, i-last);
                } else {
                    maxLen = Math.max(maxLen, i-lefts.peek());
                }
            }
        }
    }
    return maxLen;
}
