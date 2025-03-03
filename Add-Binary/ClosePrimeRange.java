import java.util.Arrays;

public class ClosePrimeRange {

    public static boolean[] sieve(int range) {
        int listLength = (range + 1);
        boolean list[] = new boolean[listLength];
        for (int i = 0; i < listLength; i++) {
            list[i] = true;
        }

        list[0] = list[1] = false;

        for (int i = 2; i * i <= range; i++) {
            if (list[i]) {
                for (int j = i * i; j <= range; j += i) {
                    list[j] = false;
                }
            }
        }

        for (int i = 0; i < listLength; i++) {
            if (list[i])
                System.out.print(i + " ");
        }
        System.out.println();

        return list;
    }

    public static int[] closestPrimes(int left, int right) {
        int listLength = right;
        boolean list[] = sieve(right);

        for (int i = left; i < listLength; i++) {
            if (list[i]) {
                left = i;
                break;
            }
        }
        System.out.println("Left: " + left);
        int diff = Integer.MAX_VALUE;
        int prev = -1;
        int firstPrime = -1;

        for (int i = left; i <= listLength; i++) {
            if (list[i]) {
                if (prev == -1) {
                    prev = i;
                    firstPrime = i;
                } else {
                    if ((i - prev) < diff) {
                        diff = i - prev;
                        firstPrime = prev;
                        prev = i;
                    } else {
                        prev = i;
                    }
                }
            }
        }
        if (firstPrime == -1 || prev == firstPrime) {
            return new int[] { -1, -1 };
        }
        return new int[] { firstPrime, prev };
    }

    public static void main(String[] args) {
        int left = 19;
        int right = 31;
        System.out.println("Closest Primes: " + Arrays.toString(closestPrimes(left, right)));
    }
}
