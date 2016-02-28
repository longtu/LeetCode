package wr.leetcode.algo.Linkedin;

import java.util.Stack;

/**
 * Consider this string representation for binary trees. Each node is of the form (lr), where l represents the left child and r represents the right child. If l is the character 0, then there is no left child. Similarly, if r is the character 0, then there is no right child. Otherwise, the child can be a node of the form (lr), and the representation continues recursively.
 For example: (00) is a tree that consists of one node. ((00)0) is a two-node tree in which the root has a left child, and the left child is a leaf. And ((00)(00)) is a three-node tree, with a root, a left and a right child.

 Write a function that takes as input such a string, and returns -1 if the string is malformed, and the depth of the tree if the string is well-formed.

 For instance:

 find_depth('(00)') -> 0
 find_depth('((00)0)') -> 1
 find_depth('((00)(00))') -> 1
 find_depth('((00)(0(00)))') -> 2
 find_depth('((00)(0(0(00))))') -> 3
 find_depth('x') -> -1
 find_depth('0') -> -1
 find_depth('()') -> -1
 find_depth('(0)') -> -1
 find_depth('(00)x') -> -1
 find_depth('(0p)') -> -1
 */


public class TreeDepthFinder {

    /**
     * Method 1 : stack
     */
    public int depth (String tree) {
        int ret = -1;
        if(!tree.isEmpty()) {
            int max = 0;
            Stack<Integer> st = new Stack<>();
            boolean illegal = false;
            char[] arr = tree.toCharArray();
            int level = 0;

            for (int i = 0; i <= arr.length; ++i) {
                if (i == arr.length){
                    illegal = !st.isEmpty();
                } else {
                    switch(arr[i]) {
                        case '(':
                            level++;
                            st.push(i);
                            max = Math.max(max, level);
                            break;
                        case ')':
                            if(st.isEmpty()) {
                                illegal = true;
                            } else {
                                int zeros = 0;
                                while(!st.isEmpty() && arr[st.peek()] == '0') {
                                    zeros++;
                                    st.pop();
                                }
                                if (zeros > 2 || st.isEmpty()) {
                                    illegal = true;
                                } else {
                                    int len = i- st.peek() - 1;
                                    if (2 == len%3 ) {
                                        st.pop();
                                        level--;
                                    } else {
                                        illegal = true;
                                    }
                                }
                            }
                            break;
                        case '0':
                            st.push(i);
                            break;
                        default:
                            illegal = true;
                    }
                }
                if (illegal) {
                    max = 0;
                    break;
                }
            }
            ret = max - 1;
        }
        return ret;
    }

    /**
     * Replace using regular expresion.
     */
    public int depth0 (String tree) {
        int ret = -1;
        int times = 0;
        while (!tree.isEmpty()) {
            boolean matches = tree.matches(".*\\(00\\).*");
            if (matches) {
                tree = tree.replaceAll("\\(00\\)", "0");
                times++;
            } else {
                break;
            }

            if (tree.equals("0")) {
                ret = times -1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeDepthFinder solution = new TreeDepthFinder();

        for (String tst : new String[] {
                "(00)",
                "((00)0)",
                "((00)(00))",
                "((00)(0(00)))",
                "((00)(0(0(00))))",
                "x",
                "0",
                "()",
                "(0)",
                "(00)x",
                "(0p)",
                "(00000)"
        }) {
            System.out.print( tst + " : " );
            System.out.print(solution.depth(tst) + ", ");
            System.out.println(solution.depth0(tst));
        }
    }
}
