package leetcode.third;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * @since 2020-1-1
 */
public class Code_189_RotateArray {
    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        helper(nums, 0, nums.length - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, nums.length - 1);
    }

    static void helper(int[] nums, int start, int end) {
        while (start < end) {
            nums[start] = nums[start] ^ nums[end];
            nums[end] = nums[start] ^ nums[end];
            nums[start] = nums[start++] ^ nums[end--];
        }
    }

    public static void main(String[] args) {
        int[] n1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] n2 = new int[]{-1};
        rotate(n1, 3);
        // rotate(n1, 4);
        System.out.println(Arrays.toString(n1));
        rotate(n2, 2);
        System.out.println(Arrays.toString(n2));
    }
}
