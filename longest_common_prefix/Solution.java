public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return null;
        char[] ret = strs[0].toCharArray();

        int commonLen = ret.length;
        for (int i = 1; i < strs.length; ++i) {
            char[] currStr = strs[i].toCharArray();
            int j = 0;
            for (j = 0; j < commonLen && j < currStr.length; ++j)
                if (ret[j] != currStr[j])
                    break;
            if (j < commonLen)
                commonLen = j;
        }
        return strs[0].substring(0, commonLen);
    }

    public static void main(String[] args) {
        String[] tests = {};
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(tests));
    }
}
