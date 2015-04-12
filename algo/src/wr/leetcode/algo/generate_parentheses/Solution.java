package wr.leetcode.algo.generate_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList();
        if(0 == n) {
            ret.add("");
            return ret;
        } else if(n > 0) {
            for (int left = 0; left < n; ++ left) {
                List<String> lefts = generateParenthesis(left);
                List<String> rights = generateParenthesis(n - left - 1);
                for (String l : lefts)
                    for(String r: rights) {
                        StringBuilder sb = new StringBuilder("(");
                        sb.append(l);
                        sb.append(")");
                        sb.append(r);
                        ret.add(sb.toString());
                    }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));
    }
}