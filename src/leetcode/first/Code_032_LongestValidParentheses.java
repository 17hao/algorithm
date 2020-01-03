package leetcode.first;

import java.util.Stack;

/**
 * 最长有效括号
 *
 * @since 2020-1-3
 */
public class Code_032_LongestValidParentheses {
    static int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()()()()"));
        System.out.println(longestValidParentheses(")(()())()()"));
        System.out.println(longestValidParentheses("())()()"));
    }
}
