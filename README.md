* Big Data Processing
  * missing int--need to revisit this question
  * find duplicates--need to revisit this question
  * [sort big file] (http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L17-ExternalSortEX1.htm)--modified version of merge sort called external sorting in that in each run pass, we have different group size by doubling it every run. With multiple big files, we can make use of the MinHeap to compare the smallest out of k files every comparison; instead double the group size every run, now we multiply by a factor of k. 
* Sorting and Searching
  * sort + HashMap
    * [group anagrams] (https://leetcode.com/problems/anagrams/)--when talking about anagram, always think about sort and HashMap
  * mergesort
    * [merge two sorted arrays] (https://leetcode.com/problems/merge-sorted-array/)--merge part of the mergesort
  * binary search
    * [search in rotated sorted array without duplicates] (https://leetcode.com/problems/search-in-rotated-sorted-array/)--need to do twice binary search
    * [search in rotated sorted array with duplicates] (https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)--we can still use binary search with duplicates, but the worst case is O(n) 
    * sparse search -- same idea with the rotated sorted array with duplicates: we can use binary search, but the worst case is O(n) 
    * [search in a big sorted array] (http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/)--a bit tricky to find the end point; also need to do twice binary search
