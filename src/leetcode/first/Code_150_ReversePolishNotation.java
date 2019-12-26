package leetcode.first;

import java.util.Stack;

/**
 * 根据逆波兰表示法，求表达式的值。
 *
 * @since 2019-12-26 Thursday
 */
public class Code_150_ReversePolishNotation {
    static int evalRPN(String[] tokens) {
        int result;
        if (tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+":
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-":
                    int n1 = stack.pop();
                    result = stack.pop() - n1;
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                case "/":
                    int n2 = stack.pop();
                    result = stack.pop() / n2;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"})); // ((2 + 1) * 3) = 9
        System.out.println(evalRPN(new String[]{"4", "3", "-"})); // 1
        System.out.println(evalRPN(new String[]{"4", "13", "5", "/", "+"})); // (4 + (13 / 5)) = 6
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }
}
