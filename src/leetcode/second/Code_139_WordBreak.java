package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单词拆分
 *
 * 字典最长的单词长度: len
 * 状态方程定义: dp[i]表示第i - 1个字符能否被拆成字典中的词(i从1开始计数, 0表示空字符串)
 * 状态转移方程: dp[i] = dp[j] && wordDict.contains(s.substring(j, i)) | max(i-len,0) <= j < i
 * base case: dp[0] = true
 *
 * @since 2020-5-2 Saturday 15:33 - 16:10
 */
public class Code_139_WordBreak {
    static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int maxWord = 0;
        for (String w : wordDict) {
            maxWord = Math.max(w.length(), maxWord);
        }
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
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
        System.out.println(wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
        System.out.println(wordBreak("aaaaaaa", new ArrayList<>(Arrays.asList("aaaa", "aaa"))));
    }
}
