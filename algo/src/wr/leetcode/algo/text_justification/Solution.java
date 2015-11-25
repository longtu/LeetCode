package wr.leetcode.algo.text_justification;

import java.util.LinkedList;
import java.util.List;

public class Solution {

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
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "text", "justification."};
        Solution sol = new Solution();
        List<String> strs = sol.fullJustify(words, 16);
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
