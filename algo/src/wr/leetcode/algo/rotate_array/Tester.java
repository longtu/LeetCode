package wr.leetcode.algo.rotate_array;

import java.util.Arrays;

/**
 * Created by wangran on 3/16/15.
 */
public class Tester {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] arr = {1,2,3,4,5,6,7};
        solution.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));

    }
}
