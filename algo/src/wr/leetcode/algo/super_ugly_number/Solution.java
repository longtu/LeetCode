package wr.leetcode.algo.super_ugly_number;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        int k = primes.length;
        int [] index = new int[k];
        int [] vals = new int[n];

        vals[0] = 1;

        //be careful about not to skip the empty spots
        for (int i = 1; i < n;) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            for (int j = 0; j < k; ++j) {
                int v = vals[index[j]] * primes[j];
                if( v < minValue ) {
                    minValue = v;
                    minIndex = j;
                }
            }
            //BUG: there might be duplicates
            if(minValue != vals[i-1]) {
                vals[i++] = minValue;
            } else {
                index[minIndex] += 1;
            }
        }
        return vals[n-1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] primes = {2, 7, 13, 19};
        for (int i = 1; i < 13; ++i) {
            System.out.println(sol.nthSuperUglyNumber(i, primes));
        }
    }
}
