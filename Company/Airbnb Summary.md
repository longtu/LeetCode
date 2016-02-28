Airbnb Summary
#Coding
1. [CsvParser](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/CsvParser.java)
1. [SingleQuote Parser](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/SingleQuoteCSV.java)
1. [Text Justification](https://leetcode.com/submissions/detail/54117526/)
1. [Overlapping Rectangular Area](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/Rectangular.java)
1. [Mini Parser](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/MiniParser.java)
  * determine which type and use open brackets/ closed brackets to delimite
1. [Maximum Room Days (House Robbery)](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/MaxDaysFinder.java):
  * [If circular](https://leetcode.com/submissions/detail/51336881/)
1. [Maximal Square](https://leetcode.com/submissions/detail/53913127/)
1. [Merge K Sorted Lists](https://leetcode.com/submissions/detail/51706807/)
1. [Word Search II](https://leetcode.com/submissions/detail/54103884/)
  * [Word Search](https://leetcode.com/submissions/detail/44884653/)
1. [2D Iterator supports remov](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/Iterator2D.java)
  * watch out for move for advance(), cannot use cached results.
1. [Decode String](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/StringDecoder.java)
  * Try all possible Upper/Lowwer cases.
1. [K-distance sort](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/KDistanceSort.java)
  * using a minHeap of size K+1
1. [KEditDistance](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/KEditDistance.java)
  * using Trie and try all possible solutions while iterating the trie.
1. [Pagenator](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/Pagenator.java)
  * iterator while remove,
  * remove() not work on 'fixedSize' list of Arrays.asList(), use V2, which keeps a buffer but never deletes from original
1. [Palindromic pair of a list of strings](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/ParlindromicPair.java)
  * build reverse lookup table, use prefix/postfix to check
1. [Alien Dictionary](https://leetcode.com/submissions/detail/54124967/)
1. [Contains Duplicate](https://leetcode.com/submissions/detail/31547169/)
  * [Contains Duplicate II](https://leetcode.com/submissions/detail/54082247/)
  * [Contains Duplicate III](https://leetcode.com/submissions/detail/54108539/)
1. [WordBreak ](https://leetcode.com/submissions/detail/23708628/)
  * [WordBreak II ](https://leetcode.com/submissions/detail/44679631/)
1. [Regular Expression Matching](https://github.com/rw2409/LeetCode/blob/master/algo/src/wr/leetcode/algo/airbnb/RegularExpressionMatching.java)

1. [WordLadderII](https://leetcode.com/submissions/detail/44983858/)
  * [WordLadder](https://leetcode.com/submissions/detail/51690831/)

#Design
1. Google Reader Design
2. Airbnb Recommendation system
3. Distributed Cache design

#Culture fit
1. 为什么选择Airbnb?
1. 如何改进Airbnb现有的产品?
1. 你最想做的事?
1. 给你三分钟，教他一件事?
1. what can you teach your co-workers after you get in?
1. describe a person whom you admire most
1. describe your experience with airbnb
1. where have you been to?
1. what will you do if you win a lottery such as Powerball?
1. what is the biggest fear in your life?
1. how do describe Airbnb to a people back to 2003?
1. if you have a book that writes about your whole life, will you read it? why?
1. if you have a time machine, and you can either go back or go forth, will you choose to go back or to go forth?
1. among all the features of airbnb, what do you want to improve?
1. 描述一件你当时觉得非常risky的事情，你是怎么做的，结果如何

# TBD:
1. PingServer: output the timestamp offset [TBD]
写echo TCP client， 向面试官的server发请求， 读回数据。地里比较少人说这种， 我来详细说一下， 情境是这样的： 想象你开车， 踩下油门，车会加速，放开油门，车会减速。 client向server发的请求有以下2种： （a）STATUS –表示查询现在车的速度和踩下踏板的压力； （b）THROTTLE 50.1 — 这条指令是“THROTTLE” 加上一个数字， 表示我现在将踩油门的压力调为50.1

EXAMPLE: 比如在telnet中
STATUS
0.0 0.0 (这行是server返回的， 第一个数字表示压力，第二个数字表示速度)
THROTTLE 50.1 (这个指令发出 server没有返回)
STATUS
50.1 3.75 (可以看到速度在缓慢上升)
STATUS (过几秒后，你又发STATUS指令过去)
50.1 15.98 (速度依旧上升。。。)

对就是这样，像是简单物理实验。

写完TCP client后，要求是写一个方法将速度控制到达一个target speed

最后一个问题是求这个 delta力 和 delta速度 之间的函数关系。。。。。。。。醉了。我物理还给老师了。。。。。。时间不够了


2. Similarity
john’s travel city: a1 a2 c2 h8 j9
tom’s travel city: b1 a1 c3 z5
kate travel city: a2 a1 h8 x8

给你一个人john, 以及他的一堆朋友，让你计算出来和他travel的city相似度大于75%的所有朋友，并且根据这个相似度对朋友排序

3. 给一组meetings（每个meeting由start和end时间组成）。求出在所有输入meeting时间段内没有会议，也就是空闲的时间段。
每个subarray都已经sort好
举例：
[
[[1, 3], [6, 7]],
[[2, 4]],
[[2, 3], [9, 12]]
]
返回
[[4, 6], [7, 9]]

[Merge Interval](https://leetcode.com/submissions/detail/52110668/)

1. 2D array, 访问顺序必须是‘回’字的方式，就是从外圈转到里圈，写出class,
Iterator, hasNext(), next().
[Spirial Matrix](https://leetcode.com/submissions/detail/53194000/)

2. 电话号码和计费的一个log, 去parse 看规定时间内哪个号码产生费用最高。
3. 有很多个sorted queue存在不同服务器上，如何有效的读取到一个 sorted 大queue
里 (google也面到了这题）
4. 设计db, 如何存取房东和房客的reviews, 如何maintain他们之间的关系。

5. Store a set of sudden-death tournament results in a compact format (eg. a bit array) and a set of predicted match results (also in a bit array). Score the predictions, giving one point per correctly guessed match, without unpacking the bit array into a more convenient format (ie. you have to traverse the tree in-place)
[Pre-order traversal for binary tree serialization](https://leetcode.com/submissions/detail/52112886/)
