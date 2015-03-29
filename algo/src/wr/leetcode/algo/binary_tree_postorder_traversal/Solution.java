package wr.leetcode.algo.binary_tree_postorder_traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<Integer> ret = new Stack<>();
        if (null == root) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
 			ret.add(node.val);
 			if(null != root.right) {
 				stack.push(root.right);
 			}
 			if(null != root.left) {
 				stack.push(root.left);
 			}
        }
        List<Integer> r = new LinkedList<Integer>();
        while(!ret.isEmpty()){
        	r.add(ret.pop());
        }
        return r;
    }
}