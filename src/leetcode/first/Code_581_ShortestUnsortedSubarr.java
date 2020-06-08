package leetcode.first;

/**
 * 最短无序连续子数组
 *
 * @since 2020-6-6 Saturday 20:12
 */
public class Code_581_ShortestUnsortedSubarr {
    static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int high = 0, low = len - 1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - 1 - i]);
            if (nums[i] < max) high = i;
            if (nums[len - 1 - i] > min) low = len - 1 - i;
        }

        return high > low ? high - low + 1 : 0;
    }

    public static void main(String... args) {
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 5, 3, 4, 6, 7, 8}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 5, 3, 4, 6, 9, 8}));
        System.out.println(findUnsortedSubarray(new int[]{9, 2, 1, 5, 3, 4, 6, 7, 8}));
    }
}
