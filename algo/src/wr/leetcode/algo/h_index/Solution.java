package wr.leetcode.algo.h_index;


import java.util.Arrays;

public class Solution {

    public int hIndex(int[] cita) {
        int ret = 0;
        if( null != cita && cita.length > 0) {
            Arrays.sort(cita);
            int n = cita.length;
            int start = 0;
            int end = n;
            int found = -1;
            while(start <= end) {
                int mid = start + ((end - start) >> 1);
                if( 0 == mid ) { //mid == 0
                    if(0 == cita [n-1]) {
                        found = mid;
                    }
                    start = mid + 1;
                } else if( cita[n-mid] - mid >= 0) { //mid >=1 && mid <= n
                    if( mid == n) {
                        found = mid;
                        break;
                    } else { // mid > 0 && mid < n
                        if(cita[n-mid-1] - mid <= 0) {
                            found = mid;
                        }
                        start = mid + 1;
                    }
                } else {
                    end = mid - 1;
                }
            }
            ret = found;
        }
        return ret;
    }



    public static void main(String[] args) {

        int[] arr = {3,0,6,1,5};
        Solution sol = new Solution();
        System.out.println(sol.hIndex(arr));
    }

        public int hIndex0(int[] citations) {
        if (null == citations) {
            citations = new int[0];
        }

        int N = citations.length;

        int[] count = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if(citations[i] >= N) {
                count[N] += 1;
            } else {
                count[citations[i]] += 1;
            }
        }

        int sum = 0;
        int ret = 0;
        for (int i = N; i >= 0; --i) {
            sum += count[i];
            if(sum >= i) {
                ret = i;
                break;
            }
        }
        return ret;
    }

}
