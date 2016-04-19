/*
* Given a positive integer n, break it into the sum of at least two positive integers
* and maximize the product of those integers. Return the maximum product you can get.
* For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
*/
//comment: 这道题一看是一道划分问题，很明显就是搜索问题，用DFS解决，然后我们可以通过画出搜索树
//来判断有没有重复计算，结果画出来一看发现简直和斐波那契数列一样，全都是重复计算，那么我们可以使用dp数组
//进行memoization。正巧题目要求返回的是maximum product，所以也符合DP问题的套路。
public class Solution {
    public int integerBreak(int n) {
        // edge case
        if (n <= 1) {
            return Integer.MIN_VALUE;
        }
        // pre-process
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        // main
        return dfsHelper(n, 0, dp);
    }
    public int dfsHelper(int n, int depth, int[] dp) {
        // base case
        if (n == 0) {
            if (depth == 1) {
                return -1;
            }else {
                return 1;
            }
        }
        //check dp
        if (dp[n] != Integer.MIN_VALUE) {
            return dp[n];
        }
        // cur level
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int temp = dfsHelper(n - i, depth + 1, dp);
            max = Math.max(max, temp * i);
        }
        dp[n] = max;
        return max;
    }
}
