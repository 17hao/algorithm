package leetcode.first;

/**
 * 完全平方数
 * 
 * @since 2020-8-16 Sunday 17:52
 */
public class Code_367_ValidPerfectSquare {
    static boolean isPerfectSquare(int num) {
        int n = 1;
        while (num > 0) {
            num -= n;
            n += 2;
        }
        return num == 0;
    }

    static boolean _isPerfectSquare(int num) {
        long start = 0, end = num / 2 + 1;
        while (start <= end) {
            long mid = (start + end) / 2;
            long tmp = mid * mid;
            if (tmp == num) {
                return true;
            } else if (tmp > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(19));
        System.out.println(isPerfectSquare(1));
        System.out.println(isPerfectSquare(2));
        System.out.println(isPerfectSquare(3));
        System.out.println(isPerfectSquare(4));
        System.out.println(isPerfectSquare(9));
        System.out.println(isPerfectSquare(2147483647));
        System.out.println("====");
        System.out.println(_isPerfectSquare(19));
        System.out.println(_isPerfectSquare(1));
        System.out.println(_isPerfectSquare(2));
        System.out.println(_isPerfectSquare(3));
        System.out.println(_isPerfectSquare(4));
        System.out.println(_isPerfectSquare(9));
        System.out.println(_isPerfectSquare(2147483647));
    }
}