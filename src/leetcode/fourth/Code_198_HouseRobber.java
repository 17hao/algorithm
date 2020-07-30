package leetcode.fourth;

/**
 * 打家劫舍 
 * 状态方程定义：dp[i][j] 下标为j处的最大收益;i=0表示未偷窃，i=1表示偷窃 
 * 状态方程转移：dp[0][i] = max(dp[1][i - 1],dp[0][i - 1]) dp[1][i] = max(dp[0][i - 1] + nums[i], dp[1][i - 1])
 * 初始化：dp[0][0] = 0 dp[1][0] = nums[0]
 * 返回值：max(dp[0][len - 1], dp[1][len - 1])
 * 
 * @since 2020-7-28 Tuesday 23:16 - 23:30
 */
public class Code_198_HouseRobber {
    static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[2][len];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[0][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[1][i - 1]);
        }
        return Math.max(dp[0][len - 1], dp[1][len - 1]);
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 1, 2, 3, 1 })); // 4
        System.out.println(rob(new int[] { 2, 7, 9, 3, 1 })); // 12
    }
}