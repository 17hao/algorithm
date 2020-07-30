package leetcode.second;

/**
 * 打家劫舍2 
 * 首尾相连
 * 1 ~ n-1一组，2 ~ n一组
 * 状态方程定义：dp[i][j]，i为0表示未偷窃，1为偷窃；j为下标为j的收益
 * 状态方程转移：dp[0][j] = max(dp[0][j - 1], dp[1][j - 1]); dp[1][j] = max(dp[0][j-1] + nums[j], dp[1][j - 1])
 * 初始化：dp[0][0] = 0, dp[1][0] = nums[0]
 * 返回值：2组中的较大值
 * 
 * @since 2020-7-30 Thursday 19:49
 */
public class Code_213_HouseRobberII {
    static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] a = new int[len - 1];
        int[] b = new int[len - 1];
        System.arraycopy(nums, 0, a, 0, len - 1);
        System.arraycopy(nums, 1, b, 0, len - 1);
        return Math.max(helper(a), helper(b));
    }

    private static int helper(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1]);
        }
        return Math.max(dp[0][len - 1], dp[1][len - 1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 2, 3, 2 }));
        System.out.println(rob(new int[] { 1, 2, 3, 1 }));
        System.out.println(rob(new int[] { 1 }));
    }
}