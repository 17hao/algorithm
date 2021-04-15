package epoch;

import java.util.Scanner;

/**
 * 最大子序和
 * <p>
 * 算法一：最朴素的算法，对每一个子序求和，时间复杂度O(n^3)
 * 算法二：在算法一中每次计算子序和时，除最后一个元素外的前缀是重复计算，固定左端点，移动右端点，并且记录每次右移右端点时的子序和。时间复杂度O(n^2)
 * 算法三：对算法二进行分析，在固定左端点且右移右端点的过程中，每次计算的子序和与前n-1个元素的子序和有关，所以可以用动态规划解决。时间复杂度O(n),空间复杂度O(n)
 * <p>
 * 状态转移方程：dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i]
 * 初始值：dp[0] = nums[0]
 * 返回结果：dp数组中的最大值
 *
 * @since 2021-4-6 Tuesday 22:40 - 23:08
 * @update 2021-4-13 Tuesday 21:54
 */
public class Problem0053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] strings = scanner.next().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(maxSubArray(nums));
    }

    static int _maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = arraySum(i, j, nums);
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    private static int arraySum(int left, int right, int[] nums) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }
        return sum;
    }

    static int __maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
