package wr.leetcode.algo.largest_number;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private int compare (String left, String right) {

        char[] lchars = left.toCharArray();
        char[] rchars = right.toCharArray();

        char[] longer = (lchars.length >= rchars.length)?(lchars):(rchars);
        char[] shorter = (longer == lchars)? (rchars):(lchars);

        int i = 0;
        for( ; i < shorter.length; ++i){
            if(longer[i] != shorter[i]) {
                return (lchars[i] - rchars[i]);
            }
        }
        if(longer.length == i){
            return 0;
        }
        String longers = new String(longer);
        int ret =  compare(longers.substring(i, longer.length), longers.substring(0, i));

        if(longer == lchars) {
            return ret;
        } else {
            return ret * -1;
        }
    }

    public String largestNumber(int[] num) {

        if(num == null || num.length == 0) {
            return "";
        }

        List<String> strs = new LinkedList<String>();
        for(int n : num)
            strs.add(String.valueOf(n));
        Collections.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return new Solution().compare(t1, s);
            }
        });
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for (String str : strs) {
            sb.append(str);
        }
        String ret = sb.toString();
        if(ret.startsWith("0")){
            ret = "0";
        }
        System.out.println(strs);
        return ret;
    }
}