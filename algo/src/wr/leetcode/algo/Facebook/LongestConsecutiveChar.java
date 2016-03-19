package wr.leetcode.algo.Facebook;

import java.util.LinkedList;
import java.util.List;

public class LongestConsecutiveChar {
    public List<Character> longestConsecutiveChar( String str ) {
        List<Character> ret = new LinkedList<>();
        char[] chars = str.toCharArray();

        if (chars.length > 0) {
            Character key = null;
            int count = 0;
            int max = 0;

            for (int i = 0; i < chars.length; ++i) {
                char ch = chars[i];
                //BUG ignore spaces
                if(ch == ' ') {
                    continue;
                }
                if (null != key && key == ch) {
                    count ++;
                } else {
                    key = ch;
                    count = 1;
                }
                if (count == max) {
                    ret.add(ch);
                } else if (count > max){
                    ret.clear();
                    ret.add(ch);
                    max = count;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String [] tests = {
                "this is a test sentence",
                "thiis iss a teest seentennce",
                "thiiis iss aa teeest seentennnce",
                "thiiiis iss a teeest seeentennncccce",
                "aaabcccccddddddd"
        };

        LongestConsecutiveChar sol = new LongestConsecutiveChar();

        for (String test : tests) {
            System.out.println(sol.longestConsecutiveChar(test));
        }
    }
}


