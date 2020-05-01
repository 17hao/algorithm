package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 *
 * @since 2020-5-1 Friday 22:58
 */
public class Code_139_WordBreak {
    static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        if (len == 0) return true;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        int maxWord = 0;
        for (String w : wordDict) {
            maxWord = Math.max(maxWord, w.length());
        }
        for (int i = 0; i <= len; i++) {
            for (int j = Math.max(i - maxWord, 0); j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(wordBreak("", new ArrayList<>(Arrays.asList("leet", "code"))));
    }
}
