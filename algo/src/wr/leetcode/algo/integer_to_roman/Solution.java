package wr.leetcode.algo.integer_to_roman;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Map<Integer, Character> table() {
        Map<Integer, Character> dict = new HashMap<>();
        dict.put(1, 'I');
        dict.put(5, 'V');
        dict.put(10, 'X');
        dict.put(50, 'L');
        dict.put(100, 'C');
        dict.put(500, 'D');
        dict.put(1000, 'M');
        return dict;
    }

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> table = table();

        for (int mod = 1000; mod > 0; mod /= 10) {
            int val = num / mod;
            if(4 == val || 9 == val) {
                sb.append( table.get(mod) );
                sb.append( table.get( (val+1)*mod ));
            } else {
                if(val >=5 ){
                    sb.append(table.get(mod*5));
                    val -= 5;
                }
                while(val-- > 0) {
                    sb.append(table.get(mod));
                }
            }
            num %= mod;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        for (int i : new int[] {
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20,
                501, 550, 530, 707, 890, 1500, 1800, 900,
                88
        }) {
            System.out.println(sol.intToRoman(i));
        }
    }
}
