package wr.leetcode.algo.largest_number;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int compare(Integer left, Integer right) {
        String l = Integer.toString(left) + Integer.toString(right);
        String r = Integer.toString(right) + Integer.toString(left);
        return r.compareTo(l);
    }

    public String largestNumber(int[] nums) {
        if( null == nums) {
            nums = new int[0];
        }
        String ret = Arrays.stream(nums).boxed()
            .sorted(this::compare)
            .map(a -> (a.toString()))
            .collect(Collectors.joining());
        //BUG: multiple zeros
        return ret.replaceAll("^0+", "0");
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(
                new int[]{0,0,0,0}
        ));
    }

    /*
    public static int compare (String left, String right) {
        if(left.length() < right.length()) {
            return -1*compare(right, left);
        }
        //left size >= right size
        int i = 0;
        while( i < right.length() ) {
            if(left.charAt(i) != right.charAt(i) ){
                return (left.charAt(i) - right.charAt(i));
            }
            ++i;
        }
        if(left.length() == right.length())
            return 0;
        return compare(left.substring(i), left.substring(0,i));

    }

    public String largestNumber(int[] num) {

        if(num == null || num.length == 0) {
            return "";
        }
        List<String> strs = Arrays.stream(num).boxed().map(a -> a.toString()).collect(Collectors.toList());
        Collections.sort(strs, (a, b) -> Solution.compare(b, a));
        StringBuilder sb = new StringBuilder();
        strs.stream().forEach( a->sb.append(a));

        String ret = sb.toString();
        if(ret.startsWith("0")){
            ret = "0";
        }
        System.out.println(strs);
        return ret;
    }*/
}