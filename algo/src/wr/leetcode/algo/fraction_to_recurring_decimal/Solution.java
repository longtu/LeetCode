package wr.leetcode.algo.fraction_to_recurring_decimal;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public String fractionToDecimal(int n, int d ) {

        //BUG: overflows!!!!
        long numer = n;
        long denom = d;

        String sign = "";
        if ( (numer < 0 && denom > 0) || (numer > 0 && denom < 0) ) {
            sign = "-";
        }
        numer = Math.abs(numer);
        denom = Math.abs(denom);

        return sign + decimal(numer, denom);
    }

    public String decimal( long numer, long denom) {

        boolean passDecimal = false;
        List<String> sb = new LinkedList<>();

        if( 0 == numer ){
            sb.add(Integer.toString(0));
        } else {
            Map<Long, Integer> history = new HashMap<>();
            while(numer > 0) {
                if(history.containsKey(numer)) {
                    sb.add(history.get(numer), "(");
                    sb.add(")");
                    break;
                }
                long res = numer/denom;
                long rem = numer%denom;
                sb.add(Long.toString(res));
                if( 0 != rem ) {
                    if(!passDecimal) {
                        sb.add(".");
                        passDecimal = true;
                    }
                    //Important to put into history only after decimal
                    //BUG: should be else
                    //if( passDecimal) {
                    //    history.put(numer, sb.size() - 1);
                    //}
                    else {
                        history.put(numer, sb.size() - 1);
                    }
                }
                rem = rem * 10;
                numer = rem;
            }
        }

        return sb.stream().collect(Collectors.joining());
    }


    /*
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

    public String fractionToDecimal(int numerator, int denominator) {
        long top = numerator;
        long below = denominator;
        boolean isNeg = false;
        if( (double)numerator / denominator < 0) {
            isNeg = true;
        }

        top = Math.abs(top);
        below = Math.abs(below);
        long integral = top / below;
        String decimal = decimal(top%below, below);
        return build(isNeg, integral, decimal);
    }

    public String decimal(long top, long below) {
        boolean isRecur = false;
        List<String> res = new LinkedList<>();
        Map<Long, Integer> history = new HashMap<>();

        while (0 != top) {
            top *= 10;
            if(history.containsKey(top)) {
                isRecur = true;
                break;
            }
            history.put(top, res.size());
            System.out.println(history);
            res.add( Long.toString(top/below) );
            top = top%below;
        }
        if(isRecur){
            res.add(history.get(top), "(");
            res.add(")");
        }

        StringBuilder sb = new StringBuilder();
        if(!res.isEmpty()) {
            sb.append(".");
            for (String s : res) {
                sb.append(s);
            }
        }
        return sb.toString();
    }

    public String build (boolean isNeg, long integ, String decimal ) {
        StringBuilder sb = new StringBuilder();
        if(isNeg) {
            sb.append("-");
        }
        sb.append(integ);
        sb.append(decimal);
        return sb.toString();
    }*/



    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println( sol.fractionToDecimal(2,3));
        System.out.println( sol.fractionToDecimal(1,2));
        System.out.println( sol.fractionToDecimal(2,1));
        System.out.println( sol.fractionToDecimal(1,300));
        System.out.println( sol.fractionToDecimal(100,66));
        System.out.println( sol.fractionToDecimal(0,-1));
        System.out.println( sol.fractionToDecimal(2,-1));
        System.out.println( sol.fractionToDecimal(-1, -2147483648));


    }
}
