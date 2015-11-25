package wr.leetcode.algo.find_the_duplicate_number;

import java.util.Arrays;

public class Solution {
    /*
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length;
        int found = -1;

        while(start <= end) {
            int mid = (start + end)/2;
            if( countLET(nums, mid) - mid < 0 ||
                    (countLET(nums, mid) - mid == 0 && mid !=nums.length)) {
                //equal number, found >= mid + 1
                start = mid + 1;
            } else if( mid == 1 || (countLET(nums, mid-1) - (mid-1) <=0)) {
                found = mid;
                break;
            } else {
                end = mid - 1;
            }
        }
        if(found == -1) {
            throw new IllegalStateException("ERROR state!");
        }
        return found;

    }

    public int countLET(int[] nums, int ceiling) {
        return (int) Arrays.stream(nums)
                .filter( (x)->(x <= ceiling))
                .count();
    }
    */


    public int findDuplicate(int[] nums) {
        if(null == nums || nums.length < 2) {
            throw new IllegalStateException("Invalid Input");
        }
        int n = nums.length;
        int start = 1;
        int end = n-1;
        int found = -1;
        while(start <= end) {
            int mid = start + ( (end - start) >> 1);
            int mv = countLE(mid, nums);
            if( mv > mid ) {
                if (mid == 1 || countLE(mid-1, nums) <= mid - 1) {
                    found = mid;
                    break;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return found;
    }

    public int countLE(int key, int [] nums) {
        return  (int) Arrays.stream(nums)
                    .filter((a) -> (a <= key))
                    .count();
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int [][] arr = {
                {1,2,3,3,5},
                {1,2,2,2,5},
                {1,1,1,1,5},
                {4,4,4,4,4},
                {1,1,1,1,1},
                {5,5,5,5,5},
        };

        for(int[] ar : arr) {
            System.out.println(sol.findDuplicate(ar));
        }

    }
}
