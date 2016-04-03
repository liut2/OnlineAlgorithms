## Symbol Table + BST + Ordered Operations
  * [closest binary search tree value] (https://leetcode.com/problems/closest-binary-search-tree-value/)    --very similar to search in a BST; in essence, the operations on BST are also binary search, in a recursive manner
  * [kth smallest element in a BST] (https://leetcode.com/problems/kth-smallest-element-in-a-bst/)    --if we need to calc size of the left subtree, then the time complexity is O(k); but we can do better by keep a counter of the size of BST rooted at current node, updated by every insertion/deletion, that will be O(1) for size()
  
## DFS + Exhasutive Search
  * [arrange table according to heights] (https://github.com/liut2/OnlineAlgorithms/blob/master/DFS%2BSearch/ArrangeTable.java)    --the difference between this question and a standard permutation one is that we need to fix the first element because the result is in a ring, meaning multiple permutation is actually the same thing.
  * [recover report] (https://github.com/liut2/OnlineAlgorithms/blob/master/DFS%2BSearch/RecoverReport.java)    --this question is similar to decode ways in that we have two choices at each level
  
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
