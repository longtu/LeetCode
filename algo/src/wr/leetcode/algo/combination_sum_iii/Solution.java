package wr.leetcode.algo.combination_sum_iii;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<>();
        if ( n > 0 && k > 0) {
            Set<List<Integer>> combinations = combinationSum(1, k, n);
            ret = new LinkedList<>(combinations);
        }
        return ret;
    }

    public Set<List<Integer>> combinationSum(int start, int k, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        if ( target == 0 && k == 0) {
            ret.add(new LinkedList<>());
        } else if (k > 0) {
            for (int i = start; i <= 9; ++i) {
                int sum = target - i;
                if (sum < 0) {
                    break;
                }
                Set<List<Integer>> combinations = combinationSum(i+1, k-1, sum);
                for (List<Integer> combination : combinations) {
                    combination.add(0, i);
                    ret.add(combination);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combinationSum3(3,2));
        System.out.println(sol.combinationSum3(3,7));
        System.out.println(sol.combinationSum3(3,9));
    }

    /*

        public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ret = new LinkedList<>();
        int [] nums = new int[9];
        for (int i = 1; i < 10; ++i) {
            //BUG: nums[i] = i;
            nums[i-1] = i;
        }

        if( k > 0 && n >= k) {
            ret = combinationSum3(k, n, nums);
        }
        return ret;
    }

    public List<List<Integer>> combinationSum3(int k, int n, int[] nums) {

        List<List<Integer>> ret = new LinkedList<>();
        if(n == 0 && k == 0) {
            ret.add(new LinkedList<>());
        } else if (nums.length >= k && k > 0) {
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i <= nums.length - k ; ++i) {
                int[] subArray = Arrays.copyOfRange(nums, i + 1, nums.length);
                set.addAll(combinationSum3(k, n, subArray));
                int val = nums[i];
                int nextN = n - val;
                if (nextN >= 0) {
                    List<List<Integer>> subs = combinationSum3(k-1, nextN, subArray);
                    for (List<Integer> sub : subs) {
                        List<Integer> r = new LinkedList<>(sub);
                        r.add(0, val);
                        set.add(r);
                    }

                }
            }
            ret.addAll(set);
        }
        return ret;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

            List<List<Integer>> ret = new LinkedList<>();
            if( k < 0 || k > 9 || n <= 0 ) {
                return ret;
            }

            return combinationSum3(k, n, 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n, int start) {

            List<List<Integer>> ret = new LinkedList<>();
            if( k < 0 || n < 0) {
                return ret;
            }
            if( k == 0 && n == 0) {
                ret.add(new LinkedList<Integer>());
                return ret;
            }
            for (int i = start; i <= 10 - k; ++i ) {
                List<List<Integer>> subSols = combinationSum3(k-1, n-i, i+1);
                for (List<Integer> subSol : subSols) {
                    List<Integer> subSolCopy = new LinkedList<Integer>(subSol);
                    subSolCopy.add(0, i);
                    ret.add(subSolCopy);
                }
            }
            return ret;
    }*/
}