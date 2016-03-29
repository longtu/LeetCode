package wr.leetcode.algo.Facebook;

import java.util.Arrays;

public class SuffixArray {


    //Question1: sort suffix array
    // O(N^2)Log(N)
    public Integer[] sortSuffixArray( int[] text ) {
        int n = text.length;
        Integer[] ret = new Integer[n];
        for (int i = 0; i < n; ++i) {
            ret[i] = i;
        }
        Arrays.sort(ret,
                (i, j)->(suffixStr(text,i).compareTo(
                        suffixStr(text, j)
                )));
        return ret;
    }

    String suffixStr(int[] text, Integer start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i< text.length; ++i) {
            sb.append(text[i]);
            sb.append(",");
        }
        return sb.toString();
    }

    //Question2:
    //O(Log(N)*LENTH(P))
    public boolean isExist(int[] text, int[] pattern) {

        Integer[] sortedSuffix = sortSuffixArray(text);
        int n = sortedSuffix.length;

        int s = 0;
        int e = n-1;
        boolean ret = false;
        String key = suffixStr(pattern, 0);

        while (s <= e) {
            int m = s + ((e-s)>>1);
            //BUG: what value to put here!!!
            String mv = suffixStr(text, sortedSuffix[m]);
            if (mv.startsWith(key)){
                ret = true;
                break;
            } else {
                int cmp = key.compareTo(mv);
                if (cmp < 0) {
                    e = m-1;
                } else {
                    s = m + 1;
                }
            }
        }
        return ret;
    }

    //application: find longest repeated substring
    //http://www.ahathinking.com/archives/121.html O(N^3) -> O(N^2Log(N) and O(N) space)

    public static void main(String[] args) {
        SuffixArray sol = new SuffixArray();
        int[] arr = {10, 20, 30, 25};
        System.out.println(Arrays.toString(sol.sortSuffixArray(arr)));

        for (int[] test : new int[][] {
                {10},
                {20},
                {30},
                {25},
                {20, 30},
                {203,0},
                {10, 20, 30, 25},
                {10, 20, 30, 2,5}
        }) {
            System.out.println(sol.isExist(arr, test));
        }

    }
}