    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
            return 0;

        char [] arr = s.toCharArray();
        int count  = 0;
        int max = 0;
        for( int start = 0, end = 0; end < arr.length; end++){
            if(arr[end] == '('){
                --count; 
            }
            else{
                ++count;
            }
            if(count<=0){
                //this always needs to be updated
                max = (end+1-start+count > max)?(end+1-start+count):(max);
            }
            else{
                while(end<arr.length && arr[end] == ')')
                    ++end;
                count = 0;
                start = end;
                //this is very easy to forget
                end--;
            }
        }
        return max;
    }
