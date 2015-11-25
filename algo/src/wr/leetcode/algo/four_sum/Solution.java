package wr.leetcode.algo.four_sum;

import java.util.*;

public class Solution {



    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        int n = nums.length;
        //BUG: forgot to sort
        if(null != nums) {
            Arrays.sort(nums);
        } else {
            throw new IllegalArgumentException("Invalid Input!");
        }
        for (int i = 0; i + 3 < n; ++i) {
            for (int j = i+1; j + 2 < n; ++j) {
                int iv = nums[i];
                int jv = nums[j];
                int t = target - jv - iv;
                int[] subArr = Arrays.copyOfRange(nums, j+1, n);
                Set<List<Integer>> subs = twoSum(subArr, t);
                for (List<Integer> s : subs) {
                    s.add(0, jv);
                    s.add(0, iv);
                    ret.add(s);
                }
            }
        }
        return new LinkedList<>(ret);
    }


    public Set<List<Integer>> twoSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet();
        int n = nums.length;
        int start = 0;
        int end = n-1;
        while( start < end ) {
            int l = nums[start];
            int r = nums[end];
            int sum = l + r;
            if( sum == target) {
                List<Integer> list = new LinkedList<>();
                list.add(l);
                list.add(r);
                ret.add(list);
                start ++;
            } else if (sum < target) {
                start ++;
            } else {
                end --;
            }
        }
        return ret;
    }

	/*
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        if( null != nums && nums.length > 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; ++i) {
                for (int j = i + 1; j < nums.length - 2; ++j) {
                    int[] sub = Arrays.copyOfRange(nums, j + 1, nums.length);
                    List<int[]> anss = twoSum(sub, target - nums[i] - nums[j]);
                    for (int[] ans : anss ) {
                        List<Integer> l = new LinkedList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(ans[0]);
                        l.add(ans[1]);
                        ret.add(l);
                    }
                }
            }
        }
        return new LinkedList(ret);
    }


    public List<int[]> twoSum( int[] nums, int target) {
        Map<Integer, Integer> count = new HashMap<>();
        List<int[]> ret = new LinkedList<>();
        int s = 0;
		int e = nums.length-1;

		while(s < e) {
			int l = nums[s];
			int r = nums[e];
			int sum = l + r;
			if(sum == target) {
				int[] ans = new int[2];
				ans[0] = l;
				ans[1] = r;
				ret.add(ans);
				s ++;
			} else if ( sum < target) {
				s ++;
			} else {
				e --;
			}
		}
		return ret;
    }




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
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {1, 0, -1, 0, -2, 2};

        System.out.println(sol.fourSum(arr, 0));
    }
}