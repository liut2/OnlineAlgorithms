/*
Determine the number of bits required to flip if you want to convert integer n to integer m.
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int[] aBits = new int[32];
        int[] bBits = new int[32];
        convertToBinary(a, aBits);
        convertToBinary(b, bBits);
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (aBits[i] != bBits[i]) {
                count++;
            }
        }
        return count;
    }
    public static void convertToBinary(int n, int[] bits) {
        int tester = 1;
        for (int i = bits.length - 1; i >= 0; i--) {
            if ((tester & n) != 0) {
                bits[i] = 1 ;
            } else {
                bits[i] = 0;
            }
            tester = tester << 1;
        } 
    }
};
