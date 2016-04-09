## Symbol Table + BST + Ordered Operations
  * [closest binary search tree value] (https://leetcode.com/problems/closest-binary-search-tree-value/)    --very similar to search in a BST; in essence, the operations on BST are also binary search, in a recursive manner
  * [kth smallest element in a BST] (https://leetcode.com/problems/kth-smallest-element-in-a-bst/)    --if we need to calc size of the left subtree, then the time complexity is O(k); but we can do better by keep a counter of the size of BST rooted at current node, updated by every insertion/deletion, that will be O(1) for size()
  
## DFS + Exhasutive Search
  * [arrange table according to heights] (https://github.com/liut2/OnlineAlgorithms/blob/master/DFS%2BSearch/ArrangeTable.java)    --the difference between this question and a standard permutation one is that we need to fix the first element because the result is in a ring, meaning multiple permutation is actually the same thing.
  * [recover report] (https://github.com/liut2/OnlineAlgorithms/blob/master/DFS%2BSearch/RecoverReport.java)    --this question is similar to decode ways in that we have two choices at each level
  * [add plus or minus] (https://github.com/liut2/OnlineAlgorithms/blob/master/DFS%2BSearch/AddPlusOrMinus.java)    --math expression DFS is a special type exhaustive search quesion; there is "logically" two for loops on each level: you not only need to choose current numbers, but also the next operator for to use 
  
## Big Data Processing
  * missing int    --need to revisit this question
  * find duplicates    --need to revisit this question
  * [sort big file] (http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L17-ExternalSortEX1.htm)    --modified version of merge sort called external sorting in that in each run pass, we have different group size by doubling it every run. With multiple big files, we can make use of the MinHeap to compare the smallest out of k files every comparison; instead double the group size every run, now we multiply by a factor of k. 
  
## Sorting and Searching
  * sort + HashMap
    * [group anagrams] (https://leetcode.com/problems/anagrams/)    --when talking about anagram, always think about sort and HashMap
  * mergesort
    * [merge two sorted arrays] (https://leetcode.com/problems/merge-sorted-array/)    --merge part of the mergesort
  * binary search
    * [search a 2d matrix] (https://leetcode.com/problems/search-a-2d-matrix/)    --the brute force solution of a usual search/find problem is O(n) by linear search, which sets the upper bound. In order to perform better than O(n), binary search on a sorted array is the usual idea
    * [search a 2d matrix 2] (https://leetcode.com/problems/search-a-2d-matrix-ii/)    --the essential thinking is still binary search: we find a pivot and we choose to go only one direction a time.
    * [search in rotated sorted array without duplicates] (https://leetcode.com/problems/search-in-rotated-sorted-array/)       --need to do twice binary search
    * [search in rotated sorted array with duplicates] (https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)       --we can still use binary search with duplicates, but the worst case is O(n) 
    * sparse search    -- same idea with the rotated sorted array with duplicates: we can use binary search, but the worst case is O(n) 
    * [search in a big sorted array] (http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/)    --a bit tricky to find the end point; also need to do twice binary search

## Interval and Scan Line
  * [Number of Airplanes in the Sky ] (http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/)    --a basic use of the scan line algorithm to sort the interval end points; the tricky part is to write a proper comparator 
  * [Building Outline ] (http://www.lintcode.com/en/problem/building-outline/)    --a combination use of scan line algorithm and PQ data structure to find max height
  
## PQ and Max/Min in O(1)
  * [Building Outline ] (http://www.lintcode.com/en/problem/building-outline/)    --a combination use of scan line algorithm and PQ data structure to find max height
  * [Trapping Rain Water II ] (http://www.lintcode.com/en/problem/trapping-rain-water-ii/)    --an extension from 2d to 3d problem; the tricky part is to imagine a wall from which the shortest one is always taken out, which reminds us of find min in O(1) with PQ
  * [Data Stream Median ] (http://www.lintcode.com/en/problem/data-stream-median/)    --when asked about median in changing data, always think of a maxHeap and a minHeap, which together could solve the question; if the data is not fixed, we might use quick-select to find median in an unsorted array
  * [Sliding Window Median] (www.lintcode.com/en/problem/sliding-window-median/)    --similar idea with data stream median, the only difference here is the "sliding window", for which the core idea is to add one first and remove one later before the real comparison starts
  
## Sliding Window    
--the difference between the sliding window and two pointers question is that for sliding window, we always need to add one and remove one since the container is a fixed size, while for two pointers, some compressing ideas are used and we cannot gurantee adding one and removing one all the time
  * [Sliding Window Median] (www.lintcode.com/en/problem/sliding-window-median/)    --similar idea with data stream median, the only difference here is the "sliding window", for which the core idea is to add one first and remove one later before the real comparison starts
  * [Sliding Window Maximum ] (http://www.lintcode.com/en/problem/sliding-window-maximum/)    --here what I want to emphasize is the "sliding window idea I explained above.

## Two Pointers
* Two Sum
  * [PointsOnLine] (https://github.com/liut2/OnlineAlgorithms/blob/master/Two%20Pointers/Two%20Sum/PointsOnLine.java)    --there are two methods to identify a two sum type question: 1) ask for pair and triple that satisfies certain pattern 2) the brute force solution itself is O(n^2) or O(n^3).
* Guanshui
  * [EatChocolate] (https://github.com/liut2/OnlineAlgorithms/blob/master/Two%20Pointers/%E7%81%8C%E6%B0%B4%E7%B1%BB/EatChocolate.java)    --the core idea of this type of two pointers is to go from the start and the end towards middle; along the way try to reduce scan as possible
  * [Container With Most Water] (http://www.lintcode.com/en/problem/container-with-most-water/)    --classic guanshui question
  * [Trapping Rain Water] (http://www.lintcode.com/en/problem/trapping-rain-water/)    --classic guanshui question

## Dynamic Programming
* matrix type
  * [OneColumnOnes] (https://github.com/liut2/OnlineAlgorithms/blob/master/Dynamic%20Programming/OneColumnOnes.java)    --the reason I think of DP solution is that a normal exhaustive search takes exponential time, so DP can fix that to polynomial; also the question asks min moves but not actual operation, which makes it a perfect match for DP.
