package leetcode.first;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 *
 * @since 2019-12-23 Monday
 */
public class Code_172_FactorialTrailingZeroes {
    static int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
        System.out.println(trailingZeroes(20));
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(5));
    }
}
