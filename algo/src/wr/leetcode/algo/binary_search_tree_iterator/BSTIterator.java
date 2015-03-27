package wr.leetcode.algo.binary_search_tree_iterator;

import java.util.Stack;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class BSTIterator {

    //stack is stack, not list
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeftDecents(root);
    }

    private void pushLeftDecents( TreeNode node){
        while(node != null) {
          stack.push(node);
          node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        if(!hasNext()){
          throw new RuntimeException("Index out of bound!");
        }
        TreeNode node = stack.pop();
        pushLeftDecents(node.right);
        return node.val;
    }
}

