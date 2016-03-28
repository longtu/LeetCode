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

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        int base = 0;
        while( num > 0) {
            if (num %1000 > 0) {
                String val = processGroup(num%1000);
                if (!bases[base].isEmpty()) {
                    val = val + " " + bases[base];
                }
                if(sb.length() > 0) {
                    sb.insert(0, " ");
                }
                sb.insert(0, val);
            }
            base += 1;
            num/=1000;
        }
        return (sb.length() == 0)?("Zero"):(sb.toString());
    }

    public String processGroup (int num) {
        String ret = "";
        if (num >= 100) {
            ret = dict.get(num/100) + " Hundred";
            if( num%100 > 0 ) {
                ret = ret + " " + processGroup(num%100);
            }
        } else if (num > 20) {
            ret = dict.get(num/10*10);
            if ( num%10 > 0 ) {
                ret = ret + " " + processGroup(num%10);
            }
        } else if (num > 0) {
            ret = dict.get(num);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int [] arr = {
            123, 12345, 1234567, 0, 1234567890, 1000010, 1000, 23
        };
        for(int ar : arr ) {
            System.out.println(sol.numberToWords(ar));
        }

    }





}
