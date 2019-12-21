package leetcode.fourth;

import java.util.LinkedHashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * @since 2019-12-21 Saturday
 */
public class Code_003_LongestSubStr {
    static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        set.add(s.charAt(0));
        int result = 1;
        for (int l = 0, r = 1; r < s.length(); r++) {
            if (set.contains(s.charAt(r))) {
                result = Math.max(result, set.size());
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l++));
                }
            }
            set.add(s.charAt(r));
        }
        return Math.max(result, set.size());
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abccqwert"));
        System.out.println(lengthOfLongestSubstring("abcaqwert"));
        System.out.println(lengthOfLongestSubstring("cqwerttabc"));
        System.out.println("===");
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("ab"));
        System.out.println(lengthOfLongestSubstring("aaabb"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("ohomm"));
    }
}
