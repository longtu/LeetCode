package wr.leetcode.algo.find_minimum_in_rotated_sorted_array;

public class Solution {

    public int findMin(int[] nums) {
        if( null == nums || 0 == nums.length ) {
            throw new IllegalStateException("Invalid input!");
        }
        int start = 0;
        int end = nums.length - 1;
        int found = -1;

        while( start <= end ) {
            if( nums[start] <= nums[end]) {
                found = nums[start];
                break;
            } else {
                int mid = start + ((end - start)>>1);
                int mv = nums[mid];
                int sv = nums[start];

                if(mv == sv) {
                    start = mid + 1;
                } else if (mv > sv) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return found;
    }



    /*
    public int findMin(int[] num) {
        if(null == num || num.length == 0) {
            throw new RuntimeException("Invalid Input!");
        }

        int start = 0;
        int end = num.length - 1;
        int ret = start;

        while(start <= end) {
            if(num[start] < num[end] || start == end) {
                ret = start;
                break;
            } else { //A[start] > A[end]
                int mid = start +((end-start)>>1);
                if(num[start] <= num[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }
        return num[ret];
    }
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {4,5,6,7,0,1,2};
        int[] b = {1,2,3,4,5,6,7};
        int[] c = {2,3,4,5,6,7,1};
        int[] d = {1};
        System.out.println(sol.findMin(arr));
        System.out.println(sol.findMin(b));
        System.out.println(sol.findMin(c));
        System.out.println(sol.findMin(d));

    }
}
