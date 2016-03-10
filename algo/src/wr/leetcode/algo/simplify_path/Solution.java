package wr.leetcode.algo.simplify_path;

import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    /*
    public String simplifyPath(String path) {
        if (null == path) {
            path = "/";
        }

        String[] segments = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String seg : segments) {
            if (seg.isEmpty() || seg.equals(".")) {
                continue;
            }
            if (seg.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(seg);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        int i = 0;
        while (!stack.isEmpty()) {
            if (i++ != 0) {
                sb.append("/");
            }
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }*/

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.simplifyPath("/home/"));
        System.out.println(sol.simplifyPath("/a/./b/../../c/"));
        System.out.println(sol.simplifyPath("/../"));
        System.out.println(sol.simplifyPath("/home//foo/"));

    }

    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        path = (null == path)?(""):(path);
        String[] intervals = path.split("/");

        for (String str : intervals) {
            switch (str) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!st.isEmpty()) {
                        st.pop();
                    }
                    break;
                default:
                    st.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : st) {
            sb.append("/");
            sb.append(str);
        }
        if(sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }

/*

    public String simplifyPath(String path) {

        if(null == path) {
            path = "/";
        }
        String[] paths = path.split("/");
        Stack<String> st = new Stack<>();
        for (String str: paths) {
            if(".".equals(str) || str.isEmpty()) {
                continue;
            } else if ("..".equals(str)) {
                if(!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(str);
            }
        }
        String ret = "/" + st.stream().collect(Collectors.joining("/"));
        return ret;
    }*/



}
