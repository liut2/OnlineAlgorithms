/**
* Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put before another string Y in circle if the last character of X is same as first character of Y.
* Examples:
* Input: arr[] = {"geek", "king"}
* Output: Yes, the given strings can be chained.
* Note that the last character of first string is same
* as first character of second string and vice versa is
* also true.
*
* Input: arr[] = {"for", "geek", "rig", "kaf"}
* Output: Yes, the given strings can be chained.
* The strings can be chained as "for", "rig", "geek" 
* and "kaf"
* @author Tao Liu
*/
import java.util.*;

public class ChainString {
	//test cases go here
	public static void main(String[] args){
		String[] test1 = {"geek", "king"};
		String[] test2 = {"for", "geek", "rig", "rag", "kaf"};
		String[] test3 = {"aab", "bac", "aaa", "cda"};
		String[] test4 = {"aaa", "bbb", "baa", "aab"};
		String[] test5 = {"aaa"};
		String[] test6 = {"aaa", "bbb"};
		String[] test7 = {"", "afd"};

		System.out.println(chainString(test1));
		System.out.println(chainString(test2));
		System.out.println(chainString(test3));
		System.out.println(chainString(test4));
		System.out.println(chainString(test5));
		System.out.println(chainString(test6));
		System.out.println(chainString(test7));

	}
	//solution here
	public static boolean chainString(String[] strs){
		//edge cases
		if (strs == null || strs.length == 0){
			return false;
		}
		String str = strs[0];
		if (str.length() == 0){
			return false;
		}
		//pre-process
		boolean[] visited = new boolean[strs.length];
		visited[0] = true;
		return helper(strs, visited, 1, str);
	}
	//dfs helper; this is a good example of a bottom-up solution where a return type is needed
	public static boolean helper(String[] strs, boolean[] visited, int count, String prev){
		//base case
		if (count == strs.length){
			if (strs[0].charAt(0) == prev.charAt(prev.length() - 1)){
				return true;
			}else{
				return false;
			}
		}
		//main body
		//cur level
		//for dfs whose return type is boolean, the solution is to init a false result, then or the result with the recursive calls and 
		//returns the final result
		boolean result = false;
		for (int i = 1; i < strs.length; i++){
			if (visited[i]){
				continue;
			}
			String temp = strs[i];
			if (temp.charAt(0) == prev.charAt(prev.length() - 1)){
				visited[i] = true;
				result = result || helper(strs, visited, count + 1, temp);
				visited[i] = false;
			}
		}

		return result;
	}
}