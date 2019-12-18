package leetcode.third;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * @since 2019-12-18 Wednesday
 */
public class Code_069_Sqrt {
    static int mySqrt(int x) {
        long left = 1, right = x >>> 1;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            long product = mid * mid;
            if (product == x) return (int) mid;
            if (product < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int) mid;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(3));
        System.out.println(mySqrt(4));
        System.out.println("== 0 ~ 4 ==");
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(10));
        System.out.println(mySqrt(16));
        System.out.println(mySqrt(25));
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }
}
