#include <algorithm>
#include <iostream>
#include <string>

using std::string;

/**
 * longest valid parentheses
 * 状态方程定义：dp[i]表示下标为i的位置的最长有效括号
 * 状态方程转移：if (s[i - 1] = '(')
 *                  dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 0
 *             if (s[i - 1] = ')' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] = '(')
 *                  dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0)
 * 初始化：dp[i]=0
 * 结果：dp中的最大值
 *
 * @since 2020-10-16 Friday 13:40 - 14:15
 */
class Solution {
   public:
    int longestValidParentheses(string s) {
        int len = s.size();
        if (len == 0) {
            return 0;
        }
        int dp[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 0;
        }
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (s[i] == ')') {
                if (s[i - 1] == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else if (s[i - 1] == ')' && i - dp[i - 1] - 1 >= 0 && s[i - dp[i - 1] - 1] == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
            }
            res = std::max(res, dp[i]);
        }
        return res;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    string s0 = "";
    string s1 = ")";
    string s2 = "(()";
    string s3 = ")()())";
    string s4 = "()(())()";
    std::cout << s.longestValidParentheses(s0) << "\n";
    std::cout << s.longestValidParentheses(s1) << "\n";
    std::cout << s.longestValidParentheses(s2) << "\n";
    std::cout << s.longestValidParentheses(s3) << "\n";
    std::cout << s.longestValidParentheses(s4) << "\n";
}
