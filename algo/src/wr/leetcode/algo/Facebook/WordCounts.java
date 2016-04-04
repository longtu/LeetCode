package wr.leetcode.algo.Facebook;

public class WordCounts {
    static int countOfWords(String text) {
        int count = 0;
        text = (null == text)?(""):(text);
        int n = text.length();
        int i = 0;
        while (i < n) {
            while(i < n && text.charAt(i) == ' ') i++;
            if(i<n) {
                count ++;
                while(i < n && text.charAt(i) != ' ') i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] tests = {
          null, "", "a", " a", " a ", "a ",
                " a   bc d e  "
        };
        for (String t : tests)
            System.out.println(countOfWords(t));
    }

}
