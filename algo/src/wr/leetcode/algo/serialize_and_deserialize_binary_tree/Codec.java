package wr.leetcode.algo.serialize_and_deserialize_binary_tree;

import wr.leetcode.algo.TreeNode;
import wr.leetcode.algo.same_tree.Solution;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(null != root) {
            sb.append(root.val);
            sb.append('V');
            String left = serialize(root.left);
            sb.append(left.length());
            sb.append('L');
            sb.append(left);
            String right = serialize(root.right);
            sb.append(right.length());
            sb.append('R');
            sb.append(right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode node = null;
        if(!data.isEmpty()) {
            int i = data.indexOf('V');
            Integer key = Integer.parseInt(data.substring(0, i));
            int j = data.indexOf('L');
            int leftLen = Integer.parseInt(data.substring(i+1,j));
            TreeNode left = deserialize(data.substring(j+1, j+leftLen+1));
            String rightSub = data.substring(j+leftLen+1);
            int k = rightSub.indexOf('R');
            //BUG:  data.substring(j+leftLen+1).substring(0,k) instead of data.substring(j+leftLen+1, k)
            int rightLen = Integer.parseInt(rightSub.substring(0, k));
            TreeNode right = deserialize(rightSub.substring(k+1,k+rightLen+1));
            node = new TreeNode(key);
            node.left = left;
            node.right = right;
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
