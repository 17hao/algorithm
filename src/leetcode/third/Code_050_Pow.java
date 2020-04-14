package leetcode.third;

/**
 * 计算pow(x, y)
 *
 * @since 2020-4-12 Sunday 22:33
 */
public class Code_050_Pow {
    static double myPow(double x, int n) {
        long m = n;
        if (n < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1;
        double currentProduct = x;
        for (; m > 0; m /= 2) {
            if (m % 2 == 1) {
                res = res * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return res;
    }

    static double myPowV2(double x, int n) {
        long m = n;
        if (n < 0) {
            x = 1 / x;
            m = -m;
        }
        return fastPow(x, m);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 1));
        System.out.println(myPow(2, 10));
        System.out.println(myPow(0, 1));
        System.out.println(myPow(2, -1));
        System.out.println(myPow(2, -2));
        System.out.println(myPow(99, Integer.MAX_VALUE));
        System.out.println(myPow(99, Integer.MIN_VALUE));
        System.out.println(myPow(-99, Integer.MAX_VALUE));
        System.out.println(myPow(99, Integer.MIN_VALUE));
    }
}
