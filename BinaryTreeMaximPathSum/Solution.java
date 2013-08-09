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
    class MetaData{
        int maxPathSum;
        int maxSinglePath;
        public MetaData(int maxPathSum, int maxSinglePath){
            this.maxPathSum = maxPathSum;
            this.maxSinglePath = maxSinglePath;
        }
    }
    public MetaData maxPathSumWithMeta(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null){
            return new MetaData(Integer.MIN_VALUE,0);
        }

        MetaData leftData = maxPathSumWithMeta(root.left);
        MetaData rightData = maxPathSumWithMeta(root.right);

        int maxSinglePath = ((leftData.maxSinglePath > rightData.maxSinglePath)?
                            (leftData.maxSinglePath):(rightData.maxSinglePath))+root.val;

        int myPathSumWithNode = leftData.maxSinglePath + rightData.maxSinglePath +root.val;
        int maxPathSumOfChildren = ((leftData.maxPathSum > rightData.maxPathSum)?
                            (leftData.maxPathSum):(rightData.maxPathSum));
        int myMaxPathSum = (myPathSumWithNode > maxPathSumOfChildren)? 
            (myPathSumWithNode):(maxPathSumOfChildren);
        return new MetaData(myMaxPathSum, maxSinglePath);
    }

    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return maxPathSumWithMeta(root).maxPathSum;
    }
}
