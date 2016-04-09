import java.util.*;
import java.io.*;

public class PointsOnLine {
    public static void main (String[] args) {
        //read std input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dis = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(helper(arr, dis));
    }
    public static long helper (int[] arr, int dis) {
        //edge case
        if (arr == null || arr.length <= 2) {
            return 0;
        }
        long count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int end = arr.length - 1;
            while (end > i + 1 && arr[end] - arr[i] > dis) {
                end--;
            }
            if (end > i + 1 && arr[end] - arr[i] <= dis) {
                count += sum(end - i - 1);
            }
        }
        return count;
    }
    public static long sum(int num) {
        return (1 + num) * num/2;
    }
}