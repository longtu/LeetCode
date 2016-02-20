package wr.leetcode.algo.airbnb;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvParser {
    private static final char QUOTE = '"';
    private static final char SEP = ',';

    public String parseCsv(String str) {
        StringBuilder sb = new StringBuilder();
        str = (null == str)?(""):(str);

        List<String> ret = new LinkedList<>();
        boolean inQute = false;

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (inQute) {
                if (ch == QUOTE) {
                    if ((i+1) < str.length() && QUOTE == str.charAt(i+1)) {
                        sb.append(QUOTE);
                        i++;
                    } else {//finishing quote
                        inQute = false;
                    }
                } else {
                    sb.append(ch);
                }
            } else {
                switch(ch) {
                    case QUOTE:
                        inQute = true;
                        break;
                    case SEP:
                        ret.add(sb.toString());
                        sb.setLength(0);
                        break;
                    default:
                        sb.append(ch);
                }
            }
        }
        ret.add(sb.toString());
        return ret.stream().collect(Collectors.joining("|"));
    }

    public static void main(String[] args) {
        CsvParser csvParser = new CsvParser();
        String [] tsts = {
                null,
                "",
                "f",
                "foo,",
                "foo,bar",
                "foo,,baz,,bar",
                "John,Smith,john.smith@gmail.com,Los Angeles,1",
                "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0",
                "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1",
                "\"\"\"Alexandra Alex\"\"\"",
                // "\"\"Alexandra Alex\"\"" is invalid input as any quote character in a filed should be two quoted characters
        };
        for (String tst : tsts) {
            System.out.println(csvParser.parseCsv(tst));
        }
    }
}
