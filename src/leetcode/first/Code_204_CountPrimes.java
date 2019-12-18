package leetcode.first;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * @since 2019-12-18 Wednesday
 */
public class Code_204_CountPrimes {
    static int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] helper = new boolean[n];
        Arrays.fill(helper, true);
        for (int i = 2; i * i < n; i++) {
            for (int j = 2; j * i < n; j++) {
                helper[j * i] = false;
            }
        }
        int result = 0;
        for (boolean b : helper) {
            if (b) result++;
        }
        return result - 2;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(15));
        System.out.println(countPrimes(17));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(4));
    }
}
