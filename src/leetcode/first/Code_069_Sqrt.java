package leetcode.first;

/**
 * x的平方根
 *
 * @since 2019-12-6 Friday
 */
public class Code_069_Sqrt {
    static int sqrt(int x) {
        int result = 0;
        for (long i = 0; i <= x / 2 + 1; i++) {
            long m = i * i;
            long n = (i + 1) * (i + 1);
            if (m == (long) x) {
                result = (int) i;
                break;
            }
            if (m < (long) x && n > (long) x) {
                result = (int) i;
                break;
            }
        }
        return result;
    }

    /**
     * Time Complex
     */
    static int sqrtV2(int x) {
        long left = 0;
        long right = (x >> 1) + 1;
        while (left < right) {
            long mid = (right + left + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(sqrtV2(0));
        System.out.println(sqrtV2(1));
        System.out.println(sqrtV2(4));
        System.out.println(sqrtV2(8));
        System.out.println(sqrtV2(16));
        System.out.println(sqrtV2(Integer.MAX_VALUE));
    }
}
