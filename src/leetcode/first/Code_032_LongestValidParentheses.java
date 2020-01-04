package leetcode.first;

import java.util.Stack;

/**
 * 最长有效括号
 *
 * @since 2020-1-3
 */
public class Code_032_LongestValidParentheses {
    static int longestValidParenthesesV1(String s) {
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

    /**
     * dp[i]表示以下标i结尾的字符串中最长有效括号值
     */
    static int longestValidParenthesesV2(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParenthesesV1("()()()()"));
        System.out.println(longestValidParenthesesV1(")(()())()()"));
        System.out.println(longestValidParenthesesV1("())()()"));
        System.out.println("===");
        System.out.println(longestValidParenthesesV2("()()()()"));
        System.out.println(longestValidParenthesesV2(")(()())()()"));
        System.out.println(longestValidParenthesesV2("())()()"));
    }
}
