package wr.leetcode.algo.Facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
 Examples:
 Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 Ouptut: Sum found between indexes 2 and 4

 Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 Ouptut: Sum found between indexes 1 and 4

 Input: arr[] = {1, 4}, sum = 0
 Output: No subarray found
 */


public class SubArraySum {

    // input not null
    // target not negative
    public static int[] findRange( int[] nums, int target ) {

        int sum = 0;
        int j = -1;
        int[] ret = null;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            //j < i to make sure if target is 0, no zero element sub array
            while( sum >= target && j < i ) {
                if( sum == target ) {
                    ret = new int[2];
                    ret[0] = j+1;
                    ret[1] = i;
                }
                sum -= nums[++j];
            }
        }
        return ret;
    }


    // input not null
    // target not negative
    // input may contains negatives
    public static int[] findRangeWithNeg(int[] nums, int target) {
        int[] ret = null;
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            int val = nums[i];
            sum += val;
            if ( index.containsKey(sum - target)) {
                ret = new int[2];
                ret[0] = index.get(sum - target ) + 1;
                ret[1] = i;
            }
            if( !index.containsKey(sum)) {
                index.put(sum, i);
            }
        }
        return ret;
    }

    //assume input nums is never empty/null
    public static int longestSubArrayWithSum( int[] nums, int target ) {

        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);

        int sum = 0;
        int max = -1;
        for (int i = 0; i < nums.length; ++i) {
            int val = nums[i];
            sum += val;
            if ( index.containsKey(sum - target)) {
                int len = i - index.get(sum - target);
                max = Math.max(max, len);
            }
            if( !index.containsKey(sum)) {
                index.put(sum, i);
            }
        }
        return max;
    }


    //assume input nums is never empty/null
    public static int shortestSubArrayWithSum( int[] nums, int target ) {

        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            int val = nums[i];
            sum += val;
            if ( index.containsKey(sum - target)) {
                int len = i - index.get(sum - target);
                min = Math.min(min, len);
            }
            index.put(sum, i);
        }
        return (min == Integer.MAX_VALUE)?(-1):(min);
    }


    public static void main(String[] args) {

        for (int [][] arr : new int[][][]{
                {{1, 4, 20, 3, 10, 5}, {33}},
                {{1, 4, 0, 0, 3, 10, 5}, {7}},
                {{1, 4}, {0}}
        }) {
            int[] sol = SubArraySum.findRange(arr[0], arr[1][0]);
            if(null == sol ){
                System.out.println("No subArrayFound");
            } else {
                System.out.println(String.format("%s, %s", sol[0], sol[1]));
            }
        }

        System.out.println("---");

        for (int [][] arr : new int[][][]{
                {{1, 4, 20, 3, 10, 5}, {33}},
                {{1, 4, 0, 0, 3, 10, 5}, {7}},
                {{1, 4}, {0}},
                {{1,2,-3,4,-9,6},{-8}},
                {{1,-2,-6,2,-3,4,-9,6},{-8}},
                {{1, 4, 0, 0, 3, 10, 5}, {0}},

        }) {
            int[] sol = SubArraySum.findRangeWithNeg(arr[0], arr[1][0]);
            if(null == sol ){
                System.out.println("No subArrayFound");
            } else {
                System.out.println(String.format("%s, %s", sol[0], sol[1]));
            }
            System.out.println("LongestSubArr: " + SubArraySum.longestSubArrayWithSum(arr[0], arr[1][0]));
            System.out.println("ShortestSubArr: " + SubArraySum.shortestSubArrayWithSum(arr[0], arr[1][0]));
        }
    }
}
