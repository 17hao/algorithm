package leetcode.second;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * @since 2019-12-17 Tuesday
 */
public class Code_189_RotateArray {
    void rotate(int[] nums, int k) {
        int realK = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, realK - 1);
        reverse(nums, realK, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4};
        int[] n2 = {1, 2, 3, 4, 5, 6};
        int[] n3 = {1, 2, 3, 4, 5, 6, 7};
        Code_189_RotateArray c = new Code_189_RotateArray();
        c.rotate(n1, 1);
        c.rotate(n2, 3);
        c.rotate(n3, 10);
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
    }
}
