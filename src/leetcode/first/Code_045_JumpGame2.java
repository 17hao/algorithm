package leetcode.first;

/**
 * 跳跃游戏2
 *
 * @since 2020-1-24
 */
public class Code_045_JumpGame2 {
    static int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 1, 1, 3, 4}));
    }
}
