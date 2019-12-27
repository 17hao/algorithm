package leetcode.first;

import java.util.Arrays;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 子序列不一定是连续的, 只要保证元素顺序一致即可.
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4 [2,3,7,101]
 * 状态方程的定义: dp[i] = 以nums[i]结尾的最长上升序列长度
 * dp[i] = max(1 + dp[j] e.g. j < i && nums[j] < nums[i])
 * dp[0] = 1;
 *
 * @since 2019-12-27 Friday
 */
public class Code_300_LengthOfLIS {
    static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            int curVal = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < curVal) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{}));
        System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS(new int[]{2, 5, 3, 7, 101, 108}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 3}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 3, 2, 1}));
        System.out.println(lengthOfLIS(new int[]{1}));
    }
}
