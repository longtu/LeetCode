package wr.leetcode.algo.zigzag_conversion;

public class Solution {
    public String convert(String s, int nRows) {
        if(null == s) {
            s = "";
        }
        if(nRows <1) {
            throw new IllegalArgumentException("Invalid Input");
        }

        StringBuilder [] sbs = new StringBuilder[nRows];
        for (int i = 0; i < nRows; ++i) {
            sbs[i] = new StringBuilder();
        }

        int step = 1;
        int index = 0;
        int mod = 2*nRows-2;
        for (int i = 0; i < s.length(); ++i ) {
            if (mod == 0) {
                step = 0;
            } else if (i%mod == 0) {
                step = 1;
            } else if (i%mod == nRows-1) {
                step = -1;
            }
            sbs[index].append(s.charAt(i));
            index += step;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : sbs) {
            ret.append(sb.toString());
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
        System.out.println(sol.convert("PAYPALISHIRING", 1));
    }
}
