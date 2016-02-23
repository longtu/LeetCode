package wr.leetcode.algo.airbnb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SingleQuoteCSV {

    public String parseCsv(List<List<String>> input) {
        List<String> ret = new LinkedList<>();

        for (List<String> strs : input) {
            List<String> line = new LinkedList<>();
            for (String str : strs) {
                line.add(str.substring(1,str.length()-1));
            }
            ret.add(line.stream().collect(Collectors.joining(",")));
        }
        return ret.stream().collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        String[][] arr = {{"\"John\"", "\"Smith\"", "\"john.smith@gmail.com\"", "\"Los Angeles\"", "\"1\""},
                {"\"Jane\"", "\"Roberts\"", "\"janer@msn.com\"", "\"San Francisco, CA\"", "\"0\""},
                {"\"Alexandra “Alex”\"", "\"Menendez\"", "\"alex.menendez@gmail.com\"", "\"Miami\"", "\"1\""}};

        List<List<String>> input = new LinkedList<>();
        for (String[] line: arr ){
            input.add(Arrays.asList(line));
        }

        SingleQuoteCSV sol = new SingleQuoteCSV();
        System.out.println(sol.parseCsv(input));

    }
}
