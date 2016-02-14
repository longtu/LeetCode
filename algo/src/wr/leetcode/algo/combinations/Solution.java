package wr.leetcode.algo.combinations;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public List<List<Integer>> combine(int[] arr, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if (k == 0) {
            ret.add(new LinkedList<>());
        } else {
            for (int i = 0; i + k <= arr.length; ++i) {
                List<List<Integer>> subCombines = combine(Arrays.copyOfRange(arr, i+1, arr.length), k-1);
                for (List<Integer> subCombine : subCombines) {
                    subCombine.add(0, arr[i]);
                    ret.add(subCombine);
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if ( k > 0 && k <= n && n > 0) {
            int[] arr = IntStream.rangeClosed(1, n).sorted().toArray();
            ret = combine(arr, k);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.combine(4,2));
    }

    /*

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<>();
        if( k > 0 && n >= k) {
            int[] nums = new int[n];
            for (int i = 0; i < n; ++i) {
                nums[i] = i + 1;
            }
            ret = combineRec(k, nums);
        }
        return ret;
    }

    public List<List<Integer>> combineRec(int k, int[] nums) {
        List<List<Integer>> ret =  new LinkedList<>();
        if( 0 == k ) {
            ret.add( new LinkedList<>() );
        } else if (nums.length > 0 ) {// k > 0
            int first = nums[0];
            int[] subNums = Arrays.copyOfRange(nums, 1, nums.length);
            List<List<Integer>> subs = combineRec(k-1, subNums);
            for (List<Integer> sub : subs) {
                List<Integer> r = new LinkedList<>(sub);
                r.add(0, first);
                ret.add(r);
            }
            ret.addAll(combineRec(k, subNums));
        }
        return ret;
    }

    public List<List<Integer>> combine1(int n, int k) {

        Object[][] sols = new Object[2][k + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                List<List<Integer>> mySol = new LinkedList();
                if (i == 0 && j == 0) {
                    mySol.add(new LinkedList());
                } else if (i > 0) {
                    List<List<Integer>> lefts = (List<List<Integer>>) (sols[(i - 1) % 2][j]);
                    mySol.addAll(lefts);
                    if (j > 0) {
                        List<List<Integer>> rights = (List<List<Integer>>) sols[(i - 1) % 2][j - 1];
                        for (List<Integer> right : rights) {
                            List<Integer> sol = new LinkedList(right);
                            sol.add(i);
                            mySol.add(sol);
                        }
                    }
                }
                sols[i % 2][j] = mySol;
            }
        }
        return (List<List<Integer>>) sols[n % 2][k];
    }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ret = new LinkedList<>();
            if(n == 0 && k == 0) {
                ret.add(new LinkedList<>());
                return ret;
            }
            List<List<Integer>> mySol = new LinkedList();
            if(n > 0 ) {
                mySol.addAll(combine(n-1, k));
                if(k > 0) {
                    List<List<Integer>> rights = combine(n - 1, k - 1);
                    for (List<Integer> right : rights) {
                        List<Integer> sol = new LinkedList(right);
                        sol.add(n);
                        mySol.add(sol);
                    }
                }
            }
            return mySol;
        }
    */
}