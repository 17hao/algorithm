package leetcode.fourth;

/**
 * 最长回文子串
 * 状态转移方程: dp[l][r] = s.charAt[l] == s.charAt[r] && ((l + 1) >= (r - 1) || dp[l - 1][r + 1])
 * base case: dp[0][1] = s.charAt[0] == s.charAt[1]
 *
 * @since 2019-12-20 Friday
 */
public class Code_005_LongestPalindromeStr {
    static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        int resultLen = 1;
        String result = s.substring(0, 1);
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                dp[l][r] = s.charAt(l) == s.charAt(r) && ((l + 1) >= (r - 1) || dp[l + 1][r - 1]);
                if (dp[l][r] && (r - l + 1) > resultLen) {
                    resultLen = r - l + 1;
                    result = s.substring(l, r + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("aaaa"));
        System.out.println(longestPalindrome("ba"));
        System.out.println(longestPalindrome(""));
    }
}
