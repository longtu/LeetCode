package wr.leetcode.algo.longest_common_prefix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        String ret = "";
        if(null != strs && 0 != strs.length) {
            List<String> strings = filterNulls(strs);
            if(strings.size() > 0) {
                String prefix = strings.get(0);
                int n = prefix.length();
                int len = n;
                for (String str: strings) {
                    len = commonPrefix(prefix, str, len);
                }
                ret = prefix.substring(0, len);
            }
        }
        return ret;
    }

    public List<String> filterNulls( String[] src) {
        return Arrays.stream(src).filter(e->(null != e))
            .collect(Collectors.toList());
    }

    public int commonPrefix(String prefix, String str, int l) {

        int len = 0;
        int n = Math.min(str.length(), l);
        for (int i = 0; i < n ; ++i) {
            if(prefix.charAt(i) == str.charAt(i)){
                len++;
            } else {
                //BUG: need to break from this!!
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strs = new String[] {
                "aca", "cba"
        };
        System.out.println(sol.longestCommonPrefix(strs));
    }
}
