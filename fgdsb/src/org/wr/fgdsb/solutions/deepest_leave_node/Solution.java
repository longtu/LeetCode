package org.wr.fgdsb.solutions.deepest_leave_node;

import org.wr.fgdsb.solutions.TreeNode;


/**
 * clarify what is deepest left!!!
 */
public class Solution {

    public int deepestLeft(TreeNode root) {
        return deepestLeft(root, 0).value;
    }

    Info deepestLeft(TreeNode root, int depth) {
        if( null == root) {
            throw new IllegalArgumentException();
        }
        if(isLeaf(root)) return new Info(depth, root.val);
        int d = 0, v = root.val;

        if (null != root.left) {
            Info leftInfo = deepestLeft(root.left, depth+1);
            if(leftInfo.depth > d) {
                d = leftInfo.depth;
                v = leftInfo.value;
            }
        }

        if(null != root.right && !isLeaf(root.right)) {
            Info rightInfo = deepestLeft(root.right, depth + 1);
            if(rightInfo.depth > d) {
                d = rightInfo.depth;
                v = rightInfo.value;
            }
        }
        return new Info(d, v);
    }

    public boolean isLeaf(TreeNode node) {
        return (null != node && node.left == null && node.right == null);
    }

    static class Info {
        int depth;
        int value;

        public Info(int depth, int value) {
            this.depth = depth;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n5.right = n6;

        Solution sol = new Solution();
        System.out.println(sol.deepestLeft(n1));
        System.out.println(sol.deepestLeft(n5));
    }
}
