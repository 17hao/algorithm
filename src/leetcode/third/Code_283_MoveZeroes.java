package leetcode.third;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。
 * <p>
 * 本质思路都是找出每个非零元素应该去的索引, 然后直接赋值, 而不是基于交换.
 *
 * @since 2020-1-4 15:14
 */
public class Code_283_MoveZeroes {
    static void moveZeroesV1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    static void moveZeroesV2(int[] nums) {
        int lastNonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }
        for (; lastNonZeroIndex < nums.length; lastNonZeroIndex++) {
            nums[lastNonZeroIndex] = 0;
        }
    }


    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 3, 4};
        int[] b = {1, 1, 0, 2, 3, 4};
        int[] c = {0, 1, 2, 0, 3, 4};
        // moveZeroesV1(a);
        // moveZeroesV1(b);
        // moveZeroesV1(c);
        moveZeroesV2(a);
        moveZeroesV2(b);
        moveZeroesV2(c);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}
