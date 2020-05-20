package leetcode.first;

/**
 * 最大乘积子数组
 *
 * @since 2020-5-11 Monday 9:39
 */
public class Code_152_MaxProductSubarray {
    static int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE, min = 1, max = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min * num, num);
            max = Math.max(max * num, num);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, 2, 3}));
        System.out.println(maxProduct(new int[]{-2, 2, 3, 2}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, 4, -2}));
        System.out.println(maxProduct(new int[]{-2, 0, 1}));
    }
}
