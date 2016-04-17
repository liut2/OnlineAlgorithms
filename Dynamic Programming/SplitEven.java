/* author: Tao Liu
*  Given an int array, split it into two sets so that their sum is closest to each other
*  e.g. int[] arr = [1, 24, 5, 6], the result should be [1, 5, 6] and [24]
*/
import java.util.*;

public class SplitEven {
    public static void main(String[] args) {
        int[] arr = {1, 6, 9, 24, 3, 2};
        knapsack(arr);
    }
    public static void knapsack(int[] arr) {
        //edge case
        if (arr == null || arr.length == 0) {
            return;
        }
        //pre-process
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum = sum / 2;
        //dp def
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        boolean[][] backtrack = new boolean[n + 1][sum + 1];
        //dp init
        //dp state transfer
        for (int i = 1; i < n + 1; i++) {
            int size = arr[i - 1];
            for (int j = 0; j < sum + 1; j++) {
                if (j < size) {
                    dp[i][j] = dp[i - 1][j];
                    backtrack[i][j] = false;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - size] + size);
                    backtrack[i][j] = true;
                }
            }
        }
        //int result = dp[n][sum];
        //backtrack
        for (int i = n; i >= 1; i--) {
            if (backtrack[i][sum]) {
                System.out.println(arr[i - 1]);
                sum = sum - arr[i - 1];
            }
        }
    }
}
