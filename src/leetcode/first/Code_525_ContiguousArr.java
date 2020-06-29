package leetcode.first;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组（的长度）。
 *
 * @since 2020-6-29 Monday 17:25
 */
public class Code_525_ContiguousArr {
    static public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 0, 1}));
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }
}
