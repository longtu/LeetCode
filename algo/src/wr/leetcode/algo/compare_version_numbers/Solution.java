package wr.leetcode.algo.compare_version_numbers;


public class Solution {
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

        while(i < srcs.length) {
            int left = Integer.parseInt(srcs[i]);
            if(left != 0) {
                return 1;
            }
            ++i;
        }
        return 0;

    }
}

