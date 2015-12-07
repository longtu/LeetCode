package wr.leetcode.algo.count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new LinkedList<>();

        if( null != nums) {
            int n = nums.length;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = n-1; i >=0; --i) {
                int key = nums[i];
                int smaller = countSmaller(list, key);
                ret.add(0, smaller);
                list.add(smaller, key);
            }
        }
        return ret;
    }

    public int countSmaller( ArrayList<Integer> list, int key) {
        int start = 0;
        int end = list.size() - 1;
        int ret = -1;
        while( start <= end ) {
            //BUG: start + (end-start)>>1 - > start + ((end-start)>>1)
            int mid = start + ((end-start) >>1);
            int midV = list.get(mid);
            //BUG: key >= midV -> key <= midV
            if(key <= midV) {
                end = mid -1;
            } else { //key > midV
                ret = mid;
                start = mid + 1;
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {5, 2, 6, 1};
        System.out.println(sol.countSmaller(arr));
    }
}
