package leetcode.second;

/**
 * 打家劫舍
 * 状态转移方程: dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
 * base case: dp[0] = nums[0], dp[1] = max(nums[0], nums[1])
 *
 * @since 2019-12-23 Monday
 */
public class Code_198_HouseRobber {
    static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }
}
