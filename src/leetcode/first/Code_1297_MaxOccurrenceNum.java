package leetcode.first;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 满足条件的子串出现的最大次数
 * 
 * @since 2021-1-21 Thursday 13:39
 */
public class Code_1297_MaxOccurrenceNum {
    public int _maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            String cur = "";
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!set.contains(c)) {
                    set.add(c);
                }
                cur += s.charAt(j);
                int count = map.getOrDefault(cur, 0);
                if (set.size() <= maxLetters && cur.length() >= minSize) {
                    map.put(cur, ++count);
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i <= s.length() - minSize; i++) {
            String subStr = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < subStr.length(); j++) {
                set.add(subStr.charAt(j));
            }
            int count = map.getOrDefault(subStr, 0);
            if (set.size() <= maxLetters) {
                map.put(subStr, ++count);
            }
            res = Math.max(res, count);
        }
        return res;
    }

    public static void main(String[] args) {
        Code_1297_MaxOccurrenceNum c = new Code_1297_MaxOccurrenceNum();
        System.out.println(c.maxFreq("aababcaab", 2, 3, 4));
        System.out.println(c.maxFreq("aabcabcab", 2, 2, 3));
        System.out.println(c.maxFreq("aaaa", 1, 3, 3));
    }
}