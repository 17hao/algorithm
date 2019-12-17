package leetcode.first;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。你可以假设字符串只包含小写字母。
 * input: s = "anagram", t = "nagaram"
 * output: true
 *
 * @since 2019-12-17 Tuesday
 */
public class Code_242_ValidAnagram {
    static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a'] -= 1;
        }
        for (int i : count) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("", ""));
        System.out.println(isAnagram("anagram", "naagram"));
        System.out.println(isAnagram("cat", "catt"));
    }
}
