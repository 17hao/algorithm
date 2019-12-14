package leetcode.first;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 假定该字符串只包含小写字母。
 *
 * @since 2019-12-14 Saturday
 */
public class Code_387_1stUniqueCharInStr {
    static int firstUniqueChar(String s) {
        if (s.length() == 0) return -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode")); // 0
        System.out.println(firstUniqueChar("loveleetcode")); // 2
        System.out.println(firstUniqueChar("sqh")); // 0
        System.out.println(firstUniqueChar("ssqh")); // 2
        System.out.println(firstUniqueChar("sqqh")); // 0
        System.out.println(firstUniqueChar("ssqhh")); // 2
        System.out.println(firstUniqueChar("ssqqh")); // 4
        System.out.println(firstUniqueChar("ssqqhh")); // -1
    }
}
