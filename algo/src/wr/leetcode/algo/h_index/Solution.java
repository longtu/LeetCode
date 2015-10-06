package wr.leetcode.algo.h_index;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int hIndex(int[] citations) {
        if (null == citations) {
            citations = new int[0];
        }

        List<Integer> sorted = Arrays.stream(citations)
                .boxed()
                .sorted((a,b)->(b-a))
                .collect(Collectors.toList());

        ArrayList<Integer> reverseSorted = new ArrayList<>(sorted);

        int h = 0;
        for (int i = 1; i <= reverseSorted.size(); ++ i) {
            if(reverseSorted.get(i-1) >= i ) {
                if(i == reverseSorted.size() || reverseSorted.get(i) <= i) {
                    h = i;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {

        int[] arr = {3,0,6,1,5};
        Solution sol = new Solution();
        System.out.println(sol.hIndex(arr));
    }
}
