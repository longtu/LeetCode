package wr.leetcode.algo.decode_ways;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int numDecodings(String s) {

        Set<String> decodes =
        IntStream.rangeClosed(1,26)
                .boxed()
                .map((a)->a.toString())
                .collect(Collectors.toSet());
        int len = s.length();
        //initialization
        int [] decodings = new int [3];
        decodings[0] = 1;

        //recursive relation
        for (int i = 1; i <= len; ++i) {
            decodings[i%3] = 0;//this line is easy to miss
            if ( i >= 1 && decodes.contains(s.substring(i - 1, i)))
                decodings[i%3] += decodings[(i-1)%3];
            if ( i >= 2 && decodes.contains(s.substring(i-2, i)))
                decodings[i%3] += decodings[(i-2)%3];
        }
        return (len > 0) ? decodings[len%3] : 0; // is is up to the requirement
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("ab"));
        System.out.println(new Solution().numDecodings(""));

    }
}