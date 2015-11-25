package wr.leetcode.algo.search_in_rotated_sorted_array_ii;

public class Solution {



    public boolean search(int[] nums, int target) {

        int start = 0;
        int end = nums.length- 1;
        boolean ret = false;
        while(start <= end) {
            int mid = start + ((end-start)>>1);
            int mV = nums[mid];
            int sV = nums[start];
            int eV = nums[end];

            if( mV == target ) {
                ret = true;
                break;
            } else if ( sV == mV ) {
                start ++;
            } else if ( sV < mV) {
                if( target >= sV && target < mV) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if( target <= eV && target > mV) {
                    start = mid + 1;
                } else {
                    end = mid -1;
                }
            }
        }
        return ret;
    }



    /*
    public boolean search(int[] A, int target) {
        int find = -1;
        if(A == null)
            return false;
        int start = 0;
        int end = A.length-1;
        while(start<=end){
            int mid = start + ((end-start)>>1);
            if(A[mid] == target)
                return true;
            if(A[start] < A[mid]){
                if(target >=A[start] && target < A[mid])
                    end = mid-1;
                else
                    start = mid+1;
            }
            else if (A[start] > A[mid]){
                if(target > A[mid] && target <=A[end])
                    start = mid+1;
                else
                    end = mid-1;
            } else start ++;
        }
        return false;
    }
    */
}