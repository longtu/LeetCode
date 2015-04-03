package wr.leetcode.algo.fraction_to_recurring_decimal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    public String fractionToDecimal(int num, int denom) {
        //overflow otherwise
        long numerator = num;
        long denominator = denom;

        LinkedList<String> ret = new LinkedList();
        if ((numerator < 0 && denominator > 0) ||
        		 (numerator > 0 && denominator < 0)) {
        	ret.add("-");
        }
        if (numerator < 0) {
        	numerator = -1 * numerator;
        }
        if (denominator < 0) {
        	denominator = -1 * denominator;
        }

        long major = numerator / denominator;
        long res = numerator % denominator;
        ret.add(String.valueOf(major));

        if(res > 0) {
        	ret.add(".");
        	Map<Long, Integer> history = new HashMap<>();
        	while (res > 0) {
        		res = res*10;
        		if(history.containsKey(res)) {
        			ret.add( history.get(res), "(" );
        			ret.add( ")" );
        			break;
        		} else {
        			history.put(res, ret.size());
        			ret.add(String.valueOf(res/denominator));
        			res = res%denominator;
        		}
        	}
        }

        StringBuilder sb = new StringBuilder();
        ret.forEach(sb::append);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println( sol.fractionToDecimal(2,3));
        System.out.println( sol.fractionToDecimal(1,2));
        System.out.println( sol.fractionToDecimal(2,1));


    }
}
