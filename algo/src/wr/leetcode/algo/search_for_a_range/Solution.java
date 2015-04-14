package wr.leetcode.algo.search_for_a_range;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int [] ret = {searchRangeLeft(A, target),searchRangeRight(A, target)};
        return ret;
    }

    public int searchRangeLeft(int[] A, int target) {
        if(null == A) {
            A = new int[0];
        }
        int start = 0;
        int end = A.length - 1;
        boolean found = false;
        while(start <= end) {
            int mid = start + ((end-start)>>1);
            if(target == A[mid]) {
                found = true;
                end = mid-1;
            } else if( target > A[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (found)?(end+1):(-1);
    }
    public int searchRangeRight(int[] A, int target) {
        if(null == A) {
            A = new int[0];
        }
        int start = 0;
        int end = A.length - 1;
        boolean found = false;
        while(start <= end) {
            int mid = start + ((end-start)>>1);
            if(target == A[mid]) {
                found = true;
                start = mid+1;
            } else if( target > A[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (found)?(start-1):(-1);
    }

    public static void main(String[] args) {
        int [] arr = {5, 7, 7, 8, 8, 10};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.searchRange(arr, 5)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 7)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 8)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 10)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 1)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 6)));
        System.out.println(Arrays.toString(sol.searchRange(arr, 11)));
    }

}
