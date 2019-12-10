package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-03 21:17
 */
public class Code_231_PowerOfTwo {
    private static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        else {
            int remainder = 0;
            while (n != 1) {
                remainder = n % 2;
                if (remainder != 0) break;
                n = n / 2;
            }
            return remainder == 0;
        }
    }

    public static void main(String[] args) {
        int n = 0;
        boolean res = isPowerOfTwo(n);
        System.out.println(res);
    }
}
