package wr.leetcode.algo.integer_to_english_words;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static Map<Integer, String> dict = new HashMap<>();
    public static String[] bases = {"", "Thousand", "Million", "Billion" };
    static {
        dict.put(1, "One");
        dict.put(2, "Two");
        dict.put(3, "Three");
        dict.put(4, "Four");
        dict.put(5, "Five");
        dict.put(6, "Six");
        dict.put(7, "Seven");
        dict.put(8, "Eight");
        dict.put(9, "Nine");
        dict.put(10, "Ten");
        dict.put(11, "Eleven");
        dict.put(12, "Twelve");
        dict.put(13, "Thirteen");
        dict.put(14, "Fourteen");
        dict.put(15, "Fifteen");
        dict.put(16, "Sixteen");
        dict.put(17, "Seventeen");
        dict.put(18, "Eighteen");
        dict.put(19, "Nineteen");
        dict.put(20, "Twenty");
        dict.put(30, "Thirty");
        dict.put(40, "Forty");
        dict.put(50, "Fifty");
        dict.put(60, "Sixty");
        dict.put(70, "Seventy");
        dict.put(80, "Eighty");
        dict.put(90, "Ninety");
    }


    //value >= 0 && value < 999
    public String thousand(int value) {
        StringBuilder sb = new StringBuilder();
        if( value >= 100 ) {
            sb.append(dict.get(value/100));
            sb.append(" ");
            sb.append("Hundred");
            String sub = thousand(value%100);
            if (!sub.isEmpty()) {
                sb.append(" ");
                sb.append(sub);
            }
        } else if ( value > 20 ) {
            sb.append(dict.get(value/10 * 10));
            String sub = thousand(value%10);
            if(!sub.isEmpty()) {
                sb.append(" ");
                sb.append(sub);
            }
        } else if(value > 0) {
            sb.append(dict.get(value));
        }
        return sb.toString();
    }

    public String numberToWords(int x) {
        String ret = "Zero";
        if (x > 0) {
            List<String> groups = new LinkedList<>();
            int i = 0;
            while( x > 0) {
                int value = x % 1000;
                String base = bases[i++];
                x/= 1000;
                if(0 == value) {
                    continue;
                }
                String str = thousand(value);
                if(!base.isEmpty()) {
                    str = str + " "+ base;
                }
                groups.add(0, str);
            }
            ret = groups.stream().collect(Collectors.joining(" "));
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {
            123, 12345, 1234567, 0, 1234567890, 1000010, 1000
        };
        for(int ar : arr ) {
            System.out.println(sol.numberToWords(ar));
        }

    }





}
