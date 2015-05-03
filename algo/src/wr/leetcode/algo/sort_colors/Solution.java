package wr.leetcode.algo.sort_colors;

public class Solution {
    public void sortColors(int[] A) {
        if( null == A ) {
        	return;
        }

        int next = 0;
        int lastZero = -1;
        int end = A.length - 1;

        while(next <= end) {
        	if(A[next] == 1) {
                next++;
            } else if (A[next] == 0) {
                lastZero += 1;
                swap(A, lastZero, next);
                next++;
        	} else {
        		swap(A, next, end--);
        	}
        }
    }

    private void swap(int [] A, int src, int dest) {
    	int tmp = A[src];
    	A[src] = A[dest];
    	A[dest] = tmp;
    }
}