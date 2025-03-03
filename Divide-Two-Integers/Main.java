public class Main {

    // This solution is more efficient than the second one.
    // TC: O(log n) where n is the dividend, SC: O(1)
    public static int divide1(int dividend, int divisor) {

        // Edge case for divisor being 0
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is undefined");
        }
        // Edge case for dividend being 0
        else if (dividend == 0) {
            return 0;
        }
        // Edge case for overflow (Integer.MIN_VALUE / -1)
        else if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Edge case for divisor being 1
        else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        } else if (divisor == dividend) {
            return 1;
        } else if (divisor == -dividend) {
            return -1;
        }

        int result = 0;
        boolean hasDifferentSign = (dividend ^ divisor) < 0;

        // Convert to absolute values for easier manipulation
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        // Find the maximum bit shift for the divisor, so it's still less than the max
        // value of an integer
        int maxBitShift = 0;
        long max = Integer.MAX_VALUE + 1L;
        while ((divisorL << maxBitShift) <= max) {
            maxBitShift++;
        }
        maxBitShift--;

        System.out.println("Max bit shift: " + maxBitShift);

        for (int i = maxBitShift; i >= 0; i--) {
            long subtractedBy = (divisorL << i);
            System.out.println("Subtracted by: " + subtractedBy);
            while (subtractedBy <= dividendL) {
                System.out.println("SUBTRACTED");
                dividendL -= subtractedBy;
                result += (1 << i);
            }
            System.out.println("Result: " + result);
            System.out.println();
        }
        return hasDifferentSign ? -result : result;
    }

    // This is more straightforward and easier to understand, but it's not as
    // efficient as the first solution. With bigger numbers, it will take longer to
    // compute.
    // TC: O(log n) where n is the dividend, SC: O(1)
    public static int divide2(int dividend, int divisor) {
        // Edge case for divisor being 0
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is undefined");
        }
        // Edge case for dividend being 0
        else if (dividend == 0) {
            return 0;
        }
        // Edge case for overflow (Integer.MIN_VALUE / -1)
        else if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        // Edge case for divisor being 1
        else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return -dividend;
        } else if (divisor == dividend) {
            return 1;
        } else if (divisor == -dividend) {
            return -1;
        }

        int result = 0;
        boolean hasDifferentSign = (dividend ^ divisor) < 0;

        // Convert to absolute values for easier manipulation
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);

        while (dividendL >= divisorL) {
            int count = 0;
            while (dividendL >= (divisorL << (1 << count))) { // runs more than needed as
                // the number
                // while (dividendL >= (divisorL << (count + 1))) {
                System.out.println(
                        "divisorL[" + divisorL + "] << (count[" + count + "] + 1)): " + (divisorL << (1 << count)));
                // System.out.println("divisorL[" + divisorL + "] << (count[" + count + "] +
                // 1)): " + (divisorL << (count + 1)));
                count++;
            }
            result += 1 << count;
            dividendL -= divisorL << count;
            System.out.println("Result: " + result);
            System.out.println("Dividend: " + dividendL);
            System.out.println();
        }

        return hasDifferentSign ? -result : result;

    }

    public static void main(String[] args) {
        int dividend = 2147483647;
        int divisor = 2;
        System.out.println("Dividend: " + dividend + " Divisor: " + divisor);
        System.out.println();
        System.out.println(divide1(dividend, divisor));
        System.out.println(divide2(dividend, divisor));

    }
}
