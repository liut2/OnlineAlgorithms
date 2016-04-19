import java.util.*;
import java.io.*;
/*
小蒜头又调皮了。这一次，姐姐的实验报告惨遭毒手。

姐姐的实验报告上原本记录着从 1 到 n 的序列，任意两个数字间用空格间隔。但是“坑姐”的蒜头居然把数字间的空格都给删掉了，整个数字序列变成一个长度为 1 到 100 的且首部没有空格的数字串。

现在姐姐已经怒了，蒜头找你写个程序快点把试验数据复原。

输入

输入文件有一行，为一个字符串——被蒜头搞乱的实验数据。

字符串的长度在 1 到 100 之间。

输出

输出共一行，为姐姐的原始测试数据—— 1 到 n 的输出。

任意两个数据之间有一个空格。

如果有多组符合要求的正确解，输出其中任意一组即可。
*/
public class RecoverReport {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        //pre-process
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        int[] max = {0};
        helper(str, set, 0, max, temp, result);
        for (int i = 0; i < result.get(0).size(); i++){
            System.out.print(result.get(0).get(i) + " ");
        }
    }
    public static void helper(String str, HashSet<Integer> set, int pos, int[] max, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
        //base case
        if (pos == str.length()){
            if (valid(set, max)){
                result.add(new ArrayList<Integer>(temp));
            }
            return;
        }
        //main body
        //cur level
        for (int i = pos; i < pos + 2; i++){
            //handle exceptions
            if (i >= str.length()){
                break;
            }
            String subStr = str.substring(pos, i + 1);
            if (subStr.charAt(0) == '0' || Integer.parseInt(subStr) > 60){
                continue;
            }
            if (set.contains(Integer.parseInt(subStr))){
                continue;
            }
            //
            temp.add(Integer.parseInt(subStr));
            set.add(Integer.parseInt(subStr));
            int oriMax = max[0];
            max[0] = Math.max(max[0], Integer.parseInt(subStr));
            //next level
            helper(str, set, i + 1, max, temp, result);
            //backtrack
            temp.remove(temp.size() - 1);
            set.remove(Integer.parseInt(subStr));
            max[0] = oriMax;
        }
    }
    public static boolean valid(HashSet<Integer> set, int[] max){
        for (int i = 1; i <= max[0]; i++){
            if (!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}