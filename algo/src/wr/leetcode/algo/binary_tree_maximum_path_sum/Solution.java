package wr.leetcode.algo.binary_tree_maximum_path_sum;

import wr.leetcode.algo.TreeNode;


//LEAF NODE LEAF NODE!!!!

public class Solution {
    class PathData{
        int maxNodePathSum;
        int maxPathSum;
    }

    public PathData maxPathSumData(TreeNode root) {
        PathData data = new PathData();
        if(null == root) {
            data.maxNodePathSum = 0;
            data.maxPathSum = 0;
        } else {
            int maxNodePathSum = root.val;
            int connect = root.val;
            int maxPathSum = root.val;

            if(null != root.left) {
                PathData leftData = maxPathSumData(root.left);
                maxNodePathSum = Math.max(maxNodePathSum, leftData.maxNodePathSum + root.val);
                maxPathSum = Math.max(maxPathSum, leftData.maxPathSum);
                connect += leftData.maxNodePathSum;
            }

            if(null != root.right) {
                PathData rightData = maxPathSumData(root.right);
                maxNodePathSum = Math.max(maxNodePathSum, rightData.maxNodePathSum + root.val);
                maxPathSum = Math.max(maxPathSum, rightData.maxPathSum);
                connect += rightData.maxNodePathSum;
            }

            maxPathSum = Math.max(Math.max(connect, maxPathSum), maxNodePathSum);
            data.maxPathSum = maxPathSum;
            data.maxNodePathSum = maxNodePathSum;
        }
        return data;
    }

    public int maxPathSum(TreeNode root) {
        return maxPathSumData(root).maxPathSum;
    }

    /*
    class PathInfo{
        int maxSum;
        int maxPath;
        public PathInfo(int maxSum, int maxPath) {
            this.maxSum = maxSum;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        PathInfo info = maxPathSumInfo(root);
        return (info == null)?(0):(info.maxPath);
    }

    private PathInfo maxPathSumInfo( TreeNode root) {
        if(null == root) {
            return null;
        }

        PathInfo leftInfo = maxPathSumInfo(root.left);
        PathInfo rightInfo = maxPathSumInfo(root.right);
        int maxPath = Math.max(root.val, Math.max(
                (leftInfo == null)? (0):(leftInfo.maxPath),
                (rightInfo == null)? (0):(rightInfo.maxPath)) + root.val);
        int maxCross = Math.max(maxPath, root.val +
                ((leftInfo == null)? (0):(leftInfo.maxPath)) + ((rightInfo == null)? (0):(rightInfo.maxPath)));

        int maxSum = Math.max( maxCross,
                Math.max(((leftInfo == null)? (Integer.MIN_VALUE):(leftInfo.maxSum)),
                         ((rightInfo == null)? (Integer.MIN_VALUE):(rightInfo.maxSum))));

        return new PathInfo( maxSum, maxPath);
    }*/

}
