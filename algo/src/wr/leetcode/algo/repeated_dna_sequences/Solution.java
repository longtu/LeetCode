package wr.leetcode.algo.repeated_dna_sequences;

import java.util.*;

public class Solution {


    public int enCode(String str ) {

        int ret = 0;
        for ( int i = 0; i < str.length(); ++i) {
            ret <<= 2;
            int val;
            char ch = str.charAt(i);
            if('A' == ch) {
                val = 0;
            } else if ('T' == ch) {
                val = 1;
            } else if ('G' == ch) {
                val = 2;
            } else {
                val = 3;
            }
            ret |= val;
        }
        return ret;
    }


    public List<String> findRepeatedDnaSequences(String s) {
        //BUG: unique outputs

        Set<String> ret = new HashSet<>();
        Set<Integer> patterns = new HashSet<>();

        for (int i = 0; i < s.length(); ++i) {
            //BUG: i >= 9 instead of i > 9
            if( i >= 9) {
                String str = s.substring(i-9, i+1);
                Integer code = enCode(str);
                if(patterns.contains(code)){
                    ret.add(str);
                } else {
                    patterns.add(code);
                }
            }
        }
        return new LinkedList<>(ret);
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findRepeatedDnaSequences("AAAAAAAAAAAA"));
        System.out.println(sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /*
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> table = new HashSet<>();
        Set<String> ret = new TreeSet<>();
        LinkedList<Character> seq = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) {
            seq.add(s.charAt(i));
            if(i < 9) {
                continue;
            }
            if(i > 9) {
                seq.removeFirst();
            }
            int code = encode(seq);
            if(table.contains(code)) {
                ret.add(toStr(seq));
            } else {
                table.add(code);
            }
        }
        return new LinkedList<>(ret);

    }

    public String toStr(LinkedList<Character> seq) {
        StringBuilder sb = new StringBuilder();
        Iterator<Character> ite = seq.iterator();
        while(ite.hasNext()) {
            sb.append(ite.next());
        }
        return sb.toString();
    }

    public int encode( LinkedList<Character> seq ) {
        int ret = 0;
        Iterator<Character> ite = seq.iterator();
        while(ite.hasNext()) {
            char ch = ite.next();
            int twoDigit = 0;
            switch (ch) {
                case 'A': twoDigit = 0; break;
                case 'T': twoDigit = 1; break;
                case 'G': twoDigit = 2; break;
                case 'C': twoDigit = 3; break;
                default : throw new IllegalStateException("Invalid Input");
            }
            ret = (ret << 2) | twoDigit;
        }
        return ret;
    }*/
}
