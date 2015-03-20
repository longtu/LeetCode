package wr.leetcode.algo.maximum_product_subarray;

public class Solution {
    public int maxProduct(int[] A) {

        if(A == null || A.length == 0) {
            return 0;
        }

        int [] global = new int[2];
        int [] lmax = new int[2];
        int [] lmin = new int[2];

        global[0] = A[0];
        lmax[0] = A[0];
        lmin[0] = A[0];

        for ( int i = 1; i < A.length; ++i) {
            lmin[i%2] = Math.min(A[i], Math.min( lmin[(i-1)%2]*A[i], lmax[(i-1)%2]*A[i] ));
            lmax[i%2] = Math.max(A[i], Math.max( lmin[(i-1)%2]*A[i], lmax[(i-1)%2]*A[i] ));
            global[i%2] = Math.max(global[(i-1)%2], lmax[i%2]);
        }

        return global[(A.length-1)%2];
    }

}
