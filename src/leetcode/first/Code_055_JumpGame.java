package leetcode.first;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 *
 * @since 2019-12-24 Tuesday
 */
public class Code_055_JumpGame {
    static boolean canJump(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > end) return false;
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2}));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 9, 1, 0, 4}));
        System.out.println(canJump(new int[]{3, 0, 6, 0, 4}));
    }
}
