package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

public class IsomorphicTree {
    public static boolean isIsomorphic(TreeNode left, TreeNode right) {
        boolean ret;

        if ( null == left && null == right) {
            ret = true;
        } else if (null == left || null == right) {
            ret = false;
        } else {
            ret = (left.val == right.val) && (
                    (isIsomorphic(left.left, right.left) && isIsomorphic(left.right, right.right)) ||
                            (isIsomorphic(left.left, right.right) && isIsomorphic(left.right, right.left))
            );
        }
        return ret;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(4);

        boolean result = IsomorphicTree.isIsomorphic(root1, root2);

        System.out.println(result);
    }
}
