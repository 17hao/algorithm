package leetcode.second;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 *
 * @since 2019-12-25 Wednesday
 */
public class Code_055_JumpGame {
    static boolean jumpGame(int[] nums) {
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (end < i) {
                return false;
            }
            end = Math.max(i + nums[i], end);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame(new int[]{3, 9, 0, 0, 4}));
        System.out.println(jumpGame(new int[]{3, 0, 1, 1, 4}));
        System.out.println(jumpGame(new int[]{0, 2, 1, 0, 4}));
    }
}
