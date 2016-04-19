import java.util.*;
/*
* medium
* 給一个单词和一个字典。每次删除单词里任何一个字母直到剩下一个字母，形成一个序列，
* 比如office->offce->ofce->ofc->oc->c。问是字典里否存在一个这种序列。
*/
//comment 一看到是否存在，还是一个序列，那很明显这类题就是一个搜索问题，
//具体只是DFS还是还可以用DP（memoization）优化，那就是下一步的事情了，把搜索树画出来，
//然后看有没有重复计算，如果没有，那么就不需要
public class DicWordSequence {
	public static void main(String[] args) {
		String str = "office";
		HashSet<String> set = new HashSet<String>();
		set.add("office");
		set.add("offce");
		set.add("offie");
		set.add("ofce");
		set.add("ofc");
		set.add("off");
		set.add("oc");
		set.add("c");
		set.add("e");
		// pre-process
		System.out.println(dfsHelper(str, set));
	}

	public static boolean dfsHelper(String str, HashSet<String> set) {
		// base case
		if (str.length() == 1) {
			return set.contains(str);
		}
		// main
		// cur level
		boolean result = false;
		for (int i = 0; i < str.length(); i++) {
			String afterRemove = removeHelper(str, i);
			// handle exception
			if (!set.contains(afterRemove)) {
				continue;
			}
			// next level
			result = result || dfsHelper(afterRemove, set);
		}
		return result;
	}
	public static String removeHelper(String str, int i) {
		return str.substring(0, i) + str.substring(i + 1);
	}
}
