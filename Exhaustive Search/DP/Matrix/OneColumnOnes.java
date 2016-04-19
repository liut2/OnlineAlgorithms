import java.util.*;
import java.io.*;

public class OneColumnOnes {
    public static void main (String[] args) {
        //read std input
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] matrix = new int[row][col];
        boolean allZero = false;
        for (int i = 0; i < row; i++) {
            String curLine = sc.next();
            allZero = false;
            //System.out.print(curLine);
            for (int j = 0; j < col; j++) {
                matrix[i][j] = curLine.charAt(j) == '0'? 0: 1;
                //System.out.print(matrix[i][j]+ " ");
                if (matrix[i][j] == 1) {
                    allZero = true;
                }
            }
            if (!allZero) {
                System.out.println(-1);
                return;
            }
            //System.out.println();
        }
        System.out.println(helper(matrix));
    }
    public static int helper(int[][] matrix){
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return -1;
        }
        //init dp state
        int row = matrix.length;
        int col = matrix[0].length;
        //System.out.println(row + " " + col);
        int[] temp = new int[col];
        for (int j = 0; j < col; j++) {
            temp[j] = minMove(matrix, 0, j);
        }
        for (int j = 0; j < col; j++) {
            matrix[0][j] = temp[j];
        }
        //main 
        for (int i = 1; i < row; i++) {
            temp = new int[col];
            for (int j = 0; j < col; j++) {
                //System.out.println(i + " " + j);
                temp[j] = minMove(matrix, i, j) + matrix[i - 1][j];
            }
            for (int j = 0; j < col; j++) {
                matrix[i][j] = temp[j];
            }
        }
        //final result
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            min = Math.min(min, matrix[row - 1][j]);
        }
        return min;
    }
    public static boolean contains(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return true;
            }
        }
        return false;
    }
    public static int minMove(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 1) {
            return 0;
        }
        //else count shift left 
        int start = j;
        int countLeftShift = 0;
        while (matrix[i][start] == 0) {
            countLeftShift++;
            start++;
            start = start % matrix[0].length;
        }
        start = j;
        int countRightShift = 0;
        while (matrix[i][start] == 0) {
            countRightShift++;
            start--;
            start = (start + matrix[0].length) % matrix[0].length;
            if (countRightShift > countLeftShift) {
                break;
            }
        }
        return Math.min(countRightShift, countLeftShift);
    }
}