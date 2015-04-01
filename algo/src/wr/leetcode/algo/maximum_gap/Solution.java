package wr.leetcode.algo.maximum_gap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int maximumGap(int[] num) {

        Set<Integer> dic = Arrays.stream(num)
                            .boxed()
                            .collect(Collectors.toSet());
        if(dic.size() < 2) {
            return 0;
        }

        int maxDiff = 0;
        int last = -1;
        for (int i = 0; i < Integer.MAX_VALUE; ++i) {
            if(!dic.contains(i)){
                continue;
            }
            if(-1 != last) {
                maxDiff = Math.max(maxDiff, i-last);
            }
            last = i;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {1,1,1};
        System.out.println(sol.maximumGap(num));
    }
}
