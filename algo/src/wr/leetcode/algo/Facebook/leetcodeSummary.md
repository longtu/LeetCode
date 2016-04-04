#Done
1. 26  Remove Duplicates from Sorted Array 33.2%   Easy
1. 168 Excel Sheet Column Title    21.3%   Easy
1. 28  Implement strStr()  24.6%   Easy
1. 102 Binary Tree Level Order Traversal   32.3%   Easy
1. 1   Two Sum 22.2%   Easy
1. 206 Reverse Linked List 38.9%   Easy
1. 334 Increasing Triplet Subsequence  33.0%   Medium
1. 252 Meeting Rooms   41.5%   Easy
1. 278 First Bad Version   22.1%   Easy
1. 238 Product of Array Except Self    42.1%   Medium
1. 75  Sort Colors 34.4%   Medium
1. 125 Valid Palindrome    23.6%   Easy
1. 173 Binary Search Tree Iterator 34.0%   Medium
1. 257 Binary Tree Paths   27.9%   Easy
1. 78  Subsets 31.0%   Medium **(Remember to Sort!!!)**
1. 235 Lowest Common Ancestor of a Binary Search Tree  37.9%   Easy
1. 236 Lowest Common Ancestor of a Binary Tree 28.7%   Medium
1. 283 Move Zeroes 43.8%   Easy
1. 10  Regular Expression Matching 21.8%   Hard **(for a* match, match prev instead of char !!!)**
1. 253 Meeting Rooms II    34.3%   Medium
1. 25  Reverse Nodes in k-Group    27.2%   Hard **(next instead of head.next)** https://leetcode.com/submissions/detail/57256412/
1. 49  Group Anagrams  27.0%   Medium
1. 221 Maximal Square  23.3%   Medium **(i,j equals to 0, watch out!!!)**
1. 33  Search in Rotated Sorted Array  30.1%   Hard **(dealing with mv == sv)**
1. 88  Merge Sorted Array  29.9%   Easy
1. 133 Clone Graph 24.8%   Medium **(null directly return null, otherwise NPE)**
1. 91  Decode Ways 17.4%   Medium
1. 38  Count and Say   28.5%   Easy
1. 23  Merge k Sorted Lists    23.1%   Hard
1. 209 Minimum Size Subarray Sum   26.5%   Medium **(Do not worry about no elements sum to 0, only for negatives)**
1. 76  Minimum Window Substring    20.9%   Hard **(Review use int[])**
1. 17  Letter Combinations of a Phone Number   28.3%   Medium **(Use string, clarify empty string)**
1. 211 Add and Search Word - Data structure design 20.3%   Medium **(in adding node, remember to add node when child is null, for search string short-cut, remember to return default false)**
1. 208 Implement Trie (Prefix Tree)    25.3%   Medium
1. 15  3Sum    18.6%   Medium
1. 121 Best Time to Buy and Sell Stock 35.7%   Medium
1. 261 Graph Valid Tree    32.2%   Medium
1. 297 Serialize and Deserialize Binary Tree   27.3%   Hard **(always append SEP if there is any data)**
1. 80  Remove Duplicates from Sorted Array II  32.4%   Medium
1. 50  Pow(x, n)   27.9%   Medium **(overflow, use Long, check odd use &1)**
1. 69  Sqrt(x) 25.1%   Medium **(BinarySearch)**
1. 200 Number of Islands   27.3%   Medium
1. 67  Add Binary  27.1%   Easy
1. 215 Kth Largest Element in an Array 32.6%   Medium **(Make sure to do the last swap and random swap)**
1. 314 Binary Tree Vertical Order Traversal    30.2%   Medium **(update min)**
1. 117 Populating Next Right Pointers in Each Node II  32.7%   Hard **(remember to iterate, move parent node to next)**
1. 158 Read N Characters Given Read4 II - Call multiple times  23.3%   Hard **(clarify multiple read of read4 and maybe add 'finished', make sure to break when there is no hasNext() )**
1. 274 H-Index 29.0%   Medium
1. 275 H-Index II  32.4%   Medium **(model h as binary search value, skip 0, from 1 to n)**
1. 210 Course Schedule II  20.9%   Mediu
1. 269 Alien Dictionary    22.4%   Hard **(only consider w(i) and w(i+1) to find the mis-match pair, remember to add all characters)**
1. 286 Walls and Gates     36.8%   Medium **(only enqueue to BFS when dist is smaller than previous)**
1. 265 Paint House II  35.3%   Hard **(How is findMin implemented, how about only 1 color)**
1. 273 Integer to English Words    18.5%   Hard
  * sequence of adding groups, reverse
  * for base of 1 no need to add space
  * empty string output to ZERO
1. 43  Multiply Strings    23.1%   Medium
  * index order of k is i+j+1
  * make sure to use carry
  * ignore leading zeros
  * empty string output to ZERO
1. 301 Remove Invalid Parentheses  31.4%   Hard (BFS+Pruning by using valid function)
  * [Pruning + BFS](https://leetcode.com/submissions/detail/57504482/)
1. 161 One Edit Distance   28.1%   Medium
  * **(Check Iterator)**
1. 79  Word Search 22.6%   Medium
1. Word Break II

#Look:
1. longest increasing subsequence
1. Longest common subsequece
1. Longest Consecutive Sub-sequence (order does not matter) in sequence: one pass O(N) time , O(N) space
1. Find if subarray sum equal to given target. (fast/slow pointers moving to right)
1. Longest increasing subarray in array(fast/slow pointers moving to right)
1. Longest sized sub-sequence with sum equal to given target. (backtracking)
1. Validate Pre-order of BST
1. Calculate moving window max/min
1. Post-Order Iterator
1. Implement PriorityQueue
  * Building/Removing Recursively, what if children are already heaps?
  * Adding is different from building.
1. Implement Semaphore/Mutex etc

1. Number of Islands Similars
1. WordLadder II
1. BinaryTree Flip/Vertical etc
1. 3Sum similar problems, duplicated allowed (check sample question as well)
1. Stock similar problems
1. KeyStroke followup
