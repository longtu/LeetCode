package wr.leetcode.algo.serialize_and_deserialize_binary_tree;

import wr.leetcode.algo.TreeNode;
import wr.leetcode.algo.same_tree.Solution;

import java.util.Arrays;

public class Codec {
    public static String SEP = ",";
    public static String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if( null == root ) {
            sb.append(NULL);
            sb.append(SEP);
        } else {
            sb.append(root.val);
            sb.append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public TreeNode deserialize(String data) {
        int[] index = new int[1];
        String [] nodes = data.split(SEP);
        return deserialize(nodes, index);
    }

    public TreeNode deserialize(String[] data, int[] index) {
        TreeNode ret = null;
        int i = index[0];
        String str = data[i];
        index[0]++;
        if ( !str.equals(NULL) ) {
            ret = new TreeNode(Integer.parseInt(str));
            ret.left = deserialize(data, index);
            ret.right = deserialize(data, index);
        }
        return ret;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        Solution sol = new wr.leetcode.algo.same_tree.Solution();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        one.right = three;
        three.right = four;

        TreeNode [] arr = {null, four, three, two, one};
        //TreeNode [] arr = {three};

        for (TreeNode root : arr) {

            String data = codec.serialize(root);
            System.out.println(data);
            TreeNode copy = codec.deserialize(data);
            System.out.println(sol.isSameTree(root, copy));
        }

    }
}

class Codec2{
    public static final String NULL = "NULL";
    public static final String SPLIT = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if ( null == root ) {
            sb.append(NULL);
            sb.append(SPLIT);
        } else {
            sb.append(root.val);
            sb.append(SPLIT);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SPLIT);
        int[] index = new int[0];
        return deserialize(nodes, index);
    }

    public TreeNode deserialize(String[] nodes, int[] index) {
        TreeNode ret = null;
        String node = nodes[index[0]];
        if (!NULL.equals(node)) {
            Integer val = Integer.parseInt(node);
            ret = new TreeNode(val);
            index[0]++;
            ret.left = deserialize(nodes, index);
            index[0]++;
            ret.right = deserialize(nodes, index);
        }
        return ret;
    }

        }
