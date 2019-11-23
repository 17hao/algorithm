package leetcode.zeroth;

/**
 * 找出一个字符串中最长的回文字符串
 * @data 11-22 Friday
 */
public class Code_005_LongestPalindromeStr {
    static String longestPalindromeStr(String s) {
        int len = s.length();
        int lengthOfResult = 1;
        String result = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len]; // default value: false
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if ((r - l + 1) > lengthOfResult) {
                        lengthOfResult = r - l + 1;
                        result = s.substring(l, r + 1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "abcdedcbg";
        System.out.println(longestPalindromeStr(str2));
    }
}
