package leetcode.second;

/**
 * 最长合法括号
 * dp[i]为下标为i的位置的最长合法括号
 *
 * @since 2020-5-8 23:50 - 0:13
 */
public class Code_032_LongestValidParentheses {
    static int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int res = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (i > 0 && s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2) >= 0 ? dp[i - 2] + 2 : 2;
                } else if (s.charAt(i - 1) == ')' && (i - dp[i - 1] - 1) >= 0 &&
                        s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(""));
        System.out.println(longestValidParentheses("()()()()"));
        System.out.println(longestValidParentheses("))()()()"));
        System.out.println(longestValidParentheses("))()()((())))"));
    }
}
