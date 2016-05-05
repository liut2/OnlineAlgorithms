import java.util.*;
/*
flip one bit to obtain the longest sequence of 1s
*/
public class FlipBitToWin {
	public static void main(String[] args) {
		System.out.println(flip(1775));
	}
	public static int flip(int value) {
		int[] bits = new int[32];
		convertToBinary(value, bits);
		int[] left = new int[32];
		int[] right = new int[32];
		//first pass: record longest sequence of 1 to the left
		for (int i = 1; i < bits.length; i++) {
			if (bits[i - 1] == 0) {
				left[i] = 0;
			} else {
				left[i] = left[i - 1] + 1;
			}
		}
		//second pass:
		for (int i = bits.length - 2; i >= 0; i--) {
			if (bits[i + 1] == 0) {
				right[i] = 0;
			} else {
				right[i] = right[i + 1] + 1;
			}
		}
		//final pass to combine
		int max = 0;
		for (int i = 1; i < bits.length - 1; i++) {
			if (bits[i] == 0) {
				int temp = left[i] + 1 + right[i];
				max = Math.max(temp, max);
			}
		}
		if (bits[0] == 0) {
			max = Math.max(max, 1 + right[0]);
		}
		if (bits[bits.length - 1] == 0) {
			max = Math.max(max, 1 + left[bits.length - 1]);
		}
		return max;
	}
	public static void convertToBinary(int value, int[] bits) {
		int tester = 1;
		for (int i = bits.length -1; i >= 0 ;i--) {
			if ((tester & value) != 0) {
				bits[i] = 1;
			}else {
				bits[i] = 0;
			}
			tester = tester << 1;
		}
	}	

}