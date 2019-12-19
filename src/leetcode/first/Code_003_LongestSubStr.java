package leetcode.first;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出一个字符串中最长的不重复子字符串的长度
 *
 * @since 2019-11-26 Thursday
 */
public class Code_003_LongestSubStr {
    static int lengthOfLongestSubString(String s) {
        if (s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int result = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                result = Math.max(result, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "";
        String s3 = "a";
        String s4 = "aaa";
        System.out.println(lengthOfLongestSubString(s1));
    }
}
