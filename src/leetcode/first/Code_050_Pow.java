package leetcode.first;

/**
 * 计算pow(x, y)
 *
 * @since 2019-12-21 Saturday
 */
public class Code_050_Pow {
    static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double rest = myPow(x, n % 2);
        return half * half * rest;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2.1, 2));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(34.00515, -3));
    }
}
