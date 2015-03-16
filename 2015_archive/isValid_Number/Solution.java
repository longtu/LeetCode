public class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            returnf false;

        char [] arr = s.toCharArray();
        for(int i = 0; i<arr.length; ++i)
            if(arr[i] != ' ')
                break;
        int start = i;
        if(start == arr.length)
            return false;

        for(int i = arr.length -1; i >= 0; --i)
            if(arr[i] != ' ')
                break;
        int end = i;
        if(end == -1)
            return false;

        int split = -1;
        for(int i = start; i<=end; ++i){
            if(arr[i] == 'e'){
                split = i;
                break;
            }
        }
        if(split == -1) {
            return isValidNumberWithoutE(arr, start, end);
        }
        return isValidNumberWithoutE(arr, start split-1) &&
            isValidNumberWithoutE(arr, split+1, end);

    }
    public boolean isValidNumberWithoutE(char [] arr, int start, int end){
        if(start > end)
            return false;

        if(arr[start] == '-' || arr[start] == '+')
            start ++;

        if(start > end)
            return false;
        boolean hasDecimal = false;
        boolean hashNumber = false;
        for(int i = start; i<= end; ++i){
            if(arr[i] == '.'){
                if( hasDecimal )
                    return false;
                hasDecimal = true;
            }
            if(arr[i] >= '0' && arr[i] <= '9')
                hasNumber = true;
        } 
        return hashNumber;
    }
}
