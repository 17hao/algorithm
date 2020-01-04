package leetcode.first;

import java.util.Arrays;

/**
 * 解码方式
 * 状态方程:
 * if (s[i] = 0 & (s[i - 1] = 1 | 2)) than (dp[i] = dp[i - 2])
 * if (s[i - 1] = 1) than dp[i] = dp[i - 1] + dp[i - 2]
 * if (s[i - 1] = 2 & 1 <= s[i] <= 6) than dp[i] = dp[i - 1] + dp[i - 2]
 *
 * @since 2020-1-4
 */
public class Code_091_DecodeWays {
    static int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else if (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : 1);
            } else if (s.charAt(i - 1) == '1') {
                dp[i] = dp[i - 1] + (i - 2 >= 0 ? dp[i - 2] : i);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        // System.out.println(numDecodings("12"));
        // System.out.println(numDecodings("226"));
        System.out.println(numDecodings("123456"));
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("0"));
    }
}
