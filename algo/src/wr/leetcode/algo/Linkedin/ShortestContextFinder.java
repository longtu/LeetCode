package wr.leetcode.algo.Linkedin;


/**
 * Given a large document and a short pattern consisting of a few words (eg. W1 W2 W3), find the shortest string that
 * has all the words in any order (for eg. W2 foo bar dog W1 cat W3 -- is a valid pattern)
 */

/**
 *
 * We need a Trie and a HashTable, and do one time scan using sliding window (head + tail pointers) technique

 1) Advance tail pointer thru the document and match any word with the help of Trie. Add a count of 1 to HashTable keyed by word.
 2) When we matched all n words (HashTable.Size == n), we know document from head to tail contains all words, but not necessarily the shortest.
 3) Now advance head pointer and decrease the value in HashTable when we encounter a word. Stop when the value in HashTable is 0. Now we have a shortest match between head and tail at current (tail) location.
 4) Advance tail pointer again and stop when any word is matched. Try to advance tail pointer the same way as far as we can. Update the global tracker if new match is shorter.
 5) Repeat until tail hit the end of document.

 O(Document Size) time and O(WordCount) space

 There're optimizations we can do when we try to advance the head (because tail already visited these words).
 *
 */
public class ShortestContextFinder {

}
