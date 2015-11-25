package wr.leetcode.algo.gray_code;

import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {



    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if( 0 == n) {
            ret.add(0);
        } else if (n > 0) {
            ArrayList<Integer> subs = (ArrayList<Integer>)grayCode(n-1);
            for (Integer sub : subs){
                ret.add(sub);
            }
            for (int i = subs.size()-1; i >=0; --i) {
                //BUG: return binary representation of the integer instead of built-up integers
                //It's better to use bit operations and watch out for precedences.
                ret.add( (1<<(n-1)) + subs.get(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.grayCode(0));
        System.out.println(sol.grayCode(1));
        System.out.println(sol.grayCode(2));
        System.out.println(sol.grayCode(3));
    }

    /*
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new LinkedList();
        if(n < 0) {
            return ret;
        }
        if(0 == n){
            ret.add(0);
            return ret;
        }
        List<Integer> subs = grayCode(n-1);
        Stack<Integer> stack = new Stack();
        for(Integer sub : subs) {
            ret.add((0<<(n-1)) + sub);
            stack.push((1<<(n-1)) + sub);
        }
        while(!stack.isEmpty()) {
            ret.add(stack.pop());
        }
        return ret;
    }*/

}
