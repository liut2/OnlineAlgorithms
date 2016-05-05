import java.util.*;
/*
	Insert M into N by replacing the bits in N from ith to jth positons.
*/
public class InsertBitsFromItoJ {
	public static void main(String[] args) {
		int N = 1 << 10;
		int M = 19;
		int i = 2;
		int j = 6;
		System.out.println(insert(M, N, i, j));
	}
	public static int insert(int M, int N, int i, int j) {
		//clear operation on N
		int a = (-1) << j;
		int b = (-1) >>> (32 - i);
		int mask = a | b;
		N = N & mask;
		M = M << i;
		return N | M;
	}
}