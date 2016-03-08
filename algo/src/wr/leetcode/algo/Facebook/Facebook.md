#New
1. Find the k most frequent words from a file
  * First time iteration Map + PriorityQueue
1. Positive Subarray sums to the target value ***
  * Watch out for sum = 0 and corresponding range
  * General subarray sums to target value
1. Mutate Input Array
1. Find Nth Element In Tree
  * Recursive solution using class variable to avoid repeated calls
  * Iterative solution (with iterator) is of the same performance level
1. Isomorphic Tree
  * Recursive
1. Weighted Interval Scheduling 2
  * Sort by what?
  * How to generate Path?
1. PasswordCombination
  * Check on emptyString.

#OLD
1. Level Order Traversal
  * 3
  * Calculate level average(iterative + recursive) 2
  * Top-down, bottom-up, ZigZag
1. Binary Tree Inorder traversal Iterator 2
1. Binary Tree Column print from left to right
1. Clone List with Random Pointer
1. Clone Graph
  * One pass to use hashtable as visited set
  * create copy only when first meet but always copy edge

1. Divide Without division 2
  * Negative?
1. Binary Addition 3
  * Follow up with base of 8
1. Single number in sorted Array of numbers appeared twice
  * maintain 2n+1 subarray using binary search
  * consider equality with left/right, then move accordingly based on mid position of odd/even
1. bfs遍历二叉树，从左到右返叶子节点 (leaf only)
  * In-order traversal recursive, using global ret list
1. Fibonacci number
1. Subsets 2
1. Print all paths from root to leaf
  * How to print with indentation? (add width index based on root)
  * How to parallel?(split at certain depth and reduce), reducing using the depth vector

1. Kth Smallest Number
  * Two swaps to make pivot is the kth smallest element
  * swap(p++, i, array); swap(p, i, array)
1. group anagrams
1. Search in rotated sorted array 3
1. search kth element in sorted matrix, 列不升序
  * Method1: Merge K sorted List
  * Method2: pull K*N elements and sort
1. search kth element in N Lists (if N lists are not sorted)
  * Use max heap of size K
  * Use divide and conquer similar as selection

1. flatten binary search tree to linked-list *** BUG
1. Max Rectangular in Histogram *** BUG
1. find all palindrome pairs in given list of words
  * It's one of the airbnb top problems
1. Edit Distance
1. One Edit Distance 2
1. Regular Expression Matching
  * [Solution](https://leetcode.com/submissions/detail/55539502/)
1. Longest Consecutive Sub-sequence *
  * Put and then remove
1. Minimum Window Substring
  * with substring has no duplicates, we can just compare hashtable size
1. Populating Next pointer of Binary Tree
  * O(1) space
1. **Meeting Rooms I/II**
  * If one person can attend all 2
  * Minimum number of meeting rooms required 2
1. Double Binary Search to find sqrt
  * use eps
1. Combination Sum
  * use set to eliminate duplicates
  * what if only K elements allowed?
1. Excel Column mapping
  * From number to title, check the solution
1. Word Ladder II
  * How to print all paths
1. Find the Thief
  * DP of size n (room number) * K(sequence size)
1. 3 Sum
  * How about each digit can be reused?
1. Decode Ways
1. Lowest common ancestor of binary tree
  * with parent pointer
  * without parent pointer
  * how about binary search tree?
1. Vector multiplication of two billion size vectors
  * split to chunks
  * reduce
1.Consumer/Producer synchronization
  * synchronized
  * consumer/produce semaphore
1.Reverse LinkList
1.K nearest points to origin (Kth min)
  * Sort: NLogN + K
  * MinHeap: first build min heap of size N and then call min K times (N + KLogN)
  * MaxHeap: use max heap of size K NLogK
  * Selection with Partition, random pivot: expected O(N), worst case O(N^2)
  * Worst case linear time
1. ReadN using Read4
  * https://leetcode.com/submissions/detail/55700746/
  * Clarify read4 behavior after read through all chars
  * https://leetcode.com/submissions/detail/55701380/
  * https://leetcode.com/submissions/detail/55702542/ Call once simple version
1. Reverse Words in string
  * Clarify leading/trailing empty spaces, multi-space delimeters
  * do it in place: reverse twice



//TODO:
1. BinaryTree to doubly LinkedList
1. Walls and Gates
1. Divide Two Integers
1. Implement PriorityQueue/Heap

Design
1. System design Mobile app of photo feeds.
功能： 读取好友的最近图片, 阅览好友的相册
要求： 满足功能的同时减少对手机的能耗。

2. Given 1 trillion messages on FB and each message has at max 10 words, how do you
build the index table and how many machines do you need on the cluster to store the
index table ?