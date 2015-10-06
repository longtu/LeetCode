package wr.leetcode.algo.pascals_triangle_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> prev = row;
            row = new ArrayList<>(i+1);
            for (int j = 0; j <= i; ++j) {
                if(j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(
                      prev.get(j) + prev.get(j-1)
                    );
                }
            }
        }
        return row;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getRow(0));
        System.out.println(sol.getRow(1));
        System.out.println(sol.getRow(2));
        System.out.println(sol.getRow(3));
        System.out.println(sol.getRow(4));
        System.out.println(sol.getRow(5));
    }
}
