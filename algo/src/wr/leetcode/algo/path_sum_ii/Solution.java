package wr.leetcode.algo.path_sum_ii;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<>();
        if(null != root) {
            sum -= root.val;
            //leaf
            if( null == root.left && null == root.right) {
                if(sum == 0) {
                    List<Integer> r = new LinkedList<>();
                    r.add(root.val);
                    ret.add(r);
                }
            } else { //nodes
                if(null != root.left) {
                    for (List<Integer> ll : pathSum(root.left, sum)) {
                        ll.add(root.val);
                        ret.add(0,ll); /* WATCH OUT FOR ORDER*/

                    }
                }
                if(null != root.right) {
                    for (List<Integer> rr : pathSum(root.right, sum)) {
                        rr.add(root.val);
                        ret.add(0,rr); /* WATCH OUT FOR ORDER*/
                    }
                }
            }
        }
        return ret;
    }
}