package wr.leetcode.algo.serialize_and_deserialize_binary_tree;

import wr.leetcode.algo.TreeNode;
import wr.leetcode.algo.same_tree.Solution;

import java.util.Arrays;

public class Codec {
    public static String SEP = "#";

    /*
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        String left = "";
        String right = "";
        String val = "";
        if(null != root) {
            left = serialize(root.left);
            right = serialize(root.right);
            val = Integer.toString(root.val);
            len = left.length() + right.length() + val.length();
        }
        sb.append(len);
        sb.append(SEP);
        sb.append(left);
        sb.append(right);
        sb.append(val);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int i = data.indexOf(SEP);
        int len = Integer.parseInt(data.substring(0, i));
        TreeNode node = null;
        if (0 != len) {
            node = new TreeNode(-1);
            i++;
            int start = i;

            int sepIndex = data.indexOf(SEP, i);
            int l = Integer.parseInt(data.substring(i, sepIndex));
            node.left = deserialize(data.substring(i, sepIndex + 1 + l));

            i = sepIndex + 1 + l;
            sepIndex = data.indexOf(SEP, i);
            l = Integer.parseInt(data.substring(i, sepIndex));
            node.right = deserialize(data.substring(i, sepIndex + 1 + l));

            i = sepIndex + 1 + l;
            String valStr = data.substring(i, start + len);
            node.val = Integer.parseInt(valStr);
        }
        return node;
    }*/

    // Encodes a tree to a single string.
    public void serialize(TreeNode root, StringBuilder sb) {
        if( null == root ) {
            sb.append("null");
            sb.append(SEP);
        } else {
            sb.append(root.val);
            sb.append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] nodes = data.split( SEP );
        System.out.println(Arrays.toString(nodes));
        int[] index = new int[1];
        index[0] = 0;
        return deserialize(nodes, index);
    }

    public TreeNode deserialize(String[] strs, int [] index) {
        TreeNode node = null;
        String str = strs[index[0]];
        if ( !"null".equals(str) ) {
            node = new TreeNode(Integer.parseInt(str));
            index[0]++;
            node.left = deserialize(strs, index);
            index[0]++;
            node.right = deserialize(strs, index);
        }
        return node;
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
