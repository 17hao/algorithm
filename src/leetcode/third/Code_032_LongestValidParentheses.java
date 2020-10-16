package leetcode.third;

/**
 * 最长有效括号
 * 状态方程定义：dp[i]表示下标i的子串的最大有效括号
 * 状态转移方程：if(s[i]==')') if(s[i-1]=='(') dp[i]=i-2>=0?dp[i-2]+2:2 if (s[i-1]==')'&&s[i-dp[i-1]-1]=='('&&i-dp[i-1]-1>=0) dp[i]=dp[i-1]+2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)
 * 初始状态：dp[i]=0
 * 返回值：res=max(res,dp[i])
 * 
 * @since 2020-7-27 Monday 19:05 - 19:38
 */
public class Code_032_LongestValidParentheses {
    static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (i > 0 && s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (i > 0 && s.charAt(i - 1) == ')' && i - dp[i - 1] - 1 >= 0
                        && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")(())"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses("()(())"));
    }
}