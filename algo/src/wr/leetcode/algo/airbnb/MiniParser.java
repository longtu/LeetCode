package wr.leetcode.algo.airbnb;

import java.util.LinkedList;
import java.util.List;

class NestedIntList {
    private int value;
    private boolean isNumber;
    private List<NestedIntList> intList;

    public NestedIntList() {
        this(0, false, new LinkedList<>());
    }

    public NestedIntList(int value){
        this(value, true, null);
    }

    public NestedIntList(int value, boolean isNumber, List<NestedIntList> intList) {
        this.value = value;
        this.isNumber = isNumber;
        this.intList = intList;
    }

    public String toString() {
        if(isNumber) {
            return Integer.toString(value);
        } else {
            return intList.toString();
        }
    }

    public void add(NestedIntList node) {
        if(!isNumber){
            intList.add(node);
        } else {
            throw new IllegalArgumentException("Int value cannot be added");
        }
    }
}

public class MiniParser {
    public NestedIntList parse(String input) {
        NestedIntList ret = null;
        if (null != input && !input.isEmpty() ) {
            if(input.startsWith("[")) { //array
                ret = new NestedIntList();
                int n = input.length();
                int opens = 1;
                int lastPos = 1;
                for (int i = 1; i < n; ++i) {
                    char ch = input.charAt(i);
                    switch (ch) {
                        case '[': opens++; break;
                        case ']': opens--;
                            if(opens == 0) { //BUG: Very easy to forget this!!!
                                NestedIntList value = parse(input.substring(lastPos, i));
                                if(null != value){
                                    ret.add(value);
                                }
                            }
                            break;
                        case ',':
                            if (opens == 1) {
                                NestedIntList value = parse(input.substring(lastPos, i));
                                if(null != value){
                                    ret.add(value);
                                }
                                lastPos = i+1;
                            }
                            break;
                    }
                }
            } else {
                ret = new NestedIntList(Integer.parseInt(input));
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
            NestedIntList ret = parser.parse(str);
            System.out.println(ret);
        }
    }
}
