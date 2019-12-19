package leetcode.second;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * @since 2019-12-19 Thursday
 */
public class Code_066_PlusOne {
    static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{0})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(plusOne(new int[]{1, 2, 9})));
        System.out.println(Arrays.toString(plusOne(new int[]{9, 9, 9})));
    }
}
