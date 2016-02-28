package wr.leetcode.algo.Linkedin;

import wr.leetcode.algo.TreeNode;
import wr.leetcode.algo.serialize_and_deserialize_binary_tree.Codec;

import java.util.*;

public class ParentChildTree {

    /**
     * Represents a pair relation between one parent node and one child node inside a binary tree
     * If the _parent is null, it represents the ROOT node
     */
    public static class Relation {
        public Integer parent;
        public Integer child;
        public boolean isLeft;

        public Relation(Integer child, Integer parent, boolean isLeft) {
            this.parent = parent;
            this.child = child;
            this.isLeft = isLeft;
        }
    }


    /**
     * Implement a method to build a tree from a list of parent-child relationships
     * And return the root Node of the tree
     */
    public static TreeNode buildTree (List<Relation> data)
    {
        Map<Integer, List<Relation>> relations = new HashMap<>();

        Integer root = null;
        for (Relation relation : data) {
            Integer parent = relation.parent;
            if (parent == null) {
                root = relation.child;
                continue;
            }
            List<Relation> childrens = relations.getOrDefault(parent, new LinkedList<>());
            childrens.add(relation);
            relations.put(parent, childrens);
        }

        return  tree(relations, root);
    }

    public static TreeNode tree (Map<Integer, List<Relation>> data, Integer key){
        if (null == key) {
            return null;
        }

        TreeNode node = new TreeNode(key);
        List<Relation> relations = data.getOrDefault(key, new LinkedList<>());
        for (Relation r : relations) {
            if (r.isLeft) {
                node.left = tree(data, r.child);
            } else {
                node.right = tree(data, r.child);
            }
        }
        return node;
    }


    public static void main(String[] args) {

        List<Relation> input = Arrays.asList(new Relation[] {
                new Relation(15, 20, true),
                new Relation(19, 80, true),
                new Relation(17, 20, false),
                new Relation(16, 80, false),
                new Relation(80, 50, false),
                new Relation(50, null, false),
                new Relation(20, 50, true),
        });

        TreeNode tree = buildTree(input);
        Codec codec = new Codec();
        System.out.println(codec.serialize(tree));
    }




}
