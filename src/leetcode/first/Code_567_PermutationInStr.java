package leetcode.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * permutation in string
 * 
 * @since 2021-2-10 9:55
 */
public class Code_567_PermutationInStr {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.compute(s1.charAt(i), (x, y) -> y == null ? 1 : y + 1);
        }
        int count = 0;
        int p = 0, q = 0; // sliding window [p, q]
        while (q < s2.length()) {
            char qc = s2.charAt(q++);
            map2.compute(qc, (x, y) -> y == null ? 1 : y + 1);
            if (map1.get(qc) != null && map1.get(qc).equals(map2.get(qc))) {
                count++;
            }
            if (count == map1.keySet().size()) {
                return true;
            }
            if (q - p + 1 > s1.length()) {
                char pc = s2.charAt(p);
                if (map1.get(pc) == map2.get(pc)) {
                    count--;
                }
                map2.compute(pc, (x, y) -> y - 1);
                p++;
            }
        }
        return false;
    }

    public boolean _checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (Arrays.equals(map1, map2)) {
                System.out.println(i);
                return true;
            }
            map2[s2.charAt(i - s1.length()) - 'a']--;
            map2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(map1, map2);
    }

    public boolean __checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                map.compute(s1.charAt(j), (x, y) -> y == null ? 1 : y + 1);
            }
            String subStr = s2.substring(i, i + s1.length());
            for (int k = 0; k < subStr.length(); k++) {
                char c = subStr.charAt(k);
                // System.out.println(c);
                if (!map.containsKey(c)) {
                    break;
                }
                map.computeIfPresent(c, (x, y) -> y - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            }
            // System.out.println(map);
            if (map.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String... args) {
        Code_567_PermutationInStr c = new Code_567_PermutationInStr();
        System.out.println(c.checkInclusion("d", "efba"));
        System.out.println(c.checkInclusion("ab", "efba"));
        System.out.println(c.checkInclusion("aba", "efbaa"));
    }
}
