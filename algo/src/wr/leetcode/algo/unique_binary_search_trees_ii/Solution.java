package wr.leetcode.algo.unique_binary_search_trees_ii;


import wr.leetcode.algo.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<TreeNode> generateTrees(int n) {
        int [] arr = new int[n];
        for (int i = 1; i <=n; ++i) {
            arr[i-1] = i;
        }
        return generateTrees(arr);
    }

    public List<TreeNode> generateTrees(int [] arr) {
        List<TreeNode> ret = new LinkedList<>();
        int n = arr.length;
        for (int mid = 0; mid < n; ++ mid) {
            List<TreeNode> lSubs = generateTrees(Arrays.copyOfRange(arr, 0, mid));
            List<TreeNode> rSubs = generateTrees(Arrays.copyOfRange(arr, mid+1, n));

            for (TreeNode l : lSubs) {
                for (TreeNode r : rSubs) {
                    TreeNode root = new TreeNode(arr[mid]);
                    root.left = copy(l);
                    root.right = copy(r);
                    ret.add(root);
                }
            }
        }
        if(ret.isEmpty()) {
            ret.add(null);
        }
        return ret;
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

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 0; i <= 5; ++i) {
            System.out.println(sol.generateTrees(i).size());
        }
    }



    /*
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
    }*/




}
