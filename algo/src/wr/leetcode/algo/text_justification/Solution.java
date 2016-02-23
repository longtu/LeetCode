package wr.leetcode.algo.text_justification;

import java.util.LinkedList;
import java.util.List;

public class Solution {
/*
    private List<List<String>> groups (String[] words, int maxWidth) {
        List<List<String>> wordGroups = new LinkedList<>();

        List<String> group = null;
        int len = 0;
        for (String w : words) {
            if(null == w || w.isEmpty()) {
                continue;
            }
            int wl = w.length();
            if(null == group || group.size() + wl > len) {
                group = new LinkedList<>();
                len = maxWidth;
                wordGroups.add(group);
            }
            group.add(w);
            len -= wl;
        }
        return wordGroups;
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        if(null == words) {
            words = new String[0];
        }
        List<List<String>> groups = groups(words, maxWidth);
        List<String> ret = new LinkedList<>();
        for (int i = 0; i < groups.size(); ++i) {
            ret.add(toString(groups.get(i), maxWidth, i == (groups.size()-1)));
        }
        return ret;
    }

    public String toString(List<String> words, int maxWidth, boolean lastLine) {
        int wordCount = words.size();
        StringBuilder sb = new StringBuilder();
        int len = maxWidth;
        //BUG: one word other than last line should be left adjusted as well
        if(lastLine || 1 == wordCount) {
            boolean isFirst = true;
            for (String w : words){
                if(isFirst) {
                    isFirst = false;
                } else {
                    sb.append(" ");
                    len -= 1;
                }
                int lw = w.length();
                len -= lw;
                sb.append(w);
            }
            while(len-- > 0) {
                sb.append(" ");
            }
        } else {
            int spaces = wordCount - 1;
            int totalLen = 0;
            for ( String w : words) {
                totalLen += w.length();
            }
            int totalSpaces = maxWidth - totalLen;
            int numPerSpace = totalSpaces/spaces;
            int addSpaceGroup = totalSpaces%spaces;
            for (int i = 0; i < wordCount; ++i) {
                String w = words.get(i);
                sb.append(w);
                if ( i != wordCount - 1) { //add spaces
                    for (int j = 0; j < numPerSpace; ++j) {
                        sb.append(" ");
                    }
                    //BUG: should be < other than <=
                    if(i < addSpaceGroup) {
                        sb.append(" ");
                    }
                }
            }
        }
        return sb.toString();
    }*/

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new LinkedList<>();
        words=(null == words)?(new String[0]):(words);
        int n = words.length;

        if (n > 0) {
            int charsThisLine = 0;
            int consumed = 0;
            List<String> thisLine = new LinkedList<>();

            for (String w : words) {
                int chars = w.length();
                int required = (thisLine.isEmpty())?(chars):(chars + 1);

                if (maxWidth - consumed < required) {
                    lines.add(toLine(thisLine, maxWidth - charsThisLine, false));
                    charsThisLine = 0;
                    consumed = 0;
                    thisLine = new LinkedList<>();
                    required = chars;
                }
                charsThisLine += chars;
                consumed += required;
                thisLine.add(w);
            }
            if(!thisLine.isEmpty()) {
                lines.add(toLine(thisLine, maxWidth - charsThisLine, true));
            }
        }
        return lines;
    }

    public String toLine(List<String> words, int spaces, boolean last) {

        StringBuilder sb = new StringBuilder();
        int n = words.size();
        int spaceGroupCount = (n==1)?(1):(n-1);

        int base = 0;
        int extra = 0;
        if (last) {
            base = 1;
        } else {
            base = spaces/spaceGroupCount;
            extra = spaces%spaceGroupCount;
        }

        int i = 1;
        for (String w : words) {
            sb.append(w);
            if (i != n) {
                int mySpaces = base + ((i<=extra)?(1):(0));
                for (int j = 1; j <= mySpaces; ++j) {
                    sb.append(' ');
                    spaces--;
                }
            }
            i++;
        }
        while( spaces-- >0 ) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text",  "justification."};
        String[] words = {"a","b","c","d", "e"};
        Solution sol = new Solution();
        List<String> strs = sol.fullJustify(words, 3);
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
