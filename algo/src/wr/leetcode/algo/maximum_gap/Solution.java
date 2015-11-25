package wr.leetcode.algo.maximum_gap;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {


    public int maximumGap(int[] nums) {
        int ret = 0;
        if( null != nums && nums.length > 1 ) {
            int[] sorted = radixSort(nums);
            int n = nums.length;
            int max = 0;
            //BUG: use sorted array instead of input array here
            for ( int i = 1; i < n; ++i) {
                max = Math.max(sorted[i] - sorted[i-1], max);
            }
            ret = max;
        }
        return ret;
    }

    public int[] radixSort(int[] nums) {

        List<Integer> vals = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Map<Long, List<Integer>> source = new HashMap<>();
        int n = nums.length;
        source.put(0l, vals);
        Long mod = 1l;

        while( mod < Integer.MAX_VALUE ) {
            Map<Long, List<Integer>> dest = new HashMap<>();
            for (Long k = 0l; k < 10l; k++) {
                List<Integer> vList = source.getOrDefault(k, new LinkedList<>());
                for (Integer v : vList){
                    long div = mod * 10;
                    long nextIndex = v % (div) / mod;
                    List<Integer> nextVList = dest.getOrDefault(nextIndex, new LinkedList<>());
                    nextVList.add(v);
                    dest.put(nextIndex, nextVList);
                }
            }
            source = dest;
            mod *= 10;
        }

        int[] ret = new int[n];
        int i = 0;
        for (Long v = 0l; v < 10l; v ++) {
            List<Integer> vList = source.getOrDefault(v, new LinkedList<>());
            for ( int val : vList ) {
                ret[i++] = val;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] num = {7,2,1,6};
        System.out.println(sol.maximumGap(num));

        System.out.println(Integer.MAX_VALUE - 7);

    }
    /*
    public int maximumGap(int[] num) {

        if(null == num || num.length < 2) {
            return 0;
        }

        ArrayList<Integer> sorted = radixSort(
            num
        );
        int diff = 0;
        for (int i = 1; i < sorted.size(); ++i) {
            if(sorted.get(i) - sorted.get(i-1) > diff) {
                diff = sorted.get(i) - sorted.get(i-1);
            }
        }
        return diff;
    }

    public ArrayList<Integer> radixSort( int [] num) {


        List<Integer> nums = new LinkedList(Arrays.stream(num).boxed().collect(Collectors.toSet()));
        Map<Integer, List<Integer>> src = new HashMap<>();
        src.put(0, nums);

        Map<Integer, List<Integer>> dest = new HashMap<>();
        for (int l = 0; l <= 9; ++l) {
            dest = new HashMap<>();
            int div = (int) Math.pow(10,l);
            for (int j = 0; j <=9; ++j) {
                if (!src.containsKey(j)){
                    continue;
                }
                List<Integer> prevs = src.get(j);
                for(Integer p : prevs) {
                    //radix sort key here!!!
                    int newIndex = (p/div)%10;
                    if(!dest.containsKey(newIndex)) {
                        dest.put(newIndex,new LinkedList<>());
                    }
                    dest.get(newIndex).add(p);
                }
            }
            src = dest;
        }

        ArrayList<Integer> res = new ArrayList<>();
        for ( int i = 0; i <=9; ++i){
            if(!dest.containsKey(i)) {
                continue;
            }
            List<Integer> r = dest.get(i);
            res.addAll(r);

        }
        return res;
    }*/
}
