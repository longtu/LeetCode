package wr.leetcode.algo.add_and_search_word_data_structure_design;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word);
    }

    public static void main(String[] args) {
        WordDictionary dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        System.out.println(dict.search("pad"));
        System.out.println(dict.search("bad"));
        System.out.println(dict.search(".ad"));
        System.out.println(dict.search("b.."));

    }
}


class TrieNode {

    private boolean isTail = false;
    private Map<Character, TrieNode> children = new HashMap<>();

    boolean search (String key) {
        if(null == key || key.length() == 0) {
            return isTail;
        }

        Character ch = key.charAt(0);

        boolean ret = false;
        if(!ch.equals('.')) {
            TrieNode child = children.get(ch);
            if( null != child ) {
                ret = child.search(key.substring(1, key.length()));
            }
        } else {
            String subKey = key.substring(1, key.length());
            for (TrieNode child : children.values() ) {
                if(child.search(subKey)) {
                    ret = true;
                    break;
                }
            }
        }
        return ret;
    }

    void addWord(String key) {
        if(null == key || key.length() == 0){
            isTail = true;
        } else {
            Character ch = key.charAt(0);
            TrieNode child = children.getOrDefault(ch, new TrieNode());
            children.put(ch, child);
            child.addWord(key.substring(1, key.length()));
        }
    }

}
