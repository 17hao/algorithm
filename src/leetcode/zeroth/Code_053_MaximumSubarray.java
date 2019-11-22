package leetcode.zeroth;

/**
 * @author 17hao
 * @date 2019-04-20 15:04
 */
public class Code_053_MaximumSubarray {
    /**
     * 问题的关键在于维护2个值：
     * ①当前位置之前的序列的最大连续子序列最大值
     * ②'当前位置值'和'当前位置之前序列的最大连续子序列之和'的较大值
     */
    private static int maxSubarray(int[] nums) {
        int maxSum, maxNow;
        maxSum = maxNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxNow < 0)
                maxNow = nums[i];
            else
                maxNow += nums[i];
            maxSum = maxSum > maxNow ? maxSum : maxNow;
        }
        return maxSum;
    }

    private static int maxSubarrayV2(int[] nums) {
        int maxSum, maxNow;
        maxSum = maxNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxNow = Math.max(nums[i], maxNow + nums[i]);
            maxSum = Math.max(maxNow, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int res = maxSubarrayV2(nums);
        System.out.println(res);
    }
}
