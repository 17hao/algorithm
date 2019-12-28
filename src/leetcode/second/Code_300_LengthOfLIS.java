package leetcode.second;

import java.util.Arrays;

/**
 * 最长上升序列的长度
 * 状态方程定义: dp[i]是nums[i]结尾的数组中最长上升序列的长度
 * 状态转移方程: dp[i] = max(1 + dp[j] e.g. j < i && nums[j] < nums[i];)
 *
 * @since 2019-12-28 Saturday 14:43
 */
public class Code_300_LengthOfLIS {
    static int lengthOfLIST(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIST(new int[]{3, 2, 1, 5, 6, 7}));
        System.out.println(lengthOfLIST(new int[]{3, 2, 4, 5, 6, 7}));
        System.out.println(lengthOfLIST(new int[]{1, 2, 4, 5, 6, 7}));
        System.out.println(lengthOfLIST(new int[]{3, 2, 4, 2, 6, 7}));
        System.out.println(lengthOfLIST(new int[]{3, 6, 4, 2, 6, 7}));
        System.out.println(lengthOfLIST(new int[]{3, 6, 4, 2, 6, 5}));
    }
}
