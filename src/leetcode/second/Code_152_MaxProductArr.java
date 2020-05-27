package leetcode.second;

/**
 * 乘积最大连续子数组
 * 状态方程定义: 维护max和min, 分别是第i个元素当前的最大乘积和最小乘积; 维护res
 * if(nums[i] < 0) swap(max, min) [乘以负数会导致最大的变最小的,最小的变最大的]
 * max = max(nums[i] * max, nums[i]) min = min(nums[i] * min, nums[i])
 *
 * @since 2020-5-27 Wednesday 19:23
 */
public class Code_152_MaxProductArr {
    static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, min = 1, max = 1;
        for (int n : nums) {
            if (n < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(n * max, n);
            min = Math.min(n * min, n);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, 0, 1}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
