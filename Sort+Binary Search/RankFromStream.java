import java.util.*;

public class RankFromStream {
    private static ArrayList<Integer> arr = new ArrayList<Integer>();
    public static void main(String[] args){
        track(5);
        track(1);
        track(4);
        System.out.println(rank(4));
        System.out.println(rank(1));
        track(4);
        track(5);
        track(9);
        track(7);
        track(13);
        track(3);
        System.out.println(rank(4));
        System.out.println(rank(1));
    }
    public static void track(int x){
        arr.add(x);
        for (int i = arr.size() - 1; i >= 1; i--){
            if (arr.get(i) < arr.get(i - 1)){
                swap(arr, i, i - 1);
            }else{
                break;
            }
        }
    }
    public static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static int rank(int x){
        //edge case
        if (arr.size() == 0){
            return 0;
        }
        //pre-process
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        //binary search: find the last ocurrance of the x
        while (start + 1 < end){
            mid = start + (end - start)/2;
            if (arr.get(mid) == x){
                start = mid;
            }else if (arr.get(mid) < x){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (arr.get(end) <= x){
            return end + 1;
        }else if (arr.get(start) <= x){
            return start + 1;
        }
        return 0;
    }
}