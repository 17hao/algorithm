package leetcode.third;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出一个字符串中最长无重复的子字符串长度
 *
 * @since 12-3 Thursday
 */
public class Code_003_LongestSubStr {
    static int longestSubStr(String s) {
        if (s.length() <= 1) return s.length();
        Set<Character> window = new HashSet<>();
        window.add(s.charAt(0));
        int result = 1;
        int l = 0, r = 1;
        for (; r < s.length(); r++) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r));
            } else {
                while (window.contains(s.charAt(r))) {
                    window.remove(s.charAt(l++));
                }
                window.add(s.charAt(r));
            }
            result = Math.max(result, r - l + 1);
        }
        return result;
    }

    static int longestSubStrV2(String s) {
        Set<Character> window = new HashSet<>();
        int l = 0, r = 0, result = 0;
        while (l < s.length() && r < s.length()) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r++));
                result = Math.max(result, window.size());
            } else {
                window.remove(s.charAt(l++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = "a";
        String s3 = "abc";
        String s4 = "abcba";
        String s5 = "abcabcde";
        String s6 = "abcabcbb";
        String s7 = "abcabcbbb";
        System.out.println(longestSubStrV2(s1));
        System.out.println(longestSubStrV2(s2));
        System.out.println(longestSubStrV2(s3));
        System.out.println(longestSubStrV2(s4));
        System.out.println(longestSubStrV2(s5));
        System.out.println(longestSubStrV2(s6));
        System.out.println(longestSubStrV2(s7));
    }
}
