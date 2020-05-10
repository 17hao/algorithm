package leetcode.first;

import java.util.Arrays;

/**
 * 下一个排列
 *
 * @since 2020-5-9 23:28 - 23:49
 */
public class Code_031_NextPermutation {
    static void nextPermutation(int[] nums) {
        int firstIndex = -1, secondIndex = -1, len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                firstIndex = i - 1;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, len - 1);
            return;
        }
        for (int i = len - 1; i > firstIndex; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        if (secondIndex == -1) {
            swap(nums, firstIndex, firstIndex + 1);
        } else {
            swap(nums, firstIndex, secondIndex);
        }
        reverse(nums, firstIndex + 1, len - 1);
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        nextPermutation(a);
        int[] b = new int[]{4, 6, 5};
        nextPermutation(b);
        int[] c = new int[]{2, 4, 1};
        nextPermutation(c);
        int[] d = new int[]{2,2,7,5,4,3,2,2,1};
        nextPermutation(d);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.toString(d));
    }
}
