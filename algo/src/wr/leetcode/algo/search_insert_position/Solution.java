package wr.leetcode.algo.search_insert_position;

public class Solution {



    public int searchInsert(int[] nums, int target) {
        //first index with value >= key
        if (null == nums) {
            nums = new int[0];
        }

        int start = 0;
        int end = nums.length - 1;
        int found = -1;
        while( start <= end ) {
            int mid = start  + ((end - start) >> 1);
            int mv = nums[mid];

            if(mv == target) {
                found = mid;
                break;
            } else if ( mv > target) {
                found = mid;
                end = mid - 1;
            } else {    //mv < target
                start = mid + 1;
            }

        }
        return (found == -1)? (nums.length):(found);
    }




    /*
    public int searchInsert(int[] A, int target) {
        if (null == A) {
            A = new int[0];
        }
        int start = 0;
        int end = A.length-1;
        int ret = -1;
        while(start <= end){
            int mid = start + ((end - start)>>1);
            if(A[mid] == target) {
                ret = mid;
                break;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return (ret == -1)?(start):(ret);
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,3,5,6};
        System.out.println(sol.searchInsert(arr, 5));
        System.out.println(sol.searchInsert(arr, 2));
        System.out.println(sol.searchInsert(arr, 7));
        System.out.println(sol.searchInsert(arr, 0));
    }
}
