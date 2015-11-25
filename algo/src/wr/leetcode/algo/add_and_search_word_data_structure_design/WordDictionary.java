package wr.leetcode.algo.add_and_search_word_data_structure_design;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    Trie trie = new Trie();

    public void addWord(String word) {
        trie.insert(word);
    }


    public boolean search(String word) {
        return trie.search(word);
    }

    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        System.out.println(dic.search("pad"));
        System.out.println(dic.search("bad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("b.."));
    }


    class TrieNode {
        boolean isTail;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
            isTail = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (null == word) {
                return;
            }
            TrieNode node = root;
            while (word.length() >= 0) {
                if (!word.isEmpty()) {
                    char ch = word.charAt(0);
                    TrieNode child = node.children.getOrDefault(ch, new TrieNode());
                    node.children.put(ch, child);
                    node = child;
                    word = word.substring(1);
                } else { //word is empty
                    node.isTail = true;
                    break;
                }
            }
        }

        public boolean search(String word) {
            boolean found = false;
            if (null == word) {
                return found;
            }
            TrieNode node = root;
            while (null != node) {
                if (word.isEmpty()) {
                    found = node.isTail;
                    break;
                } else {
                    char ch = word.charAt(0);
                    TrieNode child = node.children.get(ch);
                    word = word.substring(1);
                    node = child;
                }
            }
            return found;
        }

        public boolean startsWith(String prefix) {
            boolean found = false;
            if (null == prefix) {
                return found;
            }
            TrieNode node = root;
            while (null != node) {
                if (prefix.isEmpty()) {
                    found = true;
                    break;
                } else {
                    char ch = prefix.charAt(0);
                    if( '.' != ch) {
                        TrieNode child = node.children.get(ch);
                        node = child;
                        prefix = prefix.substring(1);
                    } else {

                    }
                }
            }
            return found;
        }
    }
}