package wr.leetcode.algo.rotate_array;

import java.util.Arrays;

public class Solution {

    public void rotate(int[] nums, int k) {
        if( null == nums || 0 == nums.length ) {
            return;
        }
        int n = nums.length;
        k = k%n;
        k = (k+n)%n; //k will be non-nagative

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public void reverse (int[] nums, int start, int end) {
        while( start < end ) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }


    /*
    public void rotate(int[] nums, int k) {

        if(nums == null || nums.length == 0) {
            return;
        }
        k = k%nums.length;
        if(k == 0) {
            return;
        }
        int n = nums.length;
        //let's assume k is always positive or 0
        reverse(nums, 0, n-k-1 );
        reverse(nums, n-k, n-1 );
        reverse(nums, 0, n-1);
    }

    public void reverse(int [] arr, int left, int right){
        while(left < right){
            int tmp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = tmp;
        }
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1,2,3,4,5,6,7};
        sol.rotate(arr, 3);

        System.out.println(Arrays.toString(arr));

    }

}
