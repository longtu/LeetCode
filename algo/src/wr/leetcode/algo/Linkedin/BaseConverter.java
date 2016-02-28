package wr.leetcode.algo.Linkedin;

public class BaseConverter {

    //neglet negatives/spaces
    int convert(String input, int base)  {
        int ret = 0;
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);
            int val;
            if (ch <= '9' && ch >= '0') {
                val = ch - '0';
            } else {
                val = 10 + (ch - 'a');
            }
            ret *= base;
            ret += val;
        }
        return ret;
    }

    public static void main(String[] args) {
        BaseConverter solution = new BaseConverter();

        System.out.println(solution.convert("343432", 10));
        System.out.println(solution.convert("10010", 2));
        System.out.println(solution.convert("a1b", 16));
    }

}
