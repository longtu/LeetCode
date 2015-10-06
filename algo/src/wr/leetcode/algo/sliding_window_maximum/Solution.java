package wr.leetcode.algo.sliding_window_maximum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {

        //TODO: check input of k

        if( null == nums || nums.length < k) {
            return new int[0];
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (a,b)->(b-a)
        );
        List<Integer> maxs = new LinkedList<>();
        for ( int i = 0; i < nums.length; ++i) {
            heap.add(nums[i]);
            if(i >= k-1) {
                maxs.add(heap.peek());
                heap.remove(nums[i-k+1]);
            }
        }

        int [] ret = new int[maxs.size()];
        int i = 0;
        for (int max : maxs) {
            ret[i++] = max;
        }
        return ret;
    }

    // Linear solution !!!
    public int[] maxSlidingWindow(int[] nums, int k) {

        //TODO: check input of k

        if( null == nums || nums.length < k) {
            return new int[0];
        }

        LinkedList<Integer> window = new LinkedList<>();
        int[] ret = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; ++i) {
            if( i >= k) {
                ret[i-k] = nums[window.peekFirst()];
                if (window.peekFirst() <= i-k) {
                    window.removeFirst();
                }
            }
            while(!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.removeLast();
            }
            window.addLast(i);
        }
        ret[nums.length-k] = nums[window.peekFirst()];
        return ret;
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(
                Arrays.toString(
                    sol.maxSlidingWindow(
                        arr, 3
                    )
                )
            );
    }
}
