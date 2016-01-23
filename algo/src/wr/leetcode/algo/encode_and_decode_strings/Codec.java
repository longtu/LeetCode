package wr.leetcode.algo.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codec {
    /*
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
    }*/

    public static char SEP = '$';

    public String encode(List<String> strs) {
        return String.format("%s%s", header(strs), concat(strs));
    }

    String header(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(strs.size());

        for( String str : strs) {
            sb.append(SEP);
            sb.append(  (null==str)?(-1):(str.length()) );
        }
        sb.append(SEP);
        return sb.toString();
    }

    String concat(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            //BUG: serialize for null
            if(null != str) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public List<String> decode(String s) {

        int lengthIndex = s.indexOf(SEP);
        int stringCount = Integer.parseInt(s.substring(0, lengthIndex));
        ArrayList<String> data = new ArrayList<>(stringCount);

        if (stringCount > 0) {
            ArrayList<Integer> lengths = new ArrayList<>(stringCount);
            int payLoadStart = lengthIndex + 1;
            for (int i = 0; i < stringCount; ++i) {
                int start = payLoadStart;
                int end = s.indexOf(SEP, start);
                int len = Integer.parseInt(s.substring(start, end));
                lengths.add(len);
                payLoadStart = end + 1;
            }

            for (int i = 0; i < stringCount; ++i) {
                int len = lengths.get(i);
                String str;
                if (-1 == len) {
                    str = null;
                } else {
                    str = s.substring(payLoadStart, payLoadStart + len);
                    payLoadStart += len;
                }
                data.add(str);
            }
        }
        return data;
    }



    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> strs = new LinkedList<>();
        strs.add("abc");
        strs.add("bde");
        strs.add(String.valueOf(Codec.SEP));
        strs.add(null);
        strs.add(String.valueOf(Codec.SEP));
        strs.add('$' + "3");
        List<String> back = codec.decode(codec.encode(strs));
        System.out.println(back);

    }
}
