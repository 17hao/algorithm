package leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @since 2020-6-21 Sunday 12:25
 */
public class Code_076_MinWindowSubstr {
    static String minWindow(String source, String target) {
        Map<Character, Integer> needs = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        while (right < source.length()) {
            char tmp = source.charAt(right);
            if (needs.containsKey(tmp)) {
                window.put(tmp, window.getOrDefault(tmp, 0) + 1);
                if (window.get(tmp).compareTo(needs.get(tmp)) == 0) {
                    count++;
                }
            }
            right++;
            while (count == needs.size()) {
                if ((right - left) < minLen) {
                    start = left;
                    end = right;
                    minLen = right - left;
                }
                char c = source.charAt(left);
                if (needs.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 1) - 1);
                    if (window.get(c) < needs.get(c)) {
                        count--;
                    }
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : source.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("ADOBECODEBAN", "ABCD"));
        System.out.println(minWindow("aa", "aa"));
    }
}
