package wr.leetcode.algo.excel_sheet_column_title;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {



    public String convertToTitle(int n) {

        List<Character> ret = new LinkedList<>();
        int mod = 26;
        int val = n;

        while( val > 0 ) {
            int index = (val-1) % mod;
            char ch = (char)((index) + 'A');
            ret.add(0, ch);
            val = (val -1)/mod;
        }
        return ret.stream().map(e->(e.toString())).collect(Collectors.joining(""));
    }



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(1));
        System.out.println(sol.convertToTitle(26));
        System.out.println(sol.convertToTitle(27));
        System.out.println(sol.convertToTitle(28));
    }

    /*
    public String convertToTitle(int n) {
        if( n <= 0){
            return null;
        }

        LinkedList<Character> str = new LinkedList<>();
        while (n > 0) {
            //watch out for this line as well!!!
            char ch = (char)( (n-1)%26 + 'A');
            str.addFirst(ch);
            n = (n-1)/26;//watch out for this line!!!
        }

        StringBuilder sb = new StringBuilder();
        str.forEach(sb::append);
        return sb.toString();
    }*/
}
