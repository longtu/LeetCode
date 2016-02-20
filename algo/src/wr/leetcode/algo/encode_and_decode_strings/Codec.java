package wr.leetcode.algo.encode_and_decode_strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Codec {


    public static char SEP = '#';

    /*
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
    }*/

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.stream().forEach( (s)-> {
                    if (s == null) {
                        sb.append(-1).append(SEP).append("");
                    } else {
                        sb.append(s.length()).append(SEP).append(s);
                    }
                }
        );
        return sb.toString();
    }

    public List<String> decode(String s) {
        char[] chars = s.toCharArray();
        List<String> ret = new LinkedList<>();

        int lastEnd = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == SEP) {
                int len = Integer.parseInt(s.substring(lastEnd, i));
                i++;
                if (len == -1) {
                    ret.add(null);
                    len = 0;
                } else {
                    ret.add(s.substring(i, i+len));
                }
                i = i+len;
                lastEnd = i;
            } else {
                i++;
            }
        }
        return ret;
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
