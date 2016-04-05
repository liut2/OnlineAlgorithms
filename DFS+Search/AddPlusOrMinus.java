import java.util.*;
import java.io.*;
/*
请考虑一个被空格分隔的，由1到N的整数组成的递增数列：1 2 3 ... N。现在请在数列中插入表示加的“+”，或者表示减“-”，亦或者表示空白的“ ”(例如1-2 3就等于1-23)，来将每一对数字组合成一个表达式（第一个数字前无空格）。计算该表达式的结果并判断其值是否为0。请你写一个程序找出所有产生和为零的长度为N的数列。
输入为一行，包含一个整数N（3≤N≤9）.输出为所有在每对数字间插入“+”, “-”, 或 “ ”后能得到和为零的数列，并按照字典（ASCII码）序排列。
样例1
输入：
7
输出：
1+2-3+4-5-6+7
1+2-3-4+5+6-7
1-2 3+4+5+6+7
1-2 3-4 5+6 7
1-2+3+4-5+6-7
1-2-3-4-5+6+7
*/
public class AddPlusOrMinus {
    public static void main (String[] args){
        //get stdin
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //System.out.println(n);
        //pre-process
        //result list
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 2){
            return;
        }
        //int array from 1 to n
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i + 1;
        }
        HashSet<String> set = new HashSet<String>();
        dfsHelper(arr, 0, 0, '+', "", result, set);
        Collections.sort(result);
        for (String str : result) {
            System.out.println(str);
        }
    }
    public static void dfsHelper(int[] arr, int pos, int prevValue, char prevOperator, String temp, ArrayList<String> result, HashSet<String> set) {
        //base case
        if (pos == arr.length) {
            if (prevValue == 0){
                String curResult = temp.substring(0, temp.length() - 1);
                if (!set.contains(curResult)){
                    set.add(curResult);
                    result.add(curResult);
                }
            }
            return;
        }
        //main body
        //cur level
        for (int i = pos; i < arr.length; i++){
            int curValue = getCurValue(arr, pos, i);
            String curString = getCurString(arr, pos, i);
            if (prevOperator == '+'){
                curValue = prevValue + curValue;
            }else{
                curValue = prevValue - curValue;
            }
            dfsHelper(arr, i + 1, curValue, '+', temp + curString + "+", result, set);
            dfsHelper(arr, i + 1, curValue, '-', temp + curString + "-", result, set);
        }
    }
    public static String getCurString(int[] arr, int start, int end){
        String result = "";
        for (int i = start; i <= end; i++) {
            result += arr[i] + " ";
        }
        return result.substring(0, result.length() - 1);
    }
    public static int getCurValue(int[] arr, int start, int end){
        int result = 0;
        for (int i = start; i <= end; i++){
            result = result * 10 + arr[i];
        }
        return result;
    }
}