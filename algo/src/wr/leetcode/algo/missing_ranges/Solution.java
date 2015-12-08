package wr.leetcode.algo.missing_ranges;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if( null == nums ) {
            nums = new int[0];
        }
        List<int[]> ret = new LinkedList<>();
        ArrayList<int[]> ranges = ranges(nums);

        //GOOD: catch for ranges is empty
        if(ranges.isEmpty()) {
            ret.add(range(lower, upper));
        } else {
            int n = ranges.size();
            for (int i = 0; i < n; ++i) {
                int[] r = ranges.get(i);
                //GOOD: catch for boundary i == 0 || i == n-1
                if(0 == i && lower < r[0]) {
                    ret.add(range(lower, r[0]-1));
                }

                if(i > 0) {
                    ret.add(range( ranges.get(i-1)[1]+1,
                            r[0]-1 ));
                }
                //BUG: n == i !!
                if(n-1 == i && r[1] < upper) {
                    ret.add(range(r[1]+1, upper));
                }
            }
        }
        return ret.stream()
                    .map( this :: rangeStr)
                    .collect(Collectors.toList());
    }


    private int[] range(int l, int h) {
        int[] range = new int[2];
        range[0] = l;
        range[1] = h;
        return range;
    }


    public ArrayList<int[]> ranges(int [] nums ) {
        ArrayList<int[]> ranges = new ArrayList<>();
        int n = nums.length;
        int left = 0;
        for (int i = 1; i <= n; ++i) {
            //GOOD: catch for nums[i] == nums[i-1]
            if( n ==i || (nums[i] != nums[i-1] + 1 && nums[i] != nums[i-1])) {
                ranges.add( range(nums[left], nums[i-1]));
                left = i;
            }
        }
        return ranges;
    }

    private String rangeStr ( int[] range ) {
        return  (range[0] == range[1])? ( String.format("%d", range[0]))
                     :( String.format("%d->%d", range[0], range[1]));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {0, 1, 3, 50, 75};
        System.out.println(sol.findMissingRanges(arr, 0, 99));
    }
}
