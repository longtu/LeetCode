package wr.leetcode.algo.sort_colors;

public class Solution {

    public void sortColors(int[] nums) {
        if( null != nums ) {
            int n = nums.length;
            int red = -1;  //lastRead
            int blue = n; //firstBlue

            int i = 0;
            while( i < blue) {
                int val = nums[i];
                if(0 == val) {
                    red ++ ;
                    swap(nums, i, red);
                    i++;
                } else if (1 == val) {
                    i++;
                } else { //2 == val
                    blue --;
                    swap(nums, i, blue);
                }
            }
        }
    }

    public void swap(int [] arr, int i, int j) {
        int tmp  = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
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
    }*/
}