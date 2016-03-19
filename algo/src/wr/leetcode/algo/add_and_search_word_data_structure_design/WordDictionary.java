package wr.leetcode.algo.add_and_search_word_data_structure_design;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordDictionary {
    TrieNode trie = new TrieNode();

    public void addWord(String word) {
        //check null
        trie.addWord(word);
    }

    public boolean search(String word) {
        //check null
        return trie.search(word);
    }

    public List<String> searchWithWildCard(String word) {
        return trie.searchWithWildCard(word);
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("car");
        dic.addWord("caw");
        dic.addWord("cauw");
        System.out.println(dic.searchWithWildCard("c*w"));
        System.out.println(dic.searchWithWildCard("*"));
    }
}

class TrieNode {
    boolean isTail = false;
    TrieNode [] children = new TrieNode[26];

    public void addWord(String word) {
        if (word.isEmpty()) {
            isTail = true;
        } else {
            char ch = word.charAt(0);
            if( null == children[ ch - 'a'] ) {
                children[ch-'a'] = new TrieNode();
            }
            TrieNode child = children[ch - 'a'];
            child.addWord(word.substring(1));
        }
    }

    public boolean search (String word) {
        boolean ret = false;
        if (word.isEmpty()) {
            ret = isTail;
        } else {
            char ch = word.charAt(0);
            String w = word.substring(1);
            if (ch == '.') {
                for ( TrieNode child : children) {
                    if( null != child && child.search(w)) {
                        ret = true;
                        break;
                    }
                }
            } else {
                TrieNode child = children[ch - 'a'];
                ret = (null != child) && (child.search(w));
            }
        }
        return ret;
    }

    /**
     * Wild card matching
     */
    public List<String> searchWithWildCard(String word) {
        Set<String> ret = new HashSet<>();
        if( word.isEmpty() ) {
            if(isTail) {
                ret.add("");
            }
        } else {
            char ch = word.charAt(0);
            if( ch == '*' ) {
                List<String> sub = searchWithWildCard(word.substring(1));
                ret.addAll(sub);

                for (int i =0; i < 26; ++i) {
                    TrieNode child = children[i];
                    if ( null == child) {
                        continue;
                    }
                    char c = (char)('a' + i);
                    List<String> sub1 = child.searchWithWildCard(word);
                    List<String> sub2 = child.searchWithWildCard(word.substring(1));
                    sub1.addAll(sub2);
                    for (String s1 : sub1) {
                        ret.add( c + s1 );
                    }
                }
            } else {
                TrieNode child = children[ch - 'a'];
                if (null != child) {
                    List<String> sub = child.searchWithWildCard(word.substring(1));
                    for (String s1 : sub) {
                        ret.add( ch + s1 );
                    }
                }
            }
        }
        return new LinkedList<>(ret);
    }
}