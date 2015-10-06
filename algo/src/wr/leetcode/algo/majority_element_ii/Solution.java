package wr.leetcode.algo.majority_element_ii;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if ( null != nums ) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int key : nums) {
                //contains key
                if( count.containsKey(key)) {
                    count.put(key, count.get(key) + 1);
                }//not contains key, but  elements smaller than 2
                else if (count.size() < 2) {
                    count.put(key, 1);
                } //not contains key, but elements equal or greater than 2
                else {
                    List<Integer> keys = new LinkedList<>(count.keySet());
                    for (Integer k : keys) {
                        if (count.get(k) == 1) {
                            count.remove(k);
                        } else {
                            count.put(k, count.get(k)-1);
                        }
                    }
                }
            }
            Map<Integer, Integer> validate = new HashMap<>();
            for(int key : nums) {
                if(count.containsKey(key)) {
                    validate.put(key, validate.getOrDefault(key, 0) + 1);
                }
            }
            ret = validate.entrySet().stream()
                    .filter((a)->(a.getValue() >= (nums.length/3 + 1)))
                    .map((a)->(a.getKey()))
                    .collect(Collectors.toList());
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.majorityElement(new int[]{1, 2, 1, 2, 3}));
        System.out.println(sol.majorityElement(new int[]{1, 2, 3, 1, 2,}));
        System.out.println(sol.majorityElement(new int[]{1, 1, 2, 2, 3}));
        System.out.println(sol.majorityElement(new int[]{1, 2, 2, 1, 3}));
        System.out.println(sol.majorityElement(new int[]{3, 1, 2, 2, 1}));
        System.out.println(sol.majorityElement(new int[]{}));
        System.out.println(sol.majorityElement(new int[]{1}));
        System.out.println(sol.majorityElement(new int[]{1,2}));
        System.out.println(sol.majorityElement(new int[]{1,2,3}));
        System.out.println(sol.majorityElement(new int[]{3,2,3}));

    }
}
