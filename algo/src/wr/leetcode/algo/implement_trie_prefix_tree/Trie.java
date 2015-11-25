package wr.leetcode.algo.implement_trie_prefix_tree;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*class TrieNode {

    Map<Character, TrieNode> children;
    boolean isTail;

    // Initialize your data structure here.
    public TrieNode() {
        children = new TreeMap<>();
        isTail = false;
    }

    public void setIsTail(boolean isTail) {
        this.isTail =  isTail;
    }

    public boolean getIsTail(){
        return isTail;
    }

    public boolean search (String word, boolean isTail) {
        if(null == word || word.isEmpty()) {
            return (!isTail || this.isTail);
        }
        Character ch = word.charAt(0);
        TrieNode child = children.get(ch);
        if(null == child) {
            return false;
        }
        return child.search(word.substring(1, word.length()), isTail);
    }

    public void addWord(String word) {
        if(null == word || word.isEmpty()) {
            this.setIsTail(true);
            return;
        }
        Character ch = word.charAt(0);
        if(!children.containsKey(ch)){
            children.put(ch, new TrieNode());
        }
        TrieNode child = children.get(ch);
        child.addWord(word.substring(1, word.length()));
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word, true);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix, false);
    }




    }

}*/

class TrieNode {
    boolean isTail;
    Map<Character,TrieNode> children;

    public TrieNode() {
        children = new HashMap<>();
        isTail = false;
    }
}

public class Trie {
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
                TrieNode child = node.children.get(ch);
                node = child;
                prefix = prefix.substring(1);
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("something");
        trie.insert("somethingMore");
        trie.insert("interesting");

        System.out.println(trie.search("something"));
        System.out.println(trie.startsWith("something"));
        System.out.println(trie.startsWith("somethingM"));
        System.out.println(trie.startsWith("somethingMM"));
        System.out.println(trie.search("prefix"));
        System.out.println(trie.search("intesting"));
        System.out.println(trie.search("interesting"));
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
