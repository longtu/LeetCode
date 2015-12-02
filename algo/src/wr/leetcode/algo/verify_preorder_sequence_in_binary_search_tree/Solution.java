package wr.leetcode.algo.verify_preorder_sequence_in_binary_search_tree;

import java.util.Stack;

public class Solution {

    //method1: stack overflows!!!
    //Recursive solution to check boundary
    ////O(NLogN) space in stack, O(NLogN) time
    public boolean verifyPreorder0(int[] preorder) {
        boolean ret = true;
        if(null != preorder) {
            ret = verifyPreorder(preorder, 0, preorder.length, null);
        }
        return ret;
    }

    //start inclusive, end exclusive
    public boolean verifyPreorder(int[] preorder, int start, int end,
        Integer min) {

        boolean ret = true;
        if( start < end ) {
            int root = preorder[start];
            int right = start;
            while (right < end) {
                int val = preorder[right];
                //BUG: all lefts must be smaller than root
                if((null != min && min >= val)|| (right != start && val == root )){
                    return false;
                }
                if(val > root) {
                    break;
                }
                right++;
            }
            ret = verifyPreorder(preorder, start+1, right, null)
                    && verifyPreorder(preorder, right, end, root);
        }
        return ret;
    }

    //method2: use stack and variable to keep track of minimal value allowed
    //O(N) space, O(N) time
    public boolean verifyPreorder1(int[] preorder) {
        boolean ret = true;
        if(null != preorder) {
            Integer min = null;
            Stack<Integer> stack = new Stack<>();

            for (int key : preorder) {
                while(!stack.isEmpty() && stack.peek() < key) {
                    min = stack.pop();
                }
                //BUG: typo peek instead of pop()
                //NONEED: given input is unique
                if (null != min && key < min) {
                    ret = false;
                    break;
                }
                stack.push(key);
            }
        }
        return ret;
    }

    //method3: use input array to simulate stack
    // and variable to keep track of minimal value allowed
    // O(1) space, O(N) time
    public boolean verifyPreorder(int[] preorder) {
        boolean ret = true;
        if(null != preorder) {
            Integer min = null;
            int st = 0;
            for (int key : preorder) {
                while(st > 0 && preorder[st-1] < key) {
                    min = preorder[--st];
                }
                if (null != min && key < min) {
                    ret = false;
                    break;
                }
                preorder[st++] = key;
            }
        }
        return ret;
    }

        public static void main(String[] args) {
        Solution sol = new Solution();
        for (int[] arr : new int[][] {
                null,
                {},
                {1},
                {2,1,3},
                {2,1},
                {2,3},
                {2,3,1},
                {2,3,4},
                {2,1,0,3,-1},
                {3,1,4,2}
        }) {
            System.out.println(sol.verifyPreorder1(arr));
        }
    }
}
