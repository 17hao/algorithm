package leetcode.first;

/**
 * 打家劫舍2
 * 拆分成 0 -> len - 2 && 1 -> len - 1
 *
 * @since 2020-4-20 Monday 21:17
 */
public class Code_213_HouseRobberII {
    static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] a1 = new int[len - 1], a2 = new int[len - 1];
        System.arraycopy(nums, 0, a1, 0, len - 1);
        System.arraycopy(nums, 1, a2, 0, len - 1);
        return Math.max(helper(a1), helper(a2));
    }

    private static int helper(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = dp[1][i - 1];
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1]);
        }
        return len == 1 ? nums[0] : Math.max(dp[1][len - 1], dp[1][len - 2]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2}));
        System.out.println(rob(new int[]{2, 3}));
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }
}
