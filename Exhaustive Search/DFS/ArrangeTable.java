import java.util.*;
import java.io.*;
/*
Matrix67发现身高接近的人似乎更合得来。Matrix67举办的派对共有N(1< =N< =10)个人参加，Matrix67需要把他们安排在圆桌上。Matrix67的安排原则是，圆桌上任意两个相邻人的身高之差不能超过K。请告诉Matrix67他共有多少种安排方法。

输入格式:

第一行输入两个用空格隔开的数N和K，其中1< =N< =10，1< =K< =1  000  000。第二行到第N+1行每行输入一个人的身高值。所有人的身高都是不超过1  000  000的正整数

输出格式：

输出符合要求的安排总数
*/
public class ArrangeTable {
    private static int[] count = {0};
    public static void main(String[] args){
        //pre-process
        Scanner s = new Scanner(System.in);
        int numberOfPeople = s.nextInt();
        int diff = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int i = 0;
        while (i < numberOfPeople){
            arr.add(s.nextInt());
            i++;
        }
        boolean[] visited = new boolean[arr.size()];
        visited[0] = true;
        countPlan(visited, arr, diff, arr.get(0), 1);
        System.out.println(count[0]);
    }
    public static void countPlan(boolean[] visited, ArrayList<Integer> arr, int diff, int prev, int pos){
        //base case
        if (pos == arr.size()){
            if (Math.abs(prev - arr.get(0)) <= diff){
                count[0]++;
            }
            return;
        }
        //main body
        //cur level
        for (int i = 0; i < arr.size(); i++){
            if (visited[i]){
                continue;
            }
            if (Math.abs(prev - arr.get(i)) <= diff){
                visited[i] = true;
                //next level
                countPlan(visited, arr, diff, arr.get(i), pos + 1);
                //backtrack
                visited[i] = false;
            }
        }
    }
}