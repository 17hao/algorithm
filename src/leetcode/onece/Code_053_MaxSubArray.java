package leetcode.onece;

/**
 * 找出数组中最大的子序列和
 * base case: dp[0] = nums[0];
 * 状态转移:dp[i] = MAX(dp[i - 1] + nums[i], nums[i]); result = MNAX(result, dp[i])
 *
 * @since 11-23 Saturday
 */
public class Code_053_MaxSubArray {
    static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
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
        int[] a = {5, 4, 3, 2, 1};
        int[] b = {1, 2, -5, 2, 3};
        int[] c = {};
        int[] d = {1};
        System.out.println(maxSubArray(a));
        System.out.println(maxSubArray(b));
        System.out.println(maxSubArray(c));
        System.out.println(maxSubArray(d));
    }
}
