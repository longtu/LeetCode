package wr.leetcode.algo.binary_tree_paths;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    /*
    public List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, new LinkedList<>());
    }

    public List<String> binaryTreePaths(TreeNode root, LinkedList<Integer> path) {
        List<String> ret = new LinkedList<>();
        if (null == root) {
            return ret;
        }

        path.add(root.val);
        if( null == root.left && null == root.right) {
            String myPath = path.stream()
                    .map(e -> Integer.toString(e))
                    .collect(Collectors.joining("->"));
            ret.add(myPath);
        }
        if( null != root.left ) {
            ret.addAll(binaryTreePaths(root.left, path));
        }
        if( null != root.right ) {
            ret.addAll(binaryTreePaths(root.right, path));
        }
        path.removeLast();
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.binaryTreePaths(new TreeNode(1)));
        System.out.println(sol.binaryTreePaths(null));

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left = node2;
        node2.right = new TreeNode(5);
        System.out.println(sol.binaryTreePaths(node1));

    }
    */

    public List<List<TreeNode>> binaryTreePathsNodes(TreeNode root) {
        List<List<TreeNode>> ret = new LinkedList<>();
        if( null != root) {
            if(null == root.left && null == root.right) {
                List<TreeNode> r = new LinkedList<>();
                r.add(root);
                ret.add(r);
            } else {
                if(null != root.left) {
                    List<List<TreeNode>> subs = binaryTreePathsNodes(root.left);
                    for (List<TreeNode> sub : subs) {
                        List<TreeNode> rr = new LinkedList<>(sub);
                        rr.add(0, root);
                        ret.add(rr);
                    }
                }
                if(null != root.right) {
                    List<List<TreeNode>> subs = binaryTreePathsNodes(root.right);
                    for (List<TreeNode> sub : subs) {
                        List<TreeNode> rr = new LinkedList<>(sub);
                        rr.add(0, root);
                        ret.add(rr);
                    }
                }
            }
        }
        return ret;
    }

    public String toString(List<TreeNode> list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (TreeNode node : list) {
            if( 0 != i++) {
                sb.append("->");
            }
            sb.append(node.val);
        }
        return sb.toString();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<List<TreeNode>> nodesList = binaryTreePathsNodes(root);
        return nodesList.stream()
                    .map(this::toString)
                    .collect(Collectors.toList());
    }
}
