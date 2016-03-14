package wr.leetcode.algo.Facebook;

public class CountPalidrome {

    //clarify empty string
    public static int countPalidrome( String str ) {
        int ret = 0;
        str = (null == str)?(""):(str);

        int n = str.length();
        for (int i = 0; i < n; ++ i) {
            int count = 0;
            // odd
            for (int l = 0; i-l >= 0 && i+l < n; ++l) {
                if( str.charAt(i-l) == str.charAt(i+l) ) {
                    count ++;
                } else {
                    break;
                }
            }
            //even
            for (int l = 0; i-l >=0 && i+1+l < n; ++l) {
                if( str.charAt(i-l) == str.charAt(i+1+l)) {
                    count ++;
                } else {
                    break;
                }
            }
            ret += count;
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] tests = {"aba", "abba", "abc", ""};
        for (String t : tests) {
            System.out.println(countPalidrome(t));
        }
    }
}
