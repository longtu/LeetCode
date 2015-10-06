package wr.leetcode.algo.different_ways_to_add_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> ret = new LinkedList<>();
        if( null == input) {
            input = "";
        }

        boolean hasOperator = false;
        char[] arr = input.toCharArray();
        for (int i = 0; i < input.length(); ++i) {
            char ch = arr[i];
            if( '+' == arr [i] || '*' == arr [i] || '-' == arr[i]) {
                hasOperator = true;
                List<Integer> lefts = diffWaysToCompute(input.substring(0, i));
                List<Integer> rights = diffWaysToCompute(input.substring(i+1, input.length()));
                for (Integer left : lefts)
                    for (Integer right: rights) {
                        if('+' == arr[i]) {
                            ret.add(left + right);
                        }
                        else if('*' == arr[i]) {
                            ret.add(left * right);
                        }
                        else if('-' == arr[i]) {
                            ret.add(left - right);
                        } else {
                            throw new IllegalStateException("Invalid input!");
                        }
                    }
            }
        }
        if(!hasOperator) {
            ret.add(Integer.parseInt(input));
        }
        return ret;
    }
    //TODO: further improve Runtime Complexity using DP


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diffWaysToCompute("2-1-1"));
        System.out.println(sol.diffWaysToCompute("2*3-4*5"));
    }
}
