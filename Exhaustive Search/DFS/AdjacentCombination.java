/**
 * Given an integer array from 1 to n, generate all combination of these elements in which
 * every new element is no more than size k and digits in each new element should be adjacent.
 * e.g Given [1,2,3,4] and k = 2, all combinations are
 * 1 2 3 4
 * 12 3 4
 * 1 23 4
 * 1 2 3 34
 * 12 34
 * @author Tao Liu
 */
import java.util.*;

public class AdjacentCombination {
	//test cases go here
  	public static void main(String[] args){
  		int[] test1 = {1, 2, 3, 4, 5};
  		printHelper(adjacentCombination(test1, 3));

  	}
  	//solution here
  	public static ArrayList<ArrayList<Integer>> adjacentCombination(int[] array, int k){
  		//edge case
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (array == null || array.length == 0){
      		return result;
    	}
    	//pre-process
    	ArrayList<Integer> temp = new ArrayList<Integer>();
    	helper(array, k, 0, temp, result);
    	return result;
  	}
  	//dfs+search
  	public static void helper(int[] array, int k, int pos, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
  		//base case
  		if (pos == array.length){
  			result.add(new ArrayList<Integer>(temp));
  			return;
  		}
  		//main body
  		//cur level
  		StringBuilder sb = new StringBuilder();
  		for (int i = pos; i < pos + k; i++){
  			//handle exception
  			if (i >= array.length){
  				break;
  			}
  			//cur level
  			sb.append(array[i]);
  			temp.add(Integer.parseInt(sb.toString()));
  			//next level
  			helper(array, k, i + 1, temp, result);
  			//backtrack
  			temp.remove(temp.size() - 1);
  		}
  	}
  	public static void printHelper(ArrayList<ArrayList<Integer>> result){
  		for (ArrayList<Integer> temp : result){
  			for (int num : temp){
  				System.out.print(num + ", ");
  			}
  			System.out.println(" ");
  		}
  	}
}
