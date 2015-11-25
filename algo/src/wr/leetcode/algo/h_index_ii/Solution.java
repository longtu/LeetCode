package wr.leetcode.algo.h_index_ii;

public class Solution {

    /*
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
    }*/

    public int hIndex(int[] c) {

        if(null == c) {
            c = new int[0];
        }

        int n = c.length;

        // all different values of h
        int start = 0;
        int end = n;
        int found = -1;

        while(start <= end) {
            int mid = start + ((end-start) >> 1);
            if(0 == mid) {
                //0 is a special case
                if(n > 0 && c[0] == 0) { //BUG: what if input array is empty?
                    found = 0;
                }
                start = mid + 1;
            } else {
                // f(h) = c[n - h] - h  is a decreasing function,
                // find the max(x) such that f(h) >= 0 and f(h+1) <= -1
                // c[n-n] - h >= 0 && c[n-h-1] - h <= 0
                // mid >=1 && mid <=n
                int mv = c[n - mid] - mid;
                if(mv < 0 ) {
                    end = mid - 1;
                } else { //mv >=0
                    if(mid == n){
                        found = n;
                        break;
                    } else {
                        int ev = c[n - mid - 1] - mid;
                        if(ev <= 0) {
                            found = mid;
                        }
                        start = mid + 1;
                    }
                }
            }
        }
        return (-1 == found) ? (n): (found);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = {
                {0,0,4,4},
                {0,1,3,5,6},
                {0},
                {1},
                {0,1},
                {5,5,5},
                {}
            };
        for (int[] ar : arr)
            System.out.println(sol.hIndex(ar));
    }
}
