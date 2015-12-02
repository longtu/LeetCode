package wr.leetcode.algo.closest_binary_search_tree_value_ii;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {

    //Method1: O(N) time and O(LongN) space
    //Iterate every node and keep track of the smallest distance
    public List<Integer> closestKValues1(TreeNode root, double target, int k) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b)->
        {
            double abs = b.diff-a.diff;
            int ret = 0;
            if(abs > 0) {
              ret = 1;
            } else {
              ret = -1;
            }
            return ret;
        }
        );

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = node.val;
            heap.offer(new Pair(val, Math.abs(val-target)));
            if(heap.size() > k) {
                heap.poll();
            }
            if(null != node.right) {
                stack.push(node.right);
            }
            if(null != node.left) {
                stack.push(node.left);
            }
        }

        List<Integer> ret = new LinkedList<>();
        while(!heap.isEmpty()) {
            ret.add(0, heap.poll().key);
        }
        return ret;
    }

    class Pair{
        int key;
        double diff;
        public Pair(int key, double diff) {
            this.key = key;
            this.diff = diff;
        }
    }

    //method2: O(LogN + k) time and O(LogN) space
    //keep track of all smallers and biggers
    //use stack to keep track of path, so that iterative get next smaller/bigger
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> biggers = new Stack<>();
        Stack<TreeNode> smallers = new Stack<>();

        TreeNode node = root;
        while(null != node) {
            //BUG: typo root.val -> node.val
            int key = node.val;
            //BUG: need to push equal nodes
            if(key >= target){
                biggers.push(node);
                node = node.left;
            } else {
                smallers.push(node);
                node = node.right;
            }
        }

        List<Integer> ret = new LinkedList<>();
        //BUG: k--
        while( k--  > 0 ) {
            if(biggers.isEmpty() && smallers.isEmpty()) {
                break;
            } else if (biggers.isEmpty()) {
                ret.add(smaller(smallers).val);
            } else if (smallers.isEmpty()) {
                ret.add(bigger(biggers).val);
            } else if ( Math.abs(biggers.peek().val - target) <= Math.abs(target - smallers.peek().val) ) {
                ret.add(bigger(biggers).val);
            } else {
                ret.add(smaller(smallers).val);
            }
        }
        return ret;
    }

    //Great implementation to model smaller
    private TreeNode smaller (Stack<TreeNode> stack ) {
        TreeNode ret = null;
        if(!stack.isEmpty()) {
            ret = stack.pop();
            TreeNode node = ret.left;
            while(null!= node) {
                stack.push(node);
                node = node.right;
            }
        }
        return ret;
    }

    //Great implementation to model bigger
    private TreeNode bigger (Stack<TreeNode> stack ) {
        TreeNode ret = null;
        if(!stack.isEmpty()) {
            ret = stack.pop();
            TreeNode node = ret.right;
            while(null != node) {
                stack.push(node);
                node = node.left;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode left= new TreeNode(1);
        root.left = left;

        System.out.println(new Solution().closestKValues(root, 6.0, 1));
    }

}