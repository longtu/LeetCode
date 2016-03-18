package wr.leetcode.algo.Facebook;

import java.util.Random;

public class RandomIndexedMax {

    int maxIndex(int[] nums) {
        //assumes input is not empty
        int max = nums[0];
        int count = 1;
        int ret = 0;
        Random random = new Random();

        for (int i = 1; i < nums.length; ++i) {
            int val = nums[i];
            if ( max < val) {
                ret = i;
                count = 1;
                max = val;
            } else if (max == val) {
                count ++;
                if(0 == random.nextInt(count)) {
                    ret = i;
                }
            }
        }
        return ret;
    }


}
