package wr.leetcode.algo.airbnb;

import java.util.LinkedList;
import java.util.List;

public class KEditDistance {

    public List<String> getKEditDistance(String[] words, String target, int k) {
        List<String> ret = new LinkedList<>();
        target = (null == target)?(""):(target);
        if (null != words && words.length > 0) {
            Trie dict = new Trie();
            for (String w : words) {
                dict.add(w);
            }
            int n = target.length();
            int [] dist = new int[n+1];
            for (int i = 0; i <=n; ++i) {
                dist[i] = i;
            }
            dfs(dict.root, dist, target, k, "", ret);
        }
        return ret;
    }

    private void dfs(TrieNode node, int[] dist, String target, int k, String prefix, List<String> result) {
        int n = target.length();
        if ( node.isTail) {
            if (dist[n] <= k) {
                result.add(prefix);
            } else {
                return;//PERFORMANCE IMPROVEMENT
            }
        }
        //BUG: NO ELSE HERE!
        for (int i = 0; i < 26; ++i) {
            TrieNode child  = node.children[i];
            if (null == child) {
                continue;
            }
            char ch = (char)('a' + i);
            String nPrefix = prefix + ch;
            //BUG: Distance is upated here!
            int[] nDist = new int[n+1];
            nDist[0] = nPrefix.length();
            for (int j = 1; j <=n; ++j) {
                char tch = target.charAt(j-1);
                int min = (tch == ch)?(dist[j-1]):(dist[j-1]+1);
                min = Math.min(dist[j]+1, min);
                min = Math.min(nDist[j-1] + 1, min);
                nDist[j] = min;
            }
            dfs(child, nDist, target, k, nPrefix, result);
        }
    }

    public static void main(String[] args) {
        KEditDistance solution = new KEditDistance();
        String[] input = new String[]{"abcd", "abc", "abd", "adc", "ad", "bc", "ccc"};
        String target = "ac";
        int k = 1;

        List<String> result = solution.getKEditDistance(input, target, k);

        for (String s : result) {
            System.out.println(s);
        }
    }
}

class TrieNode{
    TrieNode[] children;
    boolean isTail;

    public TrieNode () {
        children = new TrieNode[26];
        isTail = false;
    }
}

class Trie{
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String w) {
        w = (null == w)?(""):(w);
        int n = w.length();
        TrieNode node = root;

        for (int i = 0; i <= n; ++i) {
            if (n == i) {
                node.isTail = true;
                continue;
            } else {
                char ch = w.charAt(i);
                int key = ch - 'a';
                TrieNode child = node.children[key];
                if( null == child ) {
                    child = new TrieNode();
                    node.children[key] = child;
                }
                node = child;
            }
        }
    }
}
