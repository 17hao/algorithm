package leetcode.first;

import java.util.Stack;

/**
 * 基本计算器
 * 没有括号的加减乘除四则运算
 *
 * @since 2020-6-16 Thursday 17:26
 */
public class Code_227_BasicCalculator2 {
    static int calculate(String s) {
        int res = 0, d = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0') {
                d = d * 10 + (s.charAt(i) - '0');
            }
            if ((s.charAt(i) < '0' && s.charAt(i) != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(d);
                        break;
                    case '-':
                        stack.push(-d);
                        break;
                    case '*':
                        int m = stack.pop();
                        stack.push(d * m);
                        break;
                    case '/':
                        int n = stack.pop();
                        stack.push(n / d);
                        break;
                    default:
                        break;
                }
                sign = s.charAt(i);
                d = 0;
            }
        }
        for (Integer i : stack) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 2 * 3"));
        System.out.println(calculate("1 * 2 - 3"));
    }
}
