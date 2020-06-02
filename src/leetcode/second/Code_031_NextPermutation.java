package leetcode.second;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @since 2020-6-2 Tuesday 22:51
 */
public class Code_031_NextPermutation {
    static void nextPermutation(int[] nums) {
        int len = nums.length;
        int l = -1, r = -1;
        if (len <= 1) return;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                l = i - 1;
                break;
            }
        }
        if (l == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[l]) {
                r = i;
                break;
            }
        }
        swap(nums, l, r);
        reverse(nums, l + 1, len - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] m = {2, 3, 1};
        int[] n = {3, 2, 1};
        nextPermutation(m);
        nextPermutation(n);
        System.out.println(Arrays.toString(m));
        System.out.println(Arrays.toString(n));
    }
}
