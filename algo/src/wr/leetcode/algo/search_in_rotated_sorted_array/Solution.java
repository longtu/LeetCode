package wr.leetcode.algo.search_in_rotated_sorted_array;

public class Solution {
    /*
    public int search(int[] A, int target) {
        if(null == A) {
            A = new int[0];
        }

        int start = 0;
        int end = A.length - 1;
        int ret = -1;
        while(start <= end) {
            int mid = start + ((end-start)>>1);
            if(A[mid] == target) {
                ret = mid;
                break;
            } else if (A[mid] >= A[start]) {
                if(target < A[mid] && target >= A[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target > A[mid] && target <= A[end]) {
                    start = mid +1;
                } else {
                    end = mid -1;
                }
            }
        }
        return ret;
    }*/

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1 ;
        int found = -1;
        while(start <= end) {
            int mid = start + ((end - start) >> 1);
            int val = nums[mid];
            int sV = nums[start];
            int eV = nums[end];

            if( val == target ) {
                found = mid;
                break;
            } else if ( val >= sV ) {
                if(target >= sV && target < val) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if( target > val && target <= eV) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return found;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(sol.search(arr, 4));
        System.out.println(sol.search(arr, 5));
        System.out.println(sol.search(arr, 6));
        System.out.println(sol.search(arr, 7));
        System.out.println(sol.search(arr, 0));
        System.out.println(sol.search(arr, 1));
        System.out.println(sol.search(arr, 2));
        System.out.println(sol.search(arr, -2));
        System.out.println(sol.search(arr, 12));

        int [] b = {3,1};
        System.out.println(sol.search(b, 3));
        System.out.println(sol.search(b, 1));
        System.out.println(sol.search(b, -1));
        System.out.println(sol.search(b, 12));


    }
}
