package leetcode.first;

/**
 * 字符串中回文子串的数量
 *
 * @since 2021-1-10 Sunday 21:15 - 21:53
 */
public class Code_647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int count = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                    count++;
                } else if (i - j == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = true;
                    count++;
                } else if (i - j > 1 && s.charAt(i) == s.charAt(j) && dp[j + 1][i - 1]) {
                    dp[j][i] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String... args) {
        Code_647_PalindromicSubstrings c = new Code_647_PalindromicSubstrings();
        System.out.println(c.countSubstrings("abc"));
        System.out.println(c.countSubstrings("aaa"));
        System.out.println(c.countSubstrings("aabbc"));
    }
}
