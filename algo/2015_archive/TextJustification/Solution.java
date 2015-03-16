import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {

        ArrayList<String> res = new ArrayList<String>();
        if (words == null || words.length == 0)
            return res;

        int[] wordLens = getWordLens(words);
        boolean firstOfLine = true;
        boolean lineFinished = false;
        int remaining = L;
        int wordLenSum = 0;
        List<String> currLine = new ArrayList<String>();
        for (int i = 0; i < words.length;) {
            if (!lineFinished) {
                if (firstOfLine) {
                    firstOfLine = false;
                    remaining -= wordLens[i];
                    currLine.add(words[i]);
                    wordLenSum += wordLens[i];
                    ++i;
                } else if (remaining >= wordLens[i] + 1) {
                    remaining -= (wordLens[i] + 1);
                    currLine.add(words[i]);
                    wordLenSum += wordLens[i];
                    ++i;
                } else {
                    lineFinished = true;
                }
            } else {
                res.add(getSingleLine(currLine, L - wordLenSum, false));
                currLine = new ArrayList<String>();
                lineFinished = false;
                firstOfLine = true;
                remaining = L;
                wordLenSum = 0;
            }
        }
        if (currLine.size() > 0) {
            res.add(getSingleLine(currLine, L - wordLenSum, true));
        }
        return res;
    }

    private String blankString(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private String getSingleLine(List<String> words, int remaining,
            boolean isLast) {
        //Last line
        if (words.size() == 1)
            return words.get(0) + blankString(remaining);
        int space = remaining / (words.size() - 1);
        int extra = remaining % (words.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.size(); ++i) {
            sb.append(words.get(i));
            if(isLast){
                sb.append(" ");
                remaining--;
            }else {
                if (i < words.size() - 1)
                    sb.append(blankString(space));
                if (i < extra)
                    sb.append(" ");
            }
        }
        if(isLast)
            sb.append(blankString(remaining));
        return sb.toString();
    }

    private int[] getWordLens(String[] words) {
        int[] res = new int[words.length];
        int i = 0;
        for (String word : words) {
            res[i++] = word.length();
        }
        return res;
    }
/*
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] test = { "What", "must", "be", "shall", "be." };
        System.out.println((sol.fullJustify(test, 12)));
    }*/
}

