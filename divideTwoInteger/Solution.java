public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Invalid divisor 0");
        if (divisor == 1)
            return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MAX_VALUE)
                throw new IllegalArgumentException("Overflows!");
            return 0 - dividend;
        }
        boolean isNeg = false;
        if (dividend < 0 && divisor > 0) {
            divisor = 0 - divisor;
            isNeg = true;
        }
        if (dividend > 0 && divisor < 0) {
            dividend = 0 - dividend;
            isNeg = true;
        }
        if (dividend > 0 && divisor > 0) {
            dividend = 0 - dividend;
            divisor = 0 - divisor;
        }
        if (divisor < dividend)
            return 0;
        int result = 0;
        while (dividend <= divisor) {
            dividend -= divisor;
            result += 1;
        }
        if (isNeg)
            return (0 - result);
        return result;
    }
}

