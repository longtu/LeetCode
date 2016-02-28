package wr.leetcode.algo.valid_number;

public class Solution {

    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if(s.isEmpty()) {
            return false;
        }
        int ePos = s.indexOf('e');
        if (ePos == -1) {
            return isValidNumberWithoutE(s);
        }
        return isValidNumberWithoutE(s.substring(0, ePos))
                && isSignedInteger(s.substring(ePos + 1));
    }

    public boolean isValidNumberWithoutE(String s) {
        if (s.isEmpty()) {
            return false;
        }
        int pPos = s.indexOf('.');
        if(pPos == -1) {
            return isSignedInteger(s);
        }

        String left = s.substring(0, pPos);
        String right = s.substring(pPos+1);
        return
                (isEmptyOrSignOrSingedInteger(left) && isPosInteger(right)) ||
                (isSignedInteger(left)&& right.isEmpty());
    }

    public boolean isPosInteger(String s) {
        boolean ret = false;
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if( ch < '0' || ch > '9') {
                return false;
            } else {
                ret = true;
            }
        }
        return ret;
    }

    public boolean isSign(String s) {
        return s.equals("+") || s.equals("-");
    }

    public boolean isSignedInteger(String s) {
        if(s.isEmpty()){
            return false;
        }
        return isPosInteger(s) ||
                (isSign(s.substring(0,1)) && isPosInteger(s.substring(1)));
    }

    public boolean isSignOrSignedInteger(String s) {
        return isSign(s) || isSignedInteger(s);
    }

    public boolean isEmptyOrSignOrSingedInteger(String s) {
        return s.isEmpty() || isSignOrSignedInteger(s);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        for (String tst : new String[] {
                "0",
                " 0.1 ",
                "abc",
                "1 a",
                "2e10",
                ".-4",
                "+.8"
        }) {
            System.out.println( tst + " : " + sol.isNumber(tst));
        }
    }

}
