package wr.leetcode.algo.sum_root_to_leaf_numbers;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    public int sumNumbers(TreeNode root) {
 		if(null == root) {
 			return 0;
 		}
 		return sumNumbers(0, root);
    }
    private int sumNumbers(int base, TreeNode root) {
    	if(null == root) {
    		return 0;
    	}
    	base = base*10 + root.val;
    	if(null == root.left && null == root.right){
    		return base;
    	}
    	return sumNumbers(base, root.left) + sumNumbers(base, root.right);
    }*/

    public int sumNumbers(TreeNode root) {
        List<String> numbers = numbers(root);
        int ret = 0;
        for (String n : numbers) {
            ret += Integer.parseInt(n);
        }
        return ret;
    }

    public List<String> numbers (TreeNode root) {
        List<String> ret = new LinkedList<>();
        if( null != root ) {
            if( null == root.left && null == root.right) {
                String l = Integer.toString(root.val);
                ret.add(l);
            } else {
                if( null != root.left) {
                    List<String> subs = numbers(root.left);
                    for (String sub : subs) {
                        ret.add( Integer.toString(root.val) + sub);
                    }
                }
                if( null != root.right) {
                    List<String> subs = numbers(root.right);
                    for (String sub : subs) {
                        ret.add( Integer.toString(root.val) + sub);
                    }
                }
            }
        }
        return ret;
    }
}