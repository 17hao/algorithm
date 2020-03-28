package leetcode.first;

/**
 * 两数相除.要求不使用乘法、除法和 mod 运算符。
 *
 * @since 2020-3-28 Saturday
 */
public class Code_029_Divide2Integers {
    static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        int res = helper(a, b);
        return (dividend ^ divisor) >= 0 ? res : -res;
    }

    private static int helper(int a, int b) {
        if (a > b) return 0;
        int count = 1, temp = b;
        while ((temp + temp) >= a && (temp + temp) < 0) {
            count += count;
            temp += temp;
        }
        return count + helper(a - temp, b);
    }

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(16, 3));
        System.out.println(divide(12, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MAX_VALUE, 2));
        System.out.println(divide(Integer.MIN_VALUE, 2));
    }
}
