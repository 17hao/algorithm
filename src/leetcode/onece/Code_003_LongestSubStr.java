package leetcode.onece;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出一个字符串中最长无重复的子字符串长度
 *
 * @since 11-27 Wednesday
 */
public class Code_003_LongestSubStr {
    static int longestSubStr(String s) {
        Set<Character> window = new HashSet<>();
        int result = 0;
        int l = 0, r = 0;
        while (l < s.length() && r < s.length()) {
            if (!window.contains(s.charAt(r))) {
                window.add(s.charAt(r++));
                result = Math.max(result, r - l);
            } else {
                window.remove(s.charAt(l++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "abcabcd";
        String s3 = "";
        String s4 = "a";
        String s5 = "aaa";
        System.out.println(longestSubStr(s1));
        System.out.println(longestSubStr(s2));
        System.out.println(longestSubStr(s3));
        System.out.println(longestSubStr(s4));
        System.out.println(longestSubStr(s5));
    }
}
