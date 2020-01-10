package leetcode.first;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * @since 2020-1-9
 */
public class Code_128_LongestConsecutiveSeq {
    static int longestConsecutiveV1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int value : nums) {
            int count = 1;
            int num = value + 1;
            while (set.contains(num)) {
                num += 1;
                count += 1;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    static int longestConsecutiveV2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int res = 0;
        for (int n : nums) {
            int count = 0;
            if (!set.contains(n - 1)) {
                while (set.contains(n)) {
                    count++;
                    n++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutiveV1(new int[]{}));
        System.out.println(longestConsecutiveV1(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveV1(new int[]{100, 4, 5, 1, 3, 2}));
        System.out.println(longestConsecutiveV1(new int[]{100, 200, 1, 2, 4, 5, 6}));
        System.out.println("===");
        System.out.println(longestConsecutiveV2(new int[]{}));
        System.out.println(longestConsecutiveV2(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutiveV2(new int[]{100, 4, 5, 1, 3, 2}));
        System.out.println(longestConsecutiveV2(new int[]{100, 200, 1, 2, 4, 5, 6}));
    }
}
