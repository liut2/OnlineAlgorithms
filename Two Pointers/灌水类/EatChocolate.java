import java.util.*;
import java.io.*;

public class EatChocolate {
    public static void main (String[] args) {
        //read std input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //int dis = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = helper(arr);
        System.out.print(result[0]);
        System.out.print(" ");
        System.out.print(result[1]);
    }
    public static int[] helper(int[] arr) {
        //edge case
        if (arr == null || arr.length == 0){
            return new int[]{0, 0};
        }
        if (arr.length == 1) {
            return new int[]{1, 0};
        }
        //pre-process
        int start = 0;
        int end = arr.length - 1;
        int smaller = Integer.MAX_VALUE;
        while (start < end) {
            smaller = Math.min(arr[start], arr[end]);
            arr[start] -= smaller;
            arr[end] -= smaller;
            if (arr[start] == 0) {
                if (end - start == 1) {
                    break;
                }
                start++;
            }
            if (arr[end] == 0) {
                if (end - start == 1) {
                    break;
                }
                end--;
            }
        }
        
        return new int[] {start + 1, arr.length - start - 1};
        
    }
}