package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Reverse Polish Notation
 * Convert infix expression to postfix expression(Reverse Polish Notation)
 * 1 遇到数字直接加入到输出结果
 * 2 遇到加减乘除：
 * 2-1 如果栈空，直接入栈
 * 2-2-1 如果非空
 * 2-2-1-1 如果当前运算符优先级大于等于栈顶元素则入栈
 * 2-2-1-2 如果当前运算符优先级小于栈顶元素的将栈顶元素弹出加入输出结果再将当前运算符入栈
 * 2-2-2 如果栈顶元素是左括号（优先级最小），当前操作符入栈
 * 3-1 遇到左括号一律入栈
 * 3-2 右括号则将栈顶元素弹出加入到输出结果中，直到遇到左括号
 * 
 * @since 2020-7-14 Tuesday  13:41
 */
public class RPN {
    public static void main(String[] args) {
        System.out.println(Expression.infixToPostfix("1 + 2 - 3"));
        System.out.println(Expression.infixToPostfix("1 + 2 - 3 * 4"));
        System.out.println(Expression.infixToPostfix("1 * 2 - 3 + 4"));
        System.out.println(Expression.infixToPostfix("1 - (2 * (3 + 4))"));
        System.out.println(Expression.infixToPostfix("(4 + (13 / 5))"));
        System.out.println(Expression.infixToPostfix("((2 + 1) * 3)"));
    }
}

class Expression {
    public static String infixToPostfix(String value) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int cur = 0;
                while (i < value.length() && value.charAt(i) >= '0' && value.charAt(i) <= '9') {
                    cur = cur * 10 + value.charAt(i) - '0';
                    i++;
                }
                res.append(cur + " ");
                i--;
                continue;
            }
            if (i == value.length()) {
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                while (stack.peek() != '(') {
                    res.append(stack.pop() + " ");
                }
                stack.pop();
                continue;
            }
            if (hePrecedence(c, stack.peek())) {
                stack.push(c);
            } else {
                res.append(stack.pop() + " ");
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop() + " ");
        }
        return res.toString().trim();
    }

    /**
     * higher or equal precedence
     */
    private static boolean hePrecedence(char a, char b) {
        List<Character> l1 = new ArrayList<>();
        l1.add('*');
        l1.add('/');
        List<Character> l2 = new ArrayList<>();
        l1.add('+');
        l1.add('-');
        if (b == '(') {
            return true;
        }
        if (a == b) {
            return true;
        }
        if (l1.contains(a)) {
            return true;
        }
        if (l2.contains(a) && l2.contains(b)) {
            return true;
        }
        return false;
    }
}