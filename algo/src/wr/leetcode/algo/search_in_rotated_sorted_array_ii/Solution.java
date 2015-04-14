package wr.leetcode.algo.search_in_rotated_sorted_array_ii;

public class Solution {
    public boolean search(int[] A, int target) {
        if(null == A) {
            A = new int[0];
        }
        int start = 0;
        int end = A.length -1;
        boolean ret = false;

        while (start <= end){
            int mid = start + ((end-start)<<1);
            if(A[mid] == target) {
                ret = true;
            } else if (A[mid] >= A[start]) {
                if(target < A[mid] && target >= A[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > A[mid] && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ret;
    }
}
