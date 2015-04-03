package wr.leetcode.algo.excel_sheet_column_title;

import java.util.LinkedList;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convertToTitle(1));
        System.out.println(sol.convertToTitle(26));
        System.out.println(sol.convertToTitle(27));
        System.out.println(sol.convertToTitle(28));


    }
}
