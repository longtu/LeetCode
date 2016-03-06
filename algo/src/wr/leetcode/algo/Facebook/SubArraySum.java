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
    public static int[] findRange(int[] input, int target) {
        Integer sum = 0;
        int[] ret = null;

        int j = -1;
        for (int i = 0; i < input.length; ++i) {
            sum += input[i];
            while (sum > target) {
                sum -= input[++j];
            }
            //BUG: watch out for i >= j+ 1 here for valid subarray
            // at least one element
            if( sum == target && i >= j+1) {
                ret = new int[2];
                ret[0] = j+1;
                ret[1] = i;
                break;
            }
        }
        return ret;
    }


    // input not null
    // target not negative
    // input may contains negatives
    public static int[] findRangeWithNeg(int[] input, int target) {
        int sum = 0;
        int[] ret = null;
        Map<Integer, Integer> prefixSum = new HashMap<>();

        for (int i = 0; i < input.length; ++i) {
            sum += input[i];
            if (sum == target) {
                ret = new int[] {0, i};
            } else if (prefixSum.containsKey(sum)) {
                //BUG: value +1
                ret = new int[] {prefixSum.get(sum)+1, i};
                break;
            } else {
                prefixSum.put(sum + target, i);
            }
        }
        return ret;
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
                {{1,2,-3,4,-9,6},{-8}}
        }) {
            int[] sol = SubArraySum.findRangeWithNeg(arr[0], arr[1][0]);
            if(null == sol ){
                System.out.println("No subArrayFound");
            } else {
                System.out.println(String.format("%s, %s", sol[0], sol[1]));
            }
        }
    }
}
