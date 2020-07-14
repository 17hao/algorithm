package misc;

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
        System.out.println(new Expression("1 + 2 - 3").toRPN());
        System.out.println(new Expression("1 + 2 - 3 * 4").toRPN());
        System.out.println(new Expression("1 * 2 - 3 + 4").toRPN());
        System.out.println(new Expression("1 - (2 * (3 + 4))").toRPN());
        System.out.println(new Expression("(4 + (13 / 5))").toRPN());
        System.out.println(new Expression("((2 + 1) * 3)").toRPN());
    }
}

class Expression {
    private final String value;

    Expression(String value) {
        this.value = value;
    }

    public String toRPN() {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ' ') {
                continue;
            }
            int cur = 0;
            if (Character.isDigit(value.charAt(i))) {
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
                stack.push(value.charAt(i));
                continue;
            }
            if (value.charAt(i) == '(') {
                stack.push(value.charAt(i));
                continue;
            }
            if (value.charAt(i) == ')') {
                while (stack.peek() != '(') {
                    res.append(stack.pop() + " ");
                }
                stack.pop();
                continue;
            }
            if (hePrecedence(value.charAt(i), stack.peek())) {
                stack.push(value.charAt(i));
            } else {
                res.append(stack.pop() + " ");
                stack.push(value.charAt(i));
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
    private boolean hePrecedence(char a, char b) {
        if (a != '(' && b == '(') {
            return true;
        }
        if (a == b) {
            return true;
        }
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        }
        if ((a == '*' || a == '/') && (b == '*' || b == '/')) {
            return true;
        }
        if ((a == '+' || a == '-') && (b == '+' || b == '-')) {
            return true;
        }
        return false;
    }
}