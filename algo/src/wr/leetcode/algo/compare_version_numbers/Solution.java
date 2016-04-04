package wr.leetcode.algo.compare_version_numbers;


import java.math.BigInteger;

public class Solution {


    public int compareVersion(String version1, String version2) {
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        if (v1s.length > v2s.length) {
            return -1 * compareVersion(version2, version1);
        }

        int n = v1s.length;
        int i = 0;

        while( i < n ) {
            int left = Integer.parseInt(v1s[i]);
            int right = Integer.parseInt(v2s[i]);
            if( left < right) {
                return -1;
            } else if (left > right) {
                return 1;
            }
            i++;
        }

        while (i < v2s.length && Integer.parseInt(v2s[i]) == 0) {
            i++;
        }

        if( i == v2s.length) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] srcs = {"0.1","1.1","1.2", "13.37"};
        for (int i = 1; i < srcs.length; ++i) {
            System.out.println(sol.compareVersion(srcs[i-1], srcs[i]));
        }
        System.out.println(sol.compareVersion("0.1","0.0.1"));
        System.out.println(sol.compareVersion("01","1"));
        System.out.println(sol.compareVersion("1.0","1.2"));
        System.out.println(sol.compareVersion("1.2","1.10"));
        System.out.println(sol.compareVersion("1.0","1"));

    }

    /*
    public int compareVersion(String version1, String version2) {

        String [] srcs = version1.split("\\.");
        String [] dests = version2.split("\\.");


        if(srcs.length < dests.length) {
            return -1* compareVersion(version2, version1);
        }

        int i = 0;
        while( i < dests.length ){
            int left = Integer.parseInt(srcs[i]);
            int right = Integer.parseInt(dests[i]);
            System.out.println(left + ":" + right);
            if(left != right) {
                return (left > right)?(1):(-1);
            }
            ++i;
        }
        //this is easy to forget, though we think about this, we forgot in initial implementaion
        while(i < srcs.length) {
            int left = Integer.parseInt(srcs[i]);
            if(left != 0) {
                return 1;
            }
            ++i;
        }
        return 0;

    }*/
}

