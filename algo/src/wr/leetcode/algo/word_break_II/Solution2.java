package wr.leetcode.algo.word_break_II;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {

    public boolean validateVocabulary(String s, Set<String> dict)
    {
        Set<Integer> vocabulary = dict.stream().flatMap(a -> a.chars().boxed()).collect(Collectors.toSet());
        if (s.chars().boxed().filter( a -> !vocabulary.contains(a)).findAny().isPresent())
            return false;

        Set<Character> ends = dict.stream().map(a -> a.charAt(a.length() - 1)).collect(Collectors.toSet());
        if (!ends.contains(s.charAt(s.length()-1)))
            return false;

        return true;
    }



    public String notNull(String str) {
        return (null == str) ? ("") : (str);
    }

    public Set<String> notNull( Set<String> set) {
        return (null == set) ? ( new HashSet<>() ) : (set);
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        s = notNull(s);
        dict = notNull(dict);
        List<String> ret = new LinkedList<>();

        //TLE if not vocabulary check
        if( !s.isEmpty() && validateVocabulary(s, dict)) {

            boolean [][] table = table(s, dict);
            ret = words("", table, s, 0);
        }
        return ret;
    }

    public List<String> words (String prefix, boolean[][] table, String str, int index) {
        List<String> ret = new LinkedList<>();
        int n = str.length();
        if(index == n) {
            ret.add(prefix);
        } else { //index < n
            for (int i = index+1; i <=n; ++i) {
                if(table[index][i]) {
                    String word = str.substring(index, i);
                    String delim = (prefix.isEmpty() || word.isEmpty())? (""):(" ");
                    String nPrefix = prefix + delim + word;
                    List<String> subs = words(nPrefix, table, str, i);
                    ret.addAll(subs);
                }
            }
        }
        return ret;
    }

    public boolean [][] table(String s, Set<String> dict) {
        int n = s.length();
        boolean[][] table = new boolean[n+1][n+1];

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1 ; j <= n; ++j) {
                boolean val = false;
                String str = s.substring(i,j);
                if(dict.contains(str)) {
                     val = true;
                }
                table[i][j] = val;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        Set<String> dict = new HashSet<>();
        for (String w : new String[] {"cat", "cats", "and", "sand", "dog" }) {
            dict.add(w);
        }
        for (String s : new String[] {"","catsanddog",  null, "cats", "catss" }) {
            System.out.println(sol.wordBreak(s, dict));
        }
    }
}
