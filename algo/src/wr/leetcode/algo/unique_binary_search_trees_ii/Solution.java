package wr.leetcode.algo.unique_binary_search_trees_ii;


import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n+1);
    }


    public List<TreeNode> generateTrees(int minInclusive, int maxExclusive) {
        List<TreeNode> trees = new LinkedList<>();

        if(minInclusive >= maxExclusive) {
            trees.add(null);
        } else if (minInclusive +1 == maxExclusive) {
            trees.add(new TreeNode(minInclusive));
        } else {
            for (int mid = minInclusive; mid < maxExclusive; ++mid) {
                List<TreeNode> lSubs = generateTrees(minInclusive, mid);
                List<TreeNode> rSubs = generateTrees(mid+1, maxExclusive);
                for ( TreeNode lSub: lSubs)
                    for( TreeNode rSub: rSubs) {
                        TreeNode node = new TreeNode(mid);
                        node.left = copy(lSub);
                        node.right = copy(rSub);
                        trees.add(node);
                    }
            }
        }
        return trees;
    }

    public TreeNode copy(TreeNode root){

        if(root == null) {
            return root;
        } 
        TreeNode r = new TreeNode(root.val);
        TreeNode cl = copy(root.left);
        TreeNode cr = copy(root.right);
        r.left = cl;
        r.right = cr;
        return r;
    }


}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}