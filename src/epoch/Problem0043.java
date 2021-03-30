package epoch;

import java.util.Scanner;

/**
 * 字符串相乘
 * 123 * 456 = 56088
 * 问题拆解：
 * 1. 第一个数从低位开始与第二个数相乘，相乘的结果末尾按需添加0；将第一个数每一位与第二个数相乘的结果相加得到结果
 * 2. 每一位与第二个数字相乘转换成每一位与第二个数字每一位相乘，末尾按需添加0，将结果相加
 *
 * @since 2021-3-30 Thursday 22:16 - 22:54
 */
public class Problem0043 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String m = scanner.next();
        String n = scanner.next();
        System.out.println(multiply(m, n));
    }

    public static String multiply(String num1, String num2) {
        String res = "0";
        if (num1.equals("0") || num2.equals("0")) {
            return res;
        }
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0', y = num2.charAt(j) - '0';
                int n = x * y + carry;
                tmp.append(n % 10);
                carry = n > 9 ? n / 10 : 0;
            }
            if (carry > 0) {
                tmp.append(carry);
            }
            tmp.reverse();
            for (int z = 0; z < num1.length() - i - 1; z++) {
                tmp.append(0);
            }
            res = add(res, tmp.toString());
        }
        return res;
    }

    private static String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int x = num1.charAt(i) - '0', y = num2.charAt(j) - '0';
            res.append((x + y + carry) % 10);
            carry = x + y + carry > 9 ? 1 : 0;
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                int x = num1.charAt(i) - '0';
                res.append((x + carry) % 10);
                carry = x + carry > 9 ? 1 : 0;
                i--;
            }
        }
        if (j >= 0) {
            while (j >= 0) {
                int x = num2.charAt(j) - '0';
                res.append((x + carry) % 10);
                carry = x + carry > 9 ? 1 : 0;
                j--;
            }
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }
}
