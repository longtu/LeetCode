package wr.leetcode.algo.Facebook;

import java.util.*;

public class StringSort {
    public List<String> sort(List<String> input, String order) {

        Map<Character, Character> mapping = new HashMap<>();
        char[] arr = order.toCharArray();
        for (int i = 0; i < arr.length; ++i) {
            mapping.put( arr[i], (char)('a'+ i));
        }
        Collections.sort(input, (a, b) -> (map(a, mapping).compareTo(map(b, mapping))));
        return input;
    }

    public String map(String str, Map<Character, Character> mapping ) {
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            sb.append(mapping.get(ch));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringSort solution = new StringSort();

        List<String> input = Arrays.asList("face", "ball", "apple", "art", "ah");
        System.out.println(solution.sort(
                input,
                //"abcefhlprt"
                "trplhfecba"
        ));

    }
}
