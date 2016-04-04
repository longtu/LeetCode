package wr.leetcode.algo.Facebook;

import wr.leetcode.algo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class PrettyPrintBinaryTree {
    int height (TreeNode root) {
        if( null == root ) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) +1;
    }

    int width (int h) {
        return (1<<h) - 1;
    }

    public void prettyPrint(TreeNode root) {
        int h = height(root);
        if (null == root) {
            return;
        }
        Queue<Info> nextQ = new LinkedList<>();
        nextQ.offer(new Info(width(h-1), h, root));
        while(!nextQ.isEmpty()) {
            print(nextQ);
            Queue<Info> queue = nextQ;
            nextQ = new LinkedList<>();
            while(!queue.isEmpty()) {
                Info v = queue.poll();
                int nh = v.h-1;
                int nw = width(nh);
                if(nh >0) {
                    nextQ.offer(new Info( v.index - (nw-1)/2-1 ,nh, (null == v.node)? (null):(v.node.left)));
                    nextQ.offer(new Info( v.index + (nw-1)/2+1 ,nh, (null == v.node)? (null):(v.node.right)));
                }
            }
        }
    }

    public void print(Queue<Info> line) {
        int i = 0;
        for (Info info : line) {
            int j = info.index;
            while( i < j) {
                System.out.print(' ');
                i++;
            }
            System.out.print((null == info.node)?(" "):(info.node.val));
            i++;
        }
        System.out.println();
    }

    class Info {
        int index;
        int h;
        TreeNode node;

        public Info(int index, int h, TreeNode node) {
            this.index = index;
            this.h = h;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        /*
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        n4.left = n2;
        n4.right = n6;
        n2.left = n1;
        n2.right = n3;
        n6.left = n5;
        n6.right = n7;
        n7.right = n8; */

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.left = n1;
        n3.right = n4;
        n1.right = n2;
        n4.right = n5;

        PrettyPrintBinaryTree sol = new PrettyPrintBinaryTree();
        sol.prettyPrint(n3);
    }
}
