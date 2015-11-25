package wr.leetcode.algo.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ret = 0;
        if(null != triangle && !triangle.isEmpty()) {
            int n = triangle.size();
            ArrayList<ArrayList<Integer>> rows = convert(triangle);
            int [] sum = new int[n];
            for (int i = n-1; i >=0; --i) {
                ArrayList<Integer> row = rows.get(i);
                for (int j = 0; j <= i; ++j) {
                    if( i == n-1){
                        sum[j] = row.get(j);
                    } else {
                        sum[j] = Math.min( sum[j+1], sum[j]) + row.get(j);
                    }
                }
            }
            ret = sum[0];
        }
        return ret;
    }

    public ArrayList<ArrayList<Integer>> convert(List<List<Integer>> triangle) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for (List<Integer> row : triangle) {
            ret.add(new ArrayList<>(row));
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> input = new LinkedList<>();
        List<Integer> one = new LinkedList<>();
        one.add(-1);

        List<Integer> two = new LinkedList<>();
        two.add(-2);
        two.add(-3);

        input.add(one);
        input.add(two);

        System.out.println(sol.minimumTotal(input));
    }

}
