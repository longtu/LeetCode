package wr.leetcode.algo.rotate_array;
public class Solution {
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
    }

}
