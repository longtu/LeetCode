package wr.leetcode.algo.maximum_size_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    //Method2: O(N) space, O(N) time
    public int maxSubArrayLen(int[] nums, int k) {

        nums = (null == nums)?(new int[0]):(nums);
        Map<Long, List<Integer>> index = new HashMap<>();

        int n = nums.length;
        long[] sum = new long[n+1];
        for (int i = 0; i <= n; ++i) {
            sum[i] = (i > 0)?(sum[i-1] + nums[i-1]):(0l);
            List<Integer> indexes = index.getOrDefault(sum[i], new LinkedList<>());
            indexes.add(0, i);
            index.put(sum[i], indexes);
        }

        int ret = 0;
        for (int i = 0; i <=n; ++i) {
            long target = sum[i] + k;
            if(index.containsKey(target)) {
                int j = index.get(target).get(0);
                if( j - i > ret) {
                    ret = j-i;
                }
            }
        }
        return ret;
    }

    //Method1: O(N) space, O(N^2) time
    public int maxSubArrayLen1(int[] nums, int k) {
        if (null == nums) {
            nums = new int[0];
        }
        int n = nums.length;
        long [] sum = new long[n+1];
        long s = 0;
        for (int i = 0; i <= n; ++i) {
            sum[i] = s;
            if( i < n) {
                s += nums[i];
            }
        }

        int ret = 0;
        int l = n;
        while( l > 0 && ret == 0) {
            for (int i = 0; i+l <= n; ++i) {
                if (sum[i+l] - sum[i] == k) {
                    ret = l;
                    break;
                }
            }
            l--;
        }

        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
        System.out.println(sol.maxSubArrayLen(new int[]{-2, -1, 2, 1}, 1));

    }
}
