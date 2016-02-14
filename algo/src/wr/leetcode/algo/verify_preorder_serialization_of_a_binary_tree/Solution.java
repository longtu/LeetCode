package wr.leetcode.algo.verify_preorder_serialization_of_a_binary_tree;

import java.util.Stack;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        preorder = (null == preorder) ? ("") : (preorder);
        String[] strs = preorder.split(",");
        int n = strs.length;
        boolean ret = false;
        if( n > 0 ) {
            Stack<Boolean[]> st = new Stack<>();
            for (int i = 0; i < n; ++i) {
                String str = strs[i];
                Boolean[] node = new Boolean[2];
                node[0] = false;
                node[1] = false;
                if ( st.isEmpty() ) {
                    if (i != 0) {
                        st.push(new Boolean[2]);
                        break;
                    } else if (!"#".equals(str)){
                        st.push(node);
                    }
                } else {
                    Boolean[] parent = st.peek();
                    if (!parent[0]) {
                        parent[0] = true;
                    } else if (!parent[1]){
                        parent[1] = true;
                    } else {
                        break;
                    }
                    if(!"#".equals(str)) {
                        st.push(node);
                    }
                }
                while(!st.isEmpty()) {
                    Boolean[] delete = st.peek();
                    if (delete[0] && delete[1]) {
                        st.pop();
                    } else {//BUG: break from while!
                        break;
                    }
                }
            }
            ret = st.isEmpty();
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        for (String str : new String[] {
                "9,3,4,#,#,1,#,#,2,#,6,#,#",
                "1,#",
                "9,#,#,1",
                "#",
                "1",
                "1,#,#,#",
                "1,2,3,4,5,6",
                ""
        }) {
            System.out.println(sol.isValidSerialization(str));
        }
    }
}
