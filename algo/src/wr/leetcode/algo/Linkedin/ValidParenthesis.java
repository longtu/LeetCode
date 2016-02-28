package wr.leetcode.algo.Linkedin;

public class ValidParenthesis {
    public boolean matched(String s) {
        // Implementation here
        int len = s.length();
        if (len == 0) {
            return true;
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '('){
                count++;
            } else if (s.charAt(i) == ')'){
                if(count <= 0) {
                    return false;
                }
                count--;
            }
        }
        return count == 0;
    }


}
