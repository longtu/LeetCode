# Coding
1. Find the k most frequent words from a file
  * First time iteration Map + PriorityQueue
1. Positive Subarray sums to the target value *** 2
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

1. Level Order Traversal
  * 3
  * Calculate level average(iterative + recursive) 2
  * Top-down, bottom-up, ZigZag
1. Binary Tree Inorder traversal Iterator 2
1. BinaryTree to doubly LinkedList 2
  * Method1: Recursive with Info (head,tail)
  * Method2: Using an Iterator and iterate over the tree and build
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
1. Decode Ways 4
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

1.K nearest points to origin (Kth min) 3
  Find top K users with max posts
  * Sort: NLogN + K
  * MinHeap: first build min heap of size N and then call min K times (N + KLogN)
  * MaxHeap: use max heap of size K NLogK
  * Selection with Partition, random pivot: expected O(N), worst case O(N^2)
  * Worst case linear time
1. Kth Smallest Number
  * Two swaps to make pivot is the kth smallest element
  * swap(p++, i, array); swap(p, i, array)

1. ReadN using Read4 3
  * https://leetcode.com/submissions/detail/55700746/
  * Clarify read4 behavior after read through all chars
  * https://leetcode.com/submissions/detail/55701380/
  * https://leetcode.com/submissions/detail/55702542/ Call once simple version
1. Reverse Words in string
  * Clarify leading/trailing empty spaces, multi-space delimeters
  * do it in place: reverse twice
1. Product of all elements except itself
    //One pass solution exists
1. Longest Weighted leaf-to-leaf Path in BST
  * Recursive, similar to longest path

1. Phone number combination 2 (Recursion or DP)(SEA)

1. Longest Common Prefix
  * char by char
  * https://leetcode.com/submissions/detail/55801396/

1. Dot Product of Sparse matrix (Using List)
  * for binary value, we can use list
  * for integer value, it's better to use map
  * use transpose
1. Walls and Gates
  * enqueue all and then do a single BFS; making sure it's O(M*N)
  * https://leetcode.com/submissions/detail/55807287/
1. First Bad Version
  * Cut the range aggresively enough!
1. group anagrams 2
  * map and then sort values will be faster!
1. sort colors
  https://leetcode.com/submissions/detail/55891651/
1. Shift all zeros to right of array
  https://leetcode.com/submissions/detail/55892248/
1. Divide Two Integers
  * Divide/Conquer
  https://leetcode.com/submissions/detail/55894524/
1. Jump Game 2 (SEA) **(Worth) revisit!!
  * Similar with BFS
  * Jump Game I: BUGGY https://leetcode.com/submissions/detail/55895922/
  * Jump Game II: https://leetcode.com/submissions/detail/55898421/
1. valid palindrome, cannot use String.lowerCase() but can use Character.toLowerCase
  * Character.isLetterOrDigit
  * https://leetcode.com/submissions/detail/55900150/

1. simplify path with current path，based on current path和cd command找到最后的 (SEA)
   例如current path = ‘/a/b’, cd command = ‘../c/./d’，那最后的path就是’/a/c/d’。
  * https://leetcode.com/submissions/detail/55902644/
  * Stream Joinning
  * check cd command prefix, if starts with/, simplify cd command
  * otherwise simplify concatenation of path + "/" + command

1. Count Number of Islands
  * TODO: Union Find Solution, which is also Count Number of Islands II

1. Implement PriorityQueue/Heap
  * O(N) time to build a heap is not by calling insert N times,
  * Rather, by calling heapify for all 'Parent' nodes.

//TODO:
http://www.themianjing.com/tag/facebook/page/8/
1. Task Scheduler
  * Check discussion

1. Buy/Sell Stock
1. Longest increasing contiguous sequence in array
1. Longest increasing sub-sequence in array
  http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
1. 一组字符串，求所有彼此之间无公共字符的两两组合中，两字符串长度乘积的最大值。

# Design
1. System design Mobile app of photo feeds.
功能： 读取好友的最近图片, 阅览好友的相册
要求： 满足功能的同时减少对手机的能耗。

2. Given 1 trillion messages on FB and each message has at max 10 words, how do you
build the index table and how many machines do you need on the cluster to store the
index table ?

3. Design Messenger

4. Design photo reference counting system at fb scale
   感觉这题主要是要解决high volume concurrent writing. 我想的是如果要scaling up
   , 在每个Appserver 上对每个photo加一个counter,然后每隔T时间传到一个aggregator
   把所有与目标相关的counter相加，然后update DB和Memcached. 一些细节还没想清楚
   ，求讨论。
5. How to improve Facebook?