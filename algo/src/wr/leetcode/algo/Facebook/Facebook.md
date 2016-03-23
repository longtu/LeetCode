##Behavior
1. Difficult problem.
  * AuditGrading Decision Base
  * Memory Leak caused by initiating service client
1. Production bug, how to avoid.
  * DetailPage visibility setting
  * Database truncation
1. Cross Team, how to communicate them to listen to us.
  * Omiga calling R-T-D in batches. From all at once to reduced load.
1. Why Facebook?
  * Easily can make impact
  * Contribute to OpenSource
1. How to improve Facebook?
  * Community Based Used Inventory Sharing/Selling Platform

# Design:
1. Shorten URL 2
1. 1 T messages of max 10 words, how do you build the index table and how many machines to host?
  * Assumption: 2^14 words, words are evenly distributed in messages
  * 5bytes is enough to represent 1T message ID, but we use 8 Bytes Long
  * IndexTable size = 2^14 ( 2^40 * 10 / 2^14 * 8 + avg_byte_per_words) = 80T
  * If in Ram, each machine has 16G Ram, needs 5K * 2 for redundancy = 10K
  * If in filesystem, each machine has 1T, needs around 100.
1. POI geo hashing, 2D->1D 2
  * [Solution](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/Geo-Poi.md)
1. Design photo reference counting system at fb scale.
  * [Notes](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/CountingRelatedProblems.md)
  * Concurrent update on single photo is not huge?
  * Total photos are huge.
  * Data should be write-through cached.
1. System design of query field, 每个record有个很大field，比如年龄，性别，爱好等。给一个field的组合，比如小于25岁，爱好体育,
query满足这些组合条件的用户个数.
1. Realtime Search
1. Page Rank Design
[Notes](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/SearchRelated.md)

1. system design – design facebook music system，只需要design service tie.
- get_top_10_list_music_ids(int64 userid) return top 10 most frequent listened music ids for a given user last week. 这个call在load页面的时候要进行，所以对latency要求比较高。
- record(int64 userid, int64 musicid, int64 timestamp) – 每当user听一首歌，就 需要记录下来，这个可以asynch进行，需要eventually consistent，但不需要每听一 首歌马上就能反映到上一个call中。要做各种spec和resource的estimation。
   * Async update
   * Volume high but concurrent write is small
   * [Notes](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/CountingRelatedProblems.md)

1. 抄dropbox那个问题，get_hits_last_5mins(), record_hit()
  * Async write
  * Based on Data precision requirements, we can use buffered write through or shard counter.
  * [Notes](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/CountingRelatedProblems.md)

1.Rank the most shared urls for the last 10 minutes, for last hour, for last day, etc. There are total 100 millions url
sharing happen every day.
  * Stream processing: sharded, aggregated, use minute level window
  * Probalistic data structures
  * [Notes](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/CountingRelatedProblems.md)

1. Design Messenger
1. 设计@别人的功能，扩展到大规模
1. Auto refresh when new comment shows up for certain post, no need to refresh page
  * [Notes](https://github.com/rw2409/system_design/tree/master/ClassicalProblems)

1. System design Mobile app of photo feeds/Instagram
功能： 读取好友的最近图片, 阅览好友的相册
要求： 满足功能的同时减少对手机的能耗。
NewsFeed + Timeline + Mobile Optimization
  *[NewsFeed](https://github.com/rw2409/system_design/blob/master/ClassicalProblems/FeedDesign.md)

# Coding
1. Find the k most frequent words from a file
  * First time iteration Map + PriorityQueue
1. Positive Subarray sums to the target value *** 4
  * Watch out for sum = 0 and corresponding range
  * General subarray sums to target value 2
  * Maximum Sized Subsequence with sum equal to given target 2
  * Minimum Window Substring: what's optimum? 3
    * Use array + appearCount, only update appearCount when count change to/from 0
    * https://leetcode.com/submissions/detail/56160784/
  * Minimum size subarray with exact equal number

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
1. Binary Tree Inorder traversal Iterator 4
  * pre-order iterator
1. BinaryTree to doubly LinkedList 2
  * Method1: Recursive with Info (head,tail)
  * Method2: Using an Iterator and iterate over the tree and build
  * Flatten in place, using recursion is simpler
  * flatten binary search tree to linked-list(using original data structure) *** BUG


1. BST vertical Traversal 3
  * TOP-DOWN, left->right: BFS
  * one pass: keep track of min
  * without map: use list and min/max

1. Clone List with Random Pointer 3
1. Clone Graph 3
  * One pass to use hashtable as visited set
  * create copy only when first meet but always copy edge

1. Divide Without division 2
  * Negative?
1. Binary Addition 3
  * Follow up with base of 8
  * Plus One
1. Single number in sorted Array of numbers appeared twice
  * maintain 2n+1 subarray using binary search
  * consider equality with left/right, then move accordingly based on mid position of odd/even
1. bfs遍历二叉树，从左到右返叶子节点 (leaf only) 2
  * If just printing or adding into list: In-order traversal recursive, using global ret list
  * If change in place and re-use the tree node structure, need recursive. See solution.

1. Fibonacci number
1. Subsets 2
1. Print all paths from root to leaf 3
  * How to print with indentation? (add width index based on root)
  * How to parallel?(split at certain depth and reduce), reducing using the depth vector

1. Search in rotated sorted array, with/without duplicates 4
1. search kth element in sorted matrix, 列不升序
  * Method1: Merge K sorted List
  * Method2: pull K*N elements and sort
1. search kth element in N Lists (if N lists are not sorted)
  * Use max heap of size K
  * Use divide and conquer similar as selection

1. Max Rectangular in Histogram *** BUG
1. find all palindrome pairs in given list of words
  * It's one of the airbnb top problems
1. Count total Palindrome substrings
  * O(N^2) time, O(1) space, see 'CountPalidrome'

1. Edit Distance
  * One Edit Distance 2
  * OneOrZero Edit Distance Iterator ** HARD **

1. Regular Expression Matching 3
  * [Solution](https://leetcode.com/submissions/detail/55539502/)
1. Longest Consecutive Sub-sequence *
  * Put and then remove
1. Minimum Window Substring
  * with substring has no duplicates, we can just compare hashtable size
  * with substring has exact the same character count.

1. Populating Next pointer of Binary Tree
  * O(1) space
1. **Meeting Rooms I/II**
  * If one person can attend all 3 (lambda is slow)
  * Minimum number of meeting rooms required/Find time with max overlapping meetings 5
  * Insert Interval and totalLength (different ways to optimize add/read)

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
1. Decode Ways 6
1. Lowest common ancestor of binary tree
  * with parent pointer
  * without parent pointer
  * how about binary search tree?
1. Dot product of sparse vectors
  * Map Or SortedList
  * Vector multiplication of two billion size vectors
    * split to chunks
    * reduce
1. Consumer/Producer synchronization
  * synchronized
  * consumer/produce semaphore
1. Reverse LinkList

1. K nearest points to origin (Kth min) 3
  Find top K users with max posts
  * Sort: NLogN + K
  * MinHeap: first build min heap of size N and then call min K times (N + KLogN)
  * MaxHeap: use max heap of size K NLogK
  * Selection with Partition, random pivot: expected O(N), worst case O(N^2)
  * Worst case linear time
1. Kth Smallest Number
  * Two swaps to make pivot is the kth smallest element
  * swap(p++, i, array); swap(p, i, array)
  * This approach is the same as sort zeros.

1. ReadN using Read4 4
  * https://leetcode.com/submissions/detail/55700746/
  * Clarify read4 behavior after read through all chars
  * https://leetcode.com/submissions/detail/55701380/
  * https://leetcode.com/submissions/detail/55702542/ Call once simple version
1. Reverse Words in string 2
  * Clarify leading/trailing empty spaces, multi-space delimeters
  * do it in place: reverse twice
1. Product of all elements except itself
    //One pass solution exists
    * Trap Water, similar algorithm 2
    * Container with Most water is very different with 'Trap Water' above.

1. Longest Weighted leaf-to-leaf Path in BST
  * Recursive, similar to longest path

1. Phone number combination 3 (Recursion or DP)(SEA)
  * Phone number combination 2
  * with meaningful words: using trie
  * with multiple meaningful words: connect tail with trie root

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
1. First Bad Version 5
  * call badVersion() once every call.
  * https://leetcode.com/submissions/detail/56339729/
1. group anagrams 3
  * map and then sort values will be faster!

1. sort colors 7
  * https://leetcode.com/submissions/detail/55891651/
  * This process is very similar with quickSort Partition
1. Shift all zeros to right of array 7
  https://leetcode.com/submissions/detail/55892248/
  * Similar as delete certain elements with minimum writes (swap with last elements).
  * Can break order therefore uses swap to minimize operation

1. Divide Two Integers 3
  * Divide/Conquer
  https://leetcode.com/submissions/detail/55894524/
1. Jump Game 2 (SEA) **(Worth) revisit!!
  * Similar with BFS
  * Jump Game I: BUGGY https://leetcode.com/submissions/detail/55895922/
  * Jump Game II: https://leetcode.com/submissions/detail/55898421/
1. valid palindrome, cannot use String.lowerCase() but can use Character.toLowerCase 5
  * Character.isLetterOrDigit
  * https://leetcode.com/submissions/detail/55900150/

1. simplify path with current path，based on current path和cd command找到最后的 (SEA)
   例如current path = ‘/a/b’, cd command = ‘../c/./d’，那最后的path就是’/a/c/d’。
  * https://leetcode.com/submissions/detail/55902644/
  * Stream Joinning
  * check cd command prefix, if starts with/, simplify cd command
  * otherwise simplify concatenation of path + "/" + command

1. Count Number of Islands 4
  * TODO: Union Find Solution, which is also Count Number of Islands II
  * Find connected Size of 1s in given binary matrix
  * Max area of same color connected islands

1. Implement PriorityQueue/Heap
  * O(N) time to build a heap is not by calling insert N times,
  * Rather, by calling heapify for all 'Parent' nodes.

1. Key Stroke 2
  * http://www.themianjing.com/2015/07/facebook-onsite%E9%9D%A2%E7%BB%8F/
1. Dropping meetings that are lowest priority and schedule meetings with limited number of rooms.

1. Return index of max element in given array, the index needs to be random. 2
[2,1,2,1,5,4,5,5] return 4,6,7 randomly. O(1) space
  * Use decreasing probability based on count
  * see RandomIndexedMax and ReservoirSampling

1. Task Scheduler 3
  * use hash table to keep track of each task future schedule
  * if k is very small, we can keep hash table with size K (LinkedHashMap)
  * if order can change, we use greedy with priority queue, always execute the job that's available with highest count
  * Return Max(maxCount + (max-1)*(interval+1), totalLength)
  * Insert Merge Interval in place
    * [Using ListIterator, support add/remove but not fast](https://leetcode.com/submissions/detail/56625221/)

1. Longest increasing sub-sequence in array
  * https://leetcode.com/submissions/detail/56225311/
    * watch out for when key is equal
    * endValue[len]: last element of LIS with length len, increasing!
  * Longest increasing contiguous sequence in array
    * Two pointers, trivial

1. 3Sum with duplicates allowed 5
  * dedupe and two level nested loop  + Map O(N^2)
  * K-Sum: recursive

1. Permutation/Subsets I/II

1. Merge K sorted List

1. Union/Intersection of two sorted array

1. Word Search
  * SingleWord: DFS
  * Word Collection: Trie + DFS

1. Add and Search word with 2
  * Using [Trie](https://leetcode.com/submissions/detail/56238006/)
  *  TrieNode Match with wildcard, see add and search word

1. Buy/Sell Stock: loc/glo solves all
  * at most k times, Day i: https://leetcode.com/submissions/detail/56242691/
    * loc: did buy on the day before/not
    * glo: did sell on last day
  * Cooldown:
    https://leetcode.com/submissions/detail/56244376/
1. PlusOne binary without add 2

1. **Integer to English words** 3
  * Recursive function to deal with spaces in hundreds group
  * deal with 0 in hundreds? correct order added
  * joining
  * https://leetcode.com/submissions/detail/56337387/

1. Flatten list of lists
  * use down pointer as link
  * similar with airbnb problem of concatenate using down

1. Given an array with length n + 1. The array contains numbers from 1 to n.
  * O(1) space, O(N) time we could use XOR
    * We can also use swap if array is mutable
  * If sorted, we can use BinarySearch
  * If the single duplicated number could appear more than once
    * https://leetcode.com/submissions/detail/44048887/

1. find kth minimal number in tournament tree
   * level of depth i has first 2^i players
   * using shift to find which level K is at

1. UserContact 2
  * Union-Find

1. valid tree graph
  * Need to validate (edge count + connectivity)
  * Undirected Edge, pick any node can visit all nodes
  * Undirected Edge, UnionFind to merge all nodes
  * Directed Edge, toplogical sort

1. Longest consecutive paths in BST
  * https://leetcode.com/submissions/detail/47554119/

1. Sort Random double-ended pop list
  * see RandomListSorted

1. Remove Invalid Parenthesis 2 **Needs revisit **
  * If find one solution: we can use stack/pointer to go from left/right to match '(' with ')'.
   (Similarly as longest valid parenthesis).
   The remaining indexes in stack are the ones need to be deleted.
  * If find all solutions: use BFS/BackTracking using set to reduce duplicates.

1. Minstack
  * Watch out for Integer.Equals instead of "=="

1. count and say next string

1. Minimum Height of BinaryTree
   * both BFS/DFS

1. SameTree iteratively
   * https://leetcode.com/submissions/detail/56542353/

1. pre-order iterator
  * https://leetcode.com/submissions/detail/56543254/

1. IsBST, iterative apporach
  * InOrder Traversal ordered

1. Serialize/Deserialize BT
  * https://leetcode.com/submissions/detail/56546972/
  * BUG: index global array is of size int[1] instead of int[0]

1. Write a iterator to iterate a nested array
  * Comparing with LinkedIn problem of nested List with DeepIterator
  * See NestedArrayIterator
  * only top of the stack is data, others are all arrays.

1. alien dictionary
  * only need to compare from i to i+1 instead of N^2
  * build a outgoing-set EdgeMap/ and incoming-Integer count Map is sufficient

1. Longest pattern
  * see Longest Consecutive Pattern

1. given two nodes in a tree, return paths between those two nodes
  * Assuming two nodes are different and both in the tree
  * See recursive solution of 'FindPathBetweenTwoNodes'.

1. WordBreak 2
  * [TrueOrFalse](https://leetcode.com/submissions/detail/56971606/)
  * [All Solutins](https://leetcode.com/submissions/detail/56970658/)

1. Implement Mutex
  * See Facebook/Mutex.java
1. Use normal lock to implement readwrite lock
  * See Facebook/RWLock.java
1. Fair Locking Implementation




1. How to implement HashTable resize()? //JDK implementation
  * Always resize() by 2
  * for each node at j in oldTable, if node.next is null, newTable[(newSize-1)&j] = node;
  * else need to iterate over node.next list, distribute values into two lists newTable[j],newTable[j+oldSize]
  * if node.hashCode & oldSize !=0 go to newTable[j+oldSize]

1. StrStr  4
  * naive: nested loop
  * rolling hash + naive only when hash is the same
  * KMP
    * build proper postfix/prefix table used to look up
    * once stop, can shift right faster

# TODO:
## Coding
1. String to floatNumber
1. Valid Number 2

1.Find first k common elements in n sorted arrays.
  * Merge K sorted
  * Move 1 by 1
1. WordGame
http://www.mitbbs.com/article_t/JobHunting/33055253.html

1. Find the most overlapped position of a collection of rectangulars. (line sweep)
1. Line segment intersection.
https://community.topcoder.com/stat?c=problem_statement&pm=4463&rd=6536
https://www.topcoder.com/community/data-science/data-science-tutorials/line-sweep-algorithms/
1. 一组字符串，求所有彼此之间无公共字符的两两组合中，两字符串长度乘积的最大值。