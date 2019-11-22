package leetcode.zeroth;

import java.util.Scanner;

/**
 * 整数转罗马数字
 *
 * @author sqh
 * @date 2018/12/19
 */
public class Code_012_IntegerToRoman {
    private static Scanner scanner;

    private static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        int[] values = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] reps = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for (int i = 12; i >= 0; i--) {
            while (num >= values[i]) {
                num -= values[i];
                res.append(reps[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String res = intToRoman(num);
        System.out.print("结果是:" + res);
    }
}
