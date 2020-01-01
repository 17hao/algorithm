package leetcode.first;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * @since 2020-1-1
 */
public class Code_326_PowerOfThree {
    static boolean isPowerOfThreeV1(int n) {
        if (n == 1) return true;
        while (n > 1 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    // static boolean isPowerOfThreeV2(int n) {
    //     return n > 0 &&
    // }

    public static void main(String[] args) {
        System.out.println(isPowerOfThreeV1(0));
        System.out.println(isPowerOfThreeV1(1));
        System.out.println(isPowerOfThreeV1(2));
        System.out.println(isPowerOfThreeV1(3));
        System.out.println(isPowerOfThreeV1(27));
        System.out.println(isPowerOfThreeV1(28));
    }
}
