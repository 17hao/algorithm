package leetcode.third;

/**
 * 最长上升子序列
 * 子序列不必连续出现
 * <p>
 * dp[i]表示第i个元素的最长上升子序列长度
 * dp[i] = if (nums[n] < nums[i]) max(dp[n]) + 1 else 1
 * dp[0] = 1
 *
 * @since 2020-5-18 Monday 15:00 - 16:00
 */
public class Code_300_LIS {
    static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        int res = Integer.MIN_VALUE;
        for (int n : dp) {
            res = Math.max(n, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 1, 2, 3, 4, 5}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 3, 4, 5}));
        System.out.println(lengthOfLIS(new int[]{5, 4, 3, 2, 1}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 2, 7, 1, 2, 4, 1, 1, 2, 11, 1, 2, 41, 1231, 1, 2, 41, 21, 1, 123}));
    }
}