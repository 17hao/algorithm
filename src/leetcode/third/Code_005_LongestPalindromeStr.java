package leetcode.third;

/**
 * 找出一个字符串中最长的回文子字符串
 * base case: dp[0][0] = true;
 * 状态转移方程: dp[l][r] = s.charAt[l] == s.charAt[r] && ((l + 1) >= (r - 1) || !dp[l + 1][r - 1])
 *
 * @since 12-1 Sunday
 */
public class Code_005_LongestPalindromeStr {
    static String longestPalindromeStr(String s) {
        if (s.length() == 0) return s;
        int length = 1;
        String result = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {
                dp[l][r] = (s.charAt(l) == s.charAt(r)) && ((l + 1) >= (r - 1) || dp[l + 1][r - 1]);
                if (dp[l][r] && (r - l + 1) > length) {
                    result = s.substring(l, r + 1);
                    length = r - l + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "abc";
        String s3 = "abcd";
        String s4 = "abaqwewq";
        String s5 = "a";
        System.out.println(longestPalindromeStr(s1));
        System.out.println(longestPalindromeStr(s2));
        System.out.println(longestPalindromeStr(s3));
        System.out.println(longestPalindromeStr(s4));
        System.out.println(longestPalindromeStr(s5));
    }
}

