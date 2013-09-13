public class Solution {

    public int reverse(int x){
        int r = 0;
        while(x != 0) {
            //Keep in mid this might get overflow
            if((Integer.MAX_VALUE - x%10)/10 < r)
                throw new IllegalArgumentException("Error input");
            r = r*10 + x % 10;
            x /= 10;
        }
        return r;
    }

    public static void main(String[] args){
        System.out.println(new Solution().reverse(1000000003));
        System.out.println(Integer.MAX_VALUE);
    }

}
