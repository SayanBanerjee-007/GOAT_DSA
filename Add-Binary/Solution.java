import java.util.Arrays;

class Solution {
    public static int msbPosition(int number) {
        if (number == 0) {
            return -1;
        }
        int position = 0;
        while (number != 0) {
            number >>= 1;
            position++;
        }
        return position - 1;
    }

    public int[] decode(int[] encoded) {
        int encodedLength = encoded.length;
        int perm[] = new int[encodedLength + 1];

        for (int i = 0; i < encodedLength; i += 2) {
            int xor = encoded[i] ^ encoded[i + 1];
            System.out.println("XOR: " + Integer.toBinaryString(xor) + " [" + xor + "]");
            int msbPos = Math.max(msbPosition(encoded[i]), msbPosition(encoded[i + 1]));
            int evenValue = ~xor & ((1 << (msbPos + 1)) - 1);

            if (i == 0) {
                perm[i] = evenValue ^ encoded[i];
                System.out.println("perm[" + i + "]: " + Integer.toBinaryString(perm[i]) + " [" + perm[i] + "]");
            }
            perm[i + 1] = evenValue;
            perm[i + 2] = evenValue ^ encoded[i + 1];
            System.out.println(
                    "perm[" + (i + 1) + "]: " + Integer.toBinaryString(perm[i + 1]) + " [" + perm[i + 1] + "]");
            System.out.println(
                    "perm[" + (i + 2) + "]: " + Integer.toBinaryString(perm[i + 2]) + " [" + perm[i + 2] + "]");
            System.out.println();
        }
        return perm;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Result: [2, 4, 1, 5, 3]");
        int[] encoded = { 6, 5, 4, 6 };
        System.out.println("Encoded: " + Arrays.toString(encoded));
        System.out.println();
        int[] perm = s.decode(encoded);
        System.out.println("Perm: " + Arrays.toString(perm));
    }
}
