package wr.leetcode.algo.kth_largest_element_in_an_array;

import wr.leetcode.algo.Facebook.RandomListSorted;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class Solution {
/*
    public int findKthLargest(int[] nums, int k) {
        int ret = -1;
        if(null == nums || nums.length == 0) {
            return ret;
        }

        int pivot = 0;
        for(int i = 1; i < nums.length; ++i) {
            if(nums[pivot] <= nums[i]) {
                swap(nums, pivot, i);
                swap(nums, i, pivot+1);
                pivot++;
            }
        }

        if(pivot+1 > k) {
            ret = findKthLargest( Arrays.copyOfRange(nums, 0, pivot),k);
        } else if (pivot+1 < k) {
            ret = findKthLargest( Arrays.copyOfRange(nums, pivot + 1, nums.length), k - pivot - 1);
        } else {
            ret = nums[pivot];
        }
        return ret;
    }
*/
    /*
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < nums.length; ++i) {
            int val = nums[i];
            if( i < k){
                q.add(val);
            } else if ( val > q.peek()) {
                q.add(val);
                q.remove();
            }
        }
        return q.remove();
    }

    public void swap(int[] arr, int lhs, int rhs){
        int tmp = arr[lhs];
        arr[lhs] = arr [rhs];
        arr[rhs] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        int pivot = 0;
        for (int i = 1; i < nums.length; ++i) {
            int v = nums[i];
            if (v >= nums[pivot]) {
                swap(nums, i, pivot++);
                swap(nums, i, pivot);
            }
        }
        if( k == pivot +1) {
            return nums[pivot];
        } else if( k > pivot + 1) {
            return findKthLargest( Arrays.copyOfRange(nums, pivot+1,nums.length),k - pivot - 1);
        } else {
            return findKthLargest( Arrays.copyOfRange(nums, 0, pivot), k);
        }
    }*/
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, k, 0, nums.length);
    }


    public int findKthLargest(int[] nums, int k, int start, int end) {
        int rand = new Random().nextInt(end-start);
        swap(nums, rand+start, start);
        int p = start;
        int pv = nums[start];
        for (int i = start+1; i < end; ++i) {
            if(nums[i] > pv) {
                swap(nums, ++p, i);
            }
        }
        swap(nums, p, 0);
        if (p+1 == k) {
            return pv;
        } else if (p+1 < k) {
            return findKthLargest(Arrays.copyOfRange(nums,p + 1, nums.length), k - p - 1);
        } else {
            return findKthLargest(Arrays.copyOfRange(nums, 0, p), k);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {3,2,1,5,6,4};
        for (int i = 1; i <=6; ++i) {
            System.out.println(sol.findKthLargest(arr, i));
        }

    }
}
