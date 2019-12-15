package leetcode.second;

import java.util.Arrays;

/**
 * @since 2019-12-15 Sunday
 */
public class Code_283_MoveZeroes {
    static void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] n1 = {0, 1, 0, 3, 12};
        moveZeroes(n1);
        System.out.println(Arrays.toString(n1));
    }
}
