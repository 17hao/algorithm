package leetcode.fifth;

/**
 * 最长回文子串
 * 状态转移方程: dp[l][r] = (s.charAt(l) == s.charAt(r)) && ((r - l) < 3 || dp[l + 1][r - 1])
 * base case: dp[0][1] = s.charAt(l) == s.charAt(r)
 *
 * @since 2020-4-14 22:22 - 22:43
 */
public class Code_005_LongestPalindromicSubstring {
    static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        boolean[][] dp = new boolean[len][len];
        dp[0][1] = s.charAt(0) == s.charAt(1);
        String res = dp[0][1] ? s.substring(0, 2) : s.substring(0, 1);
        for (int r = 2; r < len; r++) {
            for (int l = r - 1; l >= 0; l--) {
                dp[l][r] = (s.charAt(l) == s.charAt(r)) && ((r - l) < 3 || dp[l + 1][r - 1]);
                if (dp[l][r] && (r - l + 1) > res.length()) {
                    res = s.substring(l, r + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome(""));
        System.out.println(longestPalindrome("babad")); //bab
        System.out.println(longestPalindrome("cbbd")); //bb
        System.out.println(longestPalindrome("qwerasdfqweradf"));
        System.out.println(longestPalindrome("bb"));
    }
}
