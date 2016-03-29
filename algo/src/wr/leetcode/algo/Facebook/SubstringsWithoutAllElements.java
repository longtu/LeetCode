package wr.leetcode.algo.Facebook;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SubstringsWithoutAllElements {

    //find all substrings of input string that do not include all elements in input elements
    public static List<String> genSubStrings(String str, char[] elements) {
        Set<String> ret = new HashSet<>();
        int[] dict = new int[26];
        int expected = 0;

        for (char ch : elements){
            int idx = ch - 'a';
            if(dict[idx] == 0) {
                dict[idx] = 1;
                expected ++;
            }
        }

        int n = str.length();
        for (int i = 0; i < n; ++i) {
            int[] map = new int[26];
            int total = 0;
            for (int j = i+1; j <=n; ++j) {
                char ch = str.charAt(j-1);
                int idx = ch-'a';
                if(dict[idx] != 0 && map[idx] == 0) {
                    map[idx] ++;
                    total ++;
                }
                if( total < expected ) {
                    ret.add(str.substring(i,j));
                } else {
                    break;
                }
            }
        }
        return new LinkedList<>(ret);
    }


    public static void main(String[] args) {
        System.out.println(genSubStrings("abbc", new char[]{'a','b','c'}));
    }
}
