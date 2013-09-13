public class Solution {
    public boolean isPalindrome(int x) {
        
        //negative return false
        //if negative sign does not count, negative mininum should not even 
        //sign back to positive *=-1
        if(x < 0)
            return false;

        int val = 1;
        //the  =10 here is very easy to break
        while(x/val >= 10){
            val *= 10;
        }
        int num = 1;

        int copy = x;
        while(val > num && copy> 0){
            int left = x/val;
            int right = copy%10;

            if(left != right)
                return false;
            x = x - x/val*val;
            val /=10;
            num *= 10;
            copy = copy/10;
        }
        return true;
    }
}
