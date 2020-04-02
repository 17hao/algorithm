package leetcode.fifth;

import java.util.HashSet;

/**
 * 最长无重复字符子串
 *
 * @since 2020-4-2 Thursday 22:33 - 22:44
 */
public class Code_003_LongestSubStr {
    static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int res = 1;
        HashSet<Character> slideWin = new HashSet<>();
        slideWin.add(s.charAt(0));
        for (int l = 0, r = 1; r < len; r++) {
            while (slideWin.contains(s.charAt(r)) && l < r) {
                slideWin.remove(s.charAt(l));
                l++;
            }
            slideWin.add(s.charAt(r));
            res = Math.max(res, slideWin.size());
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
