package wr.leetcode.algo.search_for_a_range;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {

        return new int[] {
                search(nums, target, true),
                search(nums, target, false)
        };
    }

    public int search(int [] nums, int target, boolean left) {
        int start = 0;
        int end = nums.length - 1;
        int found = -1;

        while( start <= end ) {
            int mid = start + ((end-start)>>1);
            int val = nums[mid];
            if (val == target) {
                found = mid;
                if (left) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (val < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return found;
    }

    /*
    public int[] searchRange(int[] nums, int target) {
        int [] ans = {searchRange(nums, target, true), searchRange(nums, target, false)};
        return ans;
    }

    public int searchRange(int[] nums, int target, boolean isLeft) {
        if (null == nums) {
            nums = new int[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int found = -1;
        while( start <= end ) {
            int mid = start + ((end - start) >> 1);
            int mv = nums[mid];
            if(mv == target) {
                found = mid;
                if(isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mv > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return found;
    }

    /*
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
    */

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
