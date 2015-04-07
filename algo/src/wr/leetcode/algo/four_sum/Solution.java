package wr.leetcode.algo.four_sum;

import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> ret = new LinkedList();
		if(null == num || num.length < 4) {
			return ret;
		}
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; ++ i) {
			for (int j = i+1; j < num.length - 2; ++j) {
				int sum = target - num[i] - num[j];
				int[] sub = Arrays.copyOfRange(num, j+1, num.length);
				List<List<Integer>> twoSums = twoSum(sub, sum);
				for (List<Integer> twoSum : twoSums) {
                    twoSum.add(0, num[j]);
					twoSum.add(0, num[i]);
					ret.add(twoSum);
				}
			}
		}
		return removeDuplicates(ret);
    }

    public List<List<Integer>> twoSum(int[]num, int target) {
    	int start = 0;
    	int end = num.length-1;
    	List<List<Integer>> ret = new LinkedList();
    	while(start < end) {
    		int sum = num[start]+num[end];
    		if( sum < target) {
    			start ++;
    		} else if ( sum > target) {
    			end --;
    		} else {
    			List<Integer> twoSum = new LinkedList();
    			twoSum.add(num[start]);
    			twoSum.add(num[end]);
    			ret.add(twoSum);
                start ++;
    		}
    	}
    	return removeDuplicates(ret);
    }

    public List<List<Integer>> removeDuplicates(List<List<Integer>> source){
    	Set<String> keys = new HashSet();
    	List<List<Integer>> ret = new LinkedList();
    	for (List<Integer> s : source) {
    		String key = key(s);
    		if(!keys.contains(key)) {
    			ret.add(s);
    		}
            keys.add(key);
    	}
    	return ret;
    }
    public String key(List<Integer> s) {
    	StringBuilder sb = new StringBuilder();
    	for (Integer i : s) {
    		sb.append('-');
    		sb.append(i);
    	}
    	return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(sol.fourSum(arr, 0));
    }
}