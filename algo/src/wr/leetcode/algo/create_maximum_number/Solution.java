package wr.leetcode.algo.create_maximum_number;

import java.util.*;

public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] max = new int[0];
        for (int len1 = 0; len1 <= k; ++len1) {
            int len2 = k-len1;
            //BUG:Check this range len1 and len2
            if(len1 > nums1.length || len2 > nums2.length) {
                continue;
            }
            int[] lefts = maxNumber(nums1, len1);
            int[] rights = maxNumber(nums2, len2);
            max = max( max, merge(lefts, rights));
        }
        return max;
    }

    public int[] merge (int[] left, int[] right) {
        int k = left.length + right.length;
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            int[] max = max(left, right);
            ret[i] = max[0];

            if(left == max) {
                left = Arrays.copyOfRange(left,1, left.length);
            } else {
                right = Arrays.copyOfRange(right,1, right.length);
            }
        }
        return ret;
    }

    public int[] maxNumber(int[] nums, int k) {
        LinkedList<Integer> st = new LinkedList<>();
        int n = nums.length;
        //BUG: PEEK last or first??!!! list usage!!
        for (int i = 0; i < n; ++i) {
            while(!st.isEmpty() && st.size() + n - i > k  && st.peekLast() < nums[i]) {
                st.removeLast();
            }
            if(st.size() < k) {
                st.addLast(nums[i]);
            }
        }
        int[] ret = new int[k];

        for (int j = 0; j < k; ++j) {
            ret[j] = st.removeFirst();
        }

        return ret;
    }

    public String tostring(int[] left, int[] right) {
        StringBuilder lsb = new StringBuilder();
        for (int i : left) {
            lsb.append(i);
        }
        for (int i : right) {
            lsb.append(i);
        }
        return lsb.toString();
    }

    //pay attention to left/right is empty
    //Check this with a previous question about the comparator
    public int[] max( int[] left, int[] right) {

        if(left.length == 0) {
            return right;
        } else if (right.length == 0) {
            return left;
        }

        String ls = tostring(left, right);
        String rs = tostring(right, left);
        return (ls.compareTo(rs) < 0)?(right):(left);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] a = {3,4,6,5};
        int [] b = {9,1,2,5,8,3};
        int [] c = {6,7};
        int [] d = {6,0,4};
        int [] e = {3,9};
        int [] f = {8,9};

        System.out.println(Arrays.toString(sol.maxNumber(a,b,5)));
        System.out.println(Arrays.toString(sol.maxNumber(c,d,5)));
        System.out.println(Arrays.toString(sol.maxNumber(e,f,3)));
    }

}