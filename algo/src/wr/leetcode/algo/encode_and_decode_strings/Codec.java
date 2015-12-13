package wr.leetcode.algo.encode_and_decode_strings;

import java.util.LinkedList;
import java.util.List;

public class Codec {
    public static String LEFT = "HeaderLeft";
    public static String RIGHT = "HeaderRight";

    //GOOD: use special characters as boundary of length of a string
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int n = (null != str)?(str.length()):(-1);
            sb.append(LEFT + n + RIGHT);
            sb.append( (null == str)?(""):(str) );
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ret = new LinkedList<>();
        int n = s.length();
        int start = 0;
        while (start < n) {
            int i = s.indexOf(LEFT, start);
            int j = s.indexOf(RIGHT, start);
            i += LEFT.length();
            int len = Integer.parseInt(s.substring(i,j));
            j += RIGHT.length();
            String str;
            if(-1 == len) {
                str = null;
                start = j;
            } else {
                str = s.substring(j, j+len);
                start = j+len;
            }
            ret.add(str);
        }
        return ret;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new LinkedList<>();
        strs.add("abc");
        strs.add("bde");
        strs.add(Codec.LEFT);
        strs.add(null);
        strs.add(Codec.RIGHT);
        strs.add(Codec.LEFT + "3");
        List<String> back = codec.decode(codec.encode(strs));
        System.out.println(back);

    }
}
