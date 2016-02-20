package wr.leetcode.algo.kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

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

    public int findKthLargestUsingHeap(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((a,b)->(a-b));
        for (int n : nums) {
            if ( heap.size() < k || heap.peek() < n) {
                heap.offer(n);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        int p = 0;
        int pv = nums[p];
        int b = p;
        int n = nums.length;
        int ret = pv;

        for (int i = 1; i < n; ++i) {
            int v = nums[i];
            if (v > pv) { // bigger
                b++;
                swap(nums, b, i);
            }
        }
        swap(nums, p, b);

        if (b + 1 == k) {
            return pv;
        } else if (b + 1 > k) {
            return findKthLargest(Arrays.copyOfRange(nums, 0, b), k);
        } else {
            return findKthLargest(Arrays.copyOfRange(nums, b+1, n), k - b - 1);
        }
    }

    private void swap(int [] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {3,2,1,5,6,4};
        for (int i = 1; i <=6; ++i) {
            System.out.println(sol.findKthLargest(arr, i));
        }

    }
}
