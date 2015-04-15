package wr.leetcode.algo.sqrtx;

public class Solution {
    public int mySqrt(int x) {
        if(x < 0) {
            throw new RuntimeException("Invalid Input");
        }
        int start = 0;
        int end = x;
        int ret = x;
        while(x > 1 && start <= end) {
            int mid = start +((end-start)>>1);
            int right = (mid+1)*(mid+1);
            if(mid*mid <= x && right >x){
                ret = mid;
                break;
            } else if(mid*mid > x){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for(int i = 0; i < 101; ++i) {
            System.out.println(i+ ":" + sol.mySqrt(i));
        }
    }


}