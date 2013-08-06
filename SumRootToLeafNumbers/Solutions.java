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
    private int sumNumbers(TreeNode root, int val) {
        int myValue = val*10+root.val;
        if(root.left == null && root.right == null) {
            return myValue; 
        }
        int sum = 0;
        if(root.left != null)
            sum += sumNumbers(root.left, myValue);
        if(root.right != null)
            sum += sumNumbers(root.right, myValue);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        return sumNumbers(root,0);
    }
}
