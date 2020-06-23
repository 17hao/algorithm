package leetcode.first;

/**
 * 长度最小的子数组
 *
 * @since 2020-6-22 Monday 19:36
 */
public class Code_209_MinSizeSubarrSum {
    static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (left < right && sum >= s) {
                minLen = Math.min(right - left, minLen);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(0, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(100, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
