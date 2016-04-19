/*
* easy
* 按照定义好的priority，给字符串排序。比如定义好的priority list是[o, r, d, e, r]，
*给定字符串是"horse"，得到结果是"orehs"，即如果字符串中的字符出现在priority list中，
*按priority排序，剩下字符append到后面。
*/
//comment: sort问题本质上就是把duplicate（or 具有相同priority的letter group到一起），那么hashtable
//就是一个很自然的选择
public class SortByPriorityList {
	public static void main(String[] args) {
		char[] pl = {'o', 'r', 'd', 'e', 'r'};
		String input = "horse";
		System.out.println(sortHelper(pl, input));
	}
	public static String sortHelper(char[] pl, String input) {
		String result = "";
		//first pass: add freq to hash table
		int[] freq = new int[26];
		for (int i = 0; i < input.length(); i++) {
			int index = (int)(input.charAt(i) - 'a');
			freq[index]++;
		}
		//second pass, iterate throug pl to
		for (int i = 0; i < pl.length; i++) {
			char curChar = pl[i];
			int index = (int)(curChar - 'a');
			while (freq[index] > 0) {
				result += curChar;
				freq[index]--;
			}
		}
		//last pass, add remaining letters to result
		for (int i = 0; i < freq.length; i++) {
			char curChar = (char)((int)('a') + i);
			while (freq[i] > 0) {
				result += curChar;
				freq[i]--;
			}
		}
		return result;
	}
}
