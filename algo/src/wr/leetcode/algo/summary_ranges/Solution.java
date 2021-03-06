package wr.leetcode.algo.summary_ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<>();

        if( null != nums && nums.length > 0 ) {
            int n = nums.length;
            Integer start = null;
            for (int i = 0; i <= n; ++i) {
                if(n == i) {
                    String str = (start.equals(nums[i-1])) ?
                            (Integer.toString(start)) : (String.format("%s->%s", start, nums[i-1]));
                    ret.add(str);
                } else {
                    int val = nums[i];
                    if( null == start ) {
                        start = val;
                    } else if (val != nums[i-1] + 1 ) {
                        String str = (start.equals(nums[i-1])) ?
                            (Integer.toString(start)) : (String.format("%s->%s", start, nums[i-1]));
                        ret.add(str);
                        start = val;
                    }
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.summaryRanges(new int[] {0,1,2,4,5,7}));
    }
        /*
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<>();

        if(null != nums && 0 != nums.length) {
            Integer start = null;
            for (int i = 0; i <= nums.length; ++i) {
                if(start == null){
                    start = nums[i];
                    continue;
                } else if ( i == nums.length || nums[i] != nums[i-1] + 1) {
                    String str = start + "->" + nums[i-1];
                    if(start.equals(nums[i-1])) {
                        str = start.toString();
                    }
                    ret.add(str);
                    if( i < nums.length) {
                        start = nums[i];
                    }
                }
            }
        }
        return ret;
    }*/
}
