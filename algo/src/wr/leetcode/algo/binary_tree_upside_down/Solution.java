package wr.leetcode.algo.binary_tree_upside_down;

public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode UpsideDownBinaryTree(TreeNode root) {

    	TreeNode curr = new TreeNode();
    	TreeNode next = new TreeNode();
    	TreeNode node = root;

    	if(root == null){
    		return node;
    	}

    	curr.left = node.left;
    	curr.right = node.right;
    	
    	while(curr.left != null){

    		next.left = curr.left.left;
    		next.right = curr.right.right;
    		
    		curr.left.right = node;
    		curr.left.left = curr.right
    		node = curr.left;

    		curr.left = next.left;
    		curr.right = next.right;
    	}
    	return node;
	}

    public TreeNode UpsideDownBinaryTree2(TreeNode root) {
        TreeNode p = root, parent = null, right = null;
        while (p!=null) {
            TreeNode left = p.left;
            p.left = right;
            right = p.right;
            p.right ＝ parent;
            parent = p;
            p = left;
        }
        return parent;
    }

}

