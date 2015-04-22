package wr.leetcode.algo.simplify_path;

import java.util.LinkedList;

public class Solution {
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
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.simplifyPath("/home/"));
        System.out.println(sol.simplifyPath("/a/./b/../../c/"));
        System.out.println(sol.simplifyPath("/../"));
        System.out.println(sol.simplifyPath("/home//foo/"));

    }
}
