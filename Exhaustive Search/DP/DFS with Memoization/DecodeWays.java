/*
* A message containing letters from A-Z is being encoded to numbers using the following mapping:
* 'A' -> 1
* 'B' -> 2
* ...
* 'Z' -> 26
* Given an encoded message containing digits, determine the total number of ways to decode it.
* For example,
* Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
* The number of ways decoding "12" is 2.
*/
//comment: 这道题一看是划分问题，很自然就想到了DFS搜索，但具体是不是可以用DP优化，就得自己画一个搜索树
//看有没有重复计算， 结果一看是可能存在的，这时候就要引入memoization, 也就是一个HashTable.
public class Solution {
    public int numDecodings(String s) {
        // edge case
        if (s == null || s.length() == 0) {
            return 0;
        }
        // pre-process
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        return dfsHelper(s, map);
    }
    public int dfsHelper(String s, HashMap<String, Integer> map) {
        //base case
        if (s.length() == 0) {
            return 1;
        }
        //check dp
        if (map.containsKey(s)) {
            return map.get(s);
        }
        //cur level
        int count = 0;
        for (int i = 0; i < 2; i++) {
            if (i >= s.length()) {
                break;
            }
            String temp = s.substring(0, i + 1);
            if (!valid(temp)) {
                continue;
            }
            count += dfsHelper(s.substring(i + 1), map);
        }
        //return cur result
        map.put(s, count);
        return count;
    }
    public boolean valid(String s) {
        int value = Integer.parseInt(s);
        if (value > 26 || value < 1) {
            return false;
        }
        if (s.charAt(0) == '0') {
            return false;
        }
        return true;
    }
}
