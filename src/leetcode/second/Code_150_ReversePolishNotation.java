package leetcode.second;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 *
 * @since 2019-12-28 Saturday
 */
public class Code_150_ReversePolishNotation {
    static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int n1 = stack.pop();
                    stack.push(stack.pop() - n1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int n2 = stack.pop();
                    stack.push(stack.pop() / n2);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "4", "*"}));
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
