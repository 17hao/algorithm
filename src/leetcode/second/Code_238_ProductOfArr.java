package leetcode.second;

import java.util.Arrays;

/**
 * 数组除自己外的元素的乘积
 *
 * @since 2020-6-24 Wednesday 13:42
 */
public class Code_238_ProductOfArr {
    static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int left = 1, right = 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{4, 3, 2, 1})));
    }
}
