package wr.leetcode.algo.expression_add_operators;

import java.util.LinkedList;
import java.util.List;


//TODO: divide and conquer solution:
//http://bookshadow.com/weblog/2015/09/16/leetcode-expression-add-operators/

public class Solution {

    public boolean isLeadingZero(String num) {
        long value = Long.parseLong(num);
        return (!num.equals(Long.toString(value)));

    }

    public List<String> addOperators(String num, int target) {
        List<String> ret = addOperators(num, target,1);
        return ret;
    }

    public List<String> addOperators(String num, long target, long factor) {
        List<String> ret = new LinkedList<>();
        /*BUG: INPUT CHECK SORRY*/
        if(null == num || num.isEmpty()) {
            return ret;
        }
        /* BUG: HERE, should not return but move on
        if(isLeadingZero(num)) {
            System.out.println(num);
            return ret;
        }*/
        long val = Long.parseLong(num);
        if(target == val * factor) {
            /*BUG: instead check should be here*/
            if(!isLeadingZero(num)) {
                ret.add(num);
            }
        }

        for (int i = 1; i < num.length(); ++i) {
            String left = num.substring(0, i);
            String right = num.substring(i, num.length());
            if(isLeadingZero(right)) {
                continue;
            }
            long rv = Long.parseLong(right) * factor;
            String rightExpr = right;

            for (String sub : addOperators(left, target - rv, 1)) {
                ret.add(sub + "+" + rightExpr);
            }
            for (String sub : addOperators(left, target + rv, 1)) {
                ret.add(sub + "-" + rightExpr);
            }
            for (String sub : addOperators(left, target,rv)) {
                ret.add(sub + "*" + rightExpr);
            }
        }
        return ret;
    }


/*
    public List<String> addOperators0(String num, int target) {

        List<String> ret = new LinkedList<>();
        for (int i = 1; i <= num.length(); ++i) {
            String value = num.substring(0, i);
            if(hasLeadingZeros(value)){
                continue;
            }
            long longValue = Long.parseLong(value);
            ret.addAll(addOperators(value, num.substring(i), 0,
                    null, longValue ,target));
        }
        return ret;
    }

    boolean hasLeadingZeros( String str) {
        long value = Long.parseLong(str);
        return (!str.equals(Long.toString(value)));
    }

    public List<String> addOperators( String sb, String num, long pOperand,
        String pOperator, long value, long target ) {
        List<String> ret = new LinkedList<>();
        if(num.isEmpty() && value == target) {
            ret.add(sb.toString());
        } else {
            for (int i = 1; i <= num.length(); ++i) {
                if(hasLeadingZeros(num.substring(0, i))){
                    continue;
                }
                long right = Long.parseLong(num.substring(0,i));
                ret.addAll( addOperators(sb + "+" + right, num.substring(i),
                    right, "+", value + right, target) );
                ret.addAll( addOperators(sb + "-" + right, num.substring(i),
                    right, "-", value - right, target) );
                ret.addAll(addOperators(sb + "*" + right, num.substring(i),
                        right * pOperand, pOperator, nextValue(value, pOperand, pOperator, right),
                     target) );
            }
        }
        return ret;
    }

    public long nextValue( long value, long pOperand, String pOperator, long right) {
        long ret  = 0;
        if(null == pOperator || pOperator.equals("*")) {
            ret = value * right;
        } else if (pOperator.equals("+")) {
            ret = value - pOperand + pOperand * right;
        } else if (pOperator.equals("-")) {
            ret = value + pOperand - pOperand * right;
        } else {
            throw new IllegalStateException("Error input!");
        }
        return ret;
    }*/


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addOperators("123",6) );
        System.out.println(sol.addOperators("232",8) );
        System.out.println(sol.addOperators("105",5) );
        System.out.println(sol.addOperators("00",0) );
        System.out.println(sol.addOperators("3456237490",9191) );
    }

}
