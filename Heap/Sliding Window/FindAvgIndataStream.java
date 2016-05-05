import java.util.*;
/*
*O(1)时间找stream number最近的N的数的average
*/
//comment：典型的sliding window问题，只需先加后减维护一个窗口即可
public class FindAvgIndataStream {
	public static void main(String[] args) {
		int[] data = {3, 5, 7, 1, 4, 9, 6};
		int n = 3;
		int[] result = findHelper(data, n);
		System.out.println(Arrays.toString(result));
	}
	public static int[] findHelper(int[] data, int n) {
		// edge case
		if (data.length < n) {
			return null;
		}
		// pre-process
		int[] result = new int[data.length - n + 1];
		// main
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			//maintain a window of size n
			if (i < n) {
				sum += data[i];
			} else {
				sum += data[i];
				sum -= data[i - n];
			}
			if (i >= n - 1) {
				result[i - n + 1] = sum / n;
			}
		}
		return result;
	}
}
