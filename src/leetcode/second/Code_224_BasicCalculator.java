package leetcode.second;

import java.util.Stack;

/**
 * 计算只有数字、+/-、（）的表达式
 * 
 * @since 2020-7-14 Tuesday 9:55 - 10:18
 */
public class Code_224_BasicCalculator {
    static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            int cur = 0;
            while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                cur = cur * 10 + s.charAt(i) - '0';
                i++;
            }
            res = res + sign * cur;
            if (i == s.length()) {
                continue;
            }
            if (s.charAt(i) == '+') {
                sign = 1;
                continue;
            }
            if (s.charAt(i) == '-') {
                sign = -1;
                continue;
            }
            if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                continue;
            }
            if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
                continue;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1")); // 1
        System.out.println(calculate("1 + 2 - 3")); // 0
        System.out.println(calculate("10 + 20 - 30 + 40")); // 4
        System.out.println(calculate("1 + (2 - 3)")); // 0
        System.out.println(calculate("1 + (2 - (3 + 4))")); // -4
    }
}