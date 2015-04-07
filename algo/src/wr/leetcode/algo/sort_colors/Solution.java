package wr.leetcode.algo.sort_colors;

public class Solution {
    public void sortColors(int[] A) {
        if( null == A ) {
        	return;
        }

        int next = 0;
        int firstOne = -1;
        int end = A.length - 1;

        while(next <= end) {
        	if(A[next] == 1) {
        		if(firstOne == -1) {
        			firstOne = next;
        		}
        		next++;
        	} else if (A[next] == 0) {
        		if(firstOne != -1){
        			swap(A, next, firstOne);
        			firstOne +=1;
        		}
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