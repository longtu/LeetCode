package wr.leetcode.algo.integer_to_english_words;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    Map<Integer, String> converter = convertMap();


    public Map<Integer, String> convertMap() {
        Map<Integer, String> ret = new HashMap<>();
            ret.put(0, "Zero");
            ret.put(1, "One");
            ret.put(2, "Two");
            ret.put(3, "Three");
            ret.put(4, "Four");
            ret.put(5, "Five");
            ret.put(6, "Six");
            ret.put(7, "Seven");
            ret.put(8, "Eight");
            ret.put(9, "Nine");
            ret.put(10, "Ten");
            ret.put(11, "Eleven");
            ret.put(12, "Twelve");
            ret.put(13, "Thirteen");
            ret.put(14, "Fourteen");
            ret.put(15, "Fifteen");
            ret.put(16, "Sixteen");
            ret.put(17, "Seventeen");
            ret.put(18, "Eighteen");
            ret.put(19, "Nineteen");
            ret.put(20, "Twenty");
            ret.put(30, "Thirty");
            ret.put(40, "Forty");
            ret.put(50, "Fifty");
            ret.put(60, "Sixty");
            ret.put(70, "Seventy");
            ret.put(80, "Eighty");
            ret.put(90, "Ninety");
            ret.put(100, "Hundred");
            ret.put(1000, "Thousand");
            ret.put(1000000, "Million");
            ret.put(1000000000, "Billion");
        return ret;
    }

    public String numberToWords(int num) {

        List<String> ret = new LinkedList<>();

        if( 0 == num ) {
            ret.add(converter.get(num));
        } else {
            int bilns = num / 1000000000;
            if(0 != bilns) {
                ret.add(convertBlock(bilns%1000));
                ret.add("Billion");
            }
            int milns = (num % 1000000000);
            milns = milns/1000000;
            if(0 != milns) {
                ret.add(convertBlock(milns));
                ret.add("Million");
            }
            int thsns = num % 1000000;
            thsns = thsns/1000;
            if(0 != thsns) {
                ret.add(convertBlock(thsns));
                ret.add("Thousand");
            }
            if(0 != num%1000) {
                ret.add(convertBlock(num % 1000));
            }
        }
        return ret.stream().collect(Collectors.joining(" "));
    }

    public String convertBlock( int block) {
        //block <= 999
        int hdrs = block/100;

        List<String> ret = new LinkedList<>();

        if(hdrs != 0) {
            ret.add(converter.get(hdrs));
            ret.add(converter.get(100));
        }
        int twoDigits = block%100;
        if(0 != twoDigits) {
            if(converter.containsKey(twoDigits)) {
                ret.add(converter.get(twoDigits));
            } else {
                int tens = (twoDigits)/10*10;
                ret.add(converter.get(tens));
                int ones = (twoDigits)%10;
                if(0 != ones) {
                    ret.add(converter.get(ones));
                }
            }
        }
        return ret.stream().collect(Collectors.joining(" "));
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
