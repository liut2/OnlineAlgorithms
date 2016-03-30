import java.util.*;
import java.io.*;

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