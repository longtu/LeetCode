package wr.leetcode.algo.Facebook;


import wr.leetcode.algo.TreeNode;

public class NthElementInTree {
    int index = 0;
    int ret = -1;

    //Method1: stateless solution
    public int nthElementStateless(TreeNode root, int n) {
        int ret = -1;
        if ( null == root ) {
            throw new IllegalArgumentException("Tree is empty!");
        }
        int nodes = totalNodes(root.left);
        if (nodes + 1 == n) {
            ret = root.val;
        } else if (nodes >= n) {
            ret = nthElementStateless(root.left, n);
        } else {
            ret = nthElementStateless(root.right, n - nodes - 1);
        }
        return ret;
    }

    private int totalNodes(TreeNode root ) {
        int ret = 0;
        if( null != root ) {
            ret += 1;
            ret += totalNodes(root.left);
            ret += totalNodes(root.right);
        }
        return ret;
    }

    //method2: using class variable to keep track of state
    public int nthElement(TreeNode root, int n) {
        if( n <= 0 || !findNode(root, n)) {
            return -1;
        }
        return ret;
    }

    public boolean findNode( TreeNode root, int n) {
        boolean ret = false;
        if( null != root ) {
            if(findNode(root.left, n)) {
                return true;
            }
            this.index ++;
            if(index == n) {
                this.ret = root.val;
                ret = true;
            } else {
                ret = findNode(root.right, n);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);


        for (int i = 1; i <7; ++i) {
            NthElementInTree sol = new NthElementInTree();
            int result = sol.nthElement(root, i);
            System.out.println("Result is " + result);
            System.out.println("Result is " + sol.nthElementStateless(root, i));
        }

    }
}
