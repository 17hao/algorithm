package leetcode.first;

import java.util.Arrays;

/**
 * 给定一个数组, 编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * @since 2019-12-14 Saturday
 */
public class Code_283_MoveZeroes {
    static void moveZeroes(int[] nums) {
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
        int[] n1 = {0, 1, 2, 3, 0, 5};
        int[] n2 = {1, 2, 3, 0, 4};
        int[] n3 = {0, 0, 0, 1, 2};
        moveZeroes(n1);
        moveZeroes(n2);
        moveZeroes(n3);
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n2));
        System.out.println(Arrays.toString(n3));
    }
}
