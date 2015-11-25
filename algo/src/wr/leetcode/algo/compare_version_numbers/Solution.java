package wr.leetcode.algo.compare_version_numbers;


import java.math.BigInteger;

public class Solution {

    //at most one . character
    public int compareVersion(String version1, String version2) {
        String[] lefts = version1.split("\\.");
        String[] rights = version2.split("\\.");

        if(lefts.length < rights.length) {
            return -1 * compareVersion(version2, version1);
        }
        //left size >= right size
        int ret = 0;

        for (int i = 0; i < rights.length; ++i) {
            Long lv = toLong(lefts[i]);
            Long rv = toLong(rights[i]);

            if(lv < rv){
                ret =  -1;
                break;
            } else if (lv > rv) {
                ret = 1;
                break;
            }
        }

        if(0 == ret && lefts.length > rights.length) {
            for (int i = rights.length; i < lefts.length; ++i) {
                if (toLong(lefts[i]) > 0) {
                    ret = 1;
                    break;
                }
            }
        }
        return ret;

    }



    public Long toLong (String key) {
        if(null == key || key.isEmpty()) {
            return 0l;
        } else {
            return Long.parseLong(key);
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

