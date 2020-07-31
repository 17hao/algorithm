package leetcode.second;

import java.util.HashSet;
import java.util.Set;

/**
 * 未排序的数组中找到最长的连续序列长度
 * 
 * @since 2020-7-31 Friday 13:38
 */
public class Code_128_LongestConsecutiveSeq {
    static int longestConsecutive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 1;
        while (!set.isEmpty()) {
            int n = set.iterator().next();
            int tmp = n - 1, tempLen = 1;
            while (set.contains(tmp)) {
                set.remove(tmp--);
                tempLen++;
            }
            tmp = n + 1;
            while (set.contains(tmp)) {
                set.remove(tmp++);
                tempLen++;
            }
            set.remove(n);
            res = Math.max(res, tempLen);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2 }));
    }
}