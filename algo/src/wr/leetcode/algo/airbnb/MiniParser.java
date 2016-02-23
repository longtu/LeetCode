package wr.leetcode.algo.airbnb;

import java.util.LinkedList;
import java.util.List;

class IntOrList {
    private int value;
    private boolean isInt;
    private List<IntOrList> intList;

    public IntOrList() {
        this(0, false, new LinkedList<>());
    }

    public IntOrList(int value){
        this(value, true, null);
    }

    public IntOrList(int value, boolean isInt, List<IntOrList> intList) {
        this.value = value;
        this.isInt = isInt;
        this.intList = intList;
    }

    public String toString() {
        if(isInt) {
            return Integer.toString(value);
        } else {
            return intList.toString();
        }
    }

    public void add(IntOrList node) {
        if(!isInt){
            intList.add(node);
        } else {
            throw new IllegalArgumentException("Int value cannot be added");
        }
    }
}

public class MiniParser {
    public IntOrList parse(String input) {
        IntOrList ret = null;
        if (null != input && !input.isEmpty() ) {
            if(input.startsWith("[")) { //array
                ret = new IntOrList();
                int n = input.length();
                int opens = 1;
                int lastPos = 1;
                for (int i = 1; i < n; ++i) {
                    char ch = input.charAt(i);
                    switch (ch) {
                        case '[': opens++; break;
                        case ']': opens--;
                            if(opens == 0) { //BUG: Very easy to forget this!!!
                                IntOrList value = parse(input.substring(lastPos, i));
                                if(null != value){
                                    ret.add(value);
                                }
                            }
                            break;
                        case ',':
                            if (opens == 1) {
                                IntOrList value = parse(input.substring(lastPos, i));
                                if(null != value){
                                    ret.add(value);
                                }
                                lastPos = i+1;
                            }
                            break;
                    }
                }
            } else {
                ret = new IntOrList(Integer.parseInt(input));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        MiniParser parser = new MiniParser();
        String[] strs = {
                "324",
                "",
                "[]",
                "[[],3]",
                "[123,456,[788,799,833],[[]],10,[]]"
        };
        for (String str : strs) {
            IntOrList ret = parser.parse(str);
            System.out.println(ret);
        }
    }
}
