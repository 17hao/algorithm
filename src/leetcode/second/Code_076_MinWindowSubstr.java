package leetcode.second;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 时间复杂度O(n)
 * 滑动窗口的思想 大致思路：窗口左侧不动，右侧不断右移，直到将目标字符覆盖，将窗口左侧不断右移，直到目标字符不再被覆盖
 * 
 * @since 2020-80-13 Thursday 16:48 - 17:25
 */
public class Code_076_MinWindowSubstr {
    static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0;
        int l1 = s.length(), l2 = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < l2; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = 0;
        while (right < l1) {
            char cur = s.charAt(right);
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (need.get(cur).compareTo(window.get(cur)) == 0) {
                    count++;
                }
            }
            right++;
            while (count == need.size()) {
                if ((right - left) < minLen) {
                    start = left;
                    end = right;
                    minLen = right - left;
                }
                char c = s.charAt(left);
                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) - 1);
                    if (window.get(c).compareTo(need.get(c)) < 0) {
                        count--;
                    }
                }
                left++;
            }
        }
        System.out.println("start: " + start + " end: " + end);
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("", "ABC"));
        System.out.println(minWindow("ADOBECODEBANC", "AAC"));
        System.out.println(minWindow("ADOBECODEBANC", "ACC"));
    }
}