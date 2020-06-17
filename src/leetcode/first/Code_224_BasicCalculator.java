package leetcode.first;

import java.util.Stack;

/**
 * 基本计算器
 * 只有括号,+-,数字的表达式
 *
 * @since 2020-6-17 Wednesday 19:12
 */
public class Code_224_BasicCalculator {
    static int calculate(String s) {
        int res = 0, sign = 1; // sign = 1 means +
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            if (s.charAt(i) >= '0') {
                while (i < s.length() && s.charAt(i) >= '0') {
                    num  = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += num * sign;
                if (i == s.length()) break;
            }
            switch (s.charAt(i)) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(res);
                    res = 0;
                    stack.push(sign);
                    sign = 1;
                    break;
                case ')':
                    res = stack.pop() * res + stack.pop();
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + (2 -3 ) + 4")); // 4
        System.out.println(calculate("1 - (2 + 3) - 4")); // -8
    }
}
