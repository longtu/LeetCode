package wr.leetcode.algo.h_index_ii;

public class Solution {
    public int hIndex(int[] c) {
        if(null == c || 0 == c.length) {
            return 0;
        }
        //TODOTODO: understand why this is right?
        int N = c.length;
        int start = 0;
        int end = N;
        int found = -1;

        while(start <= end) {
            int mid = (start + end)/2;

            if( 0 == mid && c[N-mid-1] > mid){
                start = mid + 1;
            } else if( N == mid && c[N-mid] < mid){
                end = mid - 1;
            } else if(mid >0 && c[N-mid] < mid) {
                end = mid - 1;
            } else if(mid < N && c[N-mid-1] > mid){
                start = mid + 1;
            } else {
                found = mid;
                break;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {
                {0,1,3,5,6},
                {0},
                {1},
                {0,1}
            };
        for (int[] ar : arr)
            System.out.println(sol.hIndex(ar));
    }
}
