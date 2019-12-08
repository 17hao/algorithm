package leetcode.onece;

/**
 * 求x的平方根
 *
 * @since 2019-12-8 Sunday
 */
public class Code_069_Sqrt {
    static int sqrt(int x) {
        long left = 0;
        long right = (x >> 1) + 1;
        while (left < right) {
            long mid = (left + right + 1) >> 1;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(0));
        System.out.println(sqrt(1));
        System.out.println(sqrt(2));
        System.out.println(sqrt(3));
        System.out.println(sqrt(4));
        System.out.println("===");
        System.out.println(sqrt(8));
        System.out.println(sqrt(16));
        System.out.println(sqrt(25));
        System.out.println(sqrt(Integer.MAX_VALUE));
    }
}
