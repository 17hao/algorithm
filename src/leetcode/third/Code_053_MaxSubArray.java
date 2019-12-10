package leetcode.third;

/**
 * 最大子序列和
 * base case: dp[0] = nums[0]
 * 状态转移方程: dp[i] = Max(dp[i - 1] + nums[i], nums[i]); result = Max(dp[i], result)
 *
 * @since 11-27 Wednesday
 */
public class Code_053_MaxSubArray {
    static int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] n1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] n2 = {};
        System.out.println(maxSubArray(n1));
        System.out.println(maxSubArray(n2));
    }
}
