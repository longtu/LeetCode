package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.prefs.NodeChangeEvent;

public class FindPathBetweenTwoNodes {

    //assuming two nodes are different and they are both in the tree
    List<TreeNode> findPath(TreeNode root, TreeNode left, TreeNode  right) {
        return findPathInfo(root, left, right).path;
    }

    /**
     * V1
     *
     */
    Info findPathInfo(TreeNode root, TreeNode left, TreeNode right) {
        Info ret = new Info(new LinkedList<>(), 0);
        if( null != root ) {
            Info leftInfo = findPathInfo(root.left, left, right);
            Info rightInfo = findPathInfo(root.right, left, right);
            if (leftInfo.found == 2) {
                ret = leftInfo;
            } else if (rightInfo.found == 2) {
                ret = rightInfo;
            } else if(leftInfo.found == 1 && rightInfo.found == 1) {
                List<TreeNode> path = leftInfo.path;
                //BUG: need to add myself
                path.add(root);
                LinkedList<TreeNode> rightPath = (LinkedList<TreeNode>) (rightInfo.path);
                while(!rightPath.isEmpty()) {
                    path.add(rightPath.removeLast());
                }
                ret = new Info(path, 2);
            } else if (leftInfo.found == 1 ) {
                ret = leftInfo;
                ret.path.add(root);
                if(root == left || root == right) {
                    ret.found += 1;
                }
            } else if (rightInfo.found == 1) {
                ret = rightInfo;
                ret.path.add(root);
                if(root == left || root == right) {
                    ret.found += 1;
                }
            } else if(root == left || root == right) {
                ret.found += 1;
                ret.path.add(root);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        FindPathBetweenTwoNodes sol = new FindPathBetweenTwoNodes();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        TreeNode root = n1;
        n1.left = n2;
        n2.right = n5;
        n2.left = n4;
        n1.right = n3;
        n3.left = n6;
        n3.right = n7;
        n6.right = n8;

        System.out.println(sol.findPath(root, n4, n5));
        System.out.println(sol.findPath(root, n4, n6));
        System.out.println(sol.findPath(root, n4, n3));
        System.out.println(sol.findPath(root, n4, n2));
        System.out.println(sol.findPath(root, n8, n5));

    }





    private static class Info {
        List<TreeNode> path;
        int found;

        public Info(List<TreeNode> path, int found) {
            this.path = path;
            this.found = found;
        }

    }

}