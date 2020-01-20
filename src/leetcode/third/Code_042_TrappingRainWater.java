package leetcode.third;

/**
 * 接雨水
 *
 * @since 2020-1-20 Monday
 */
public class Code_042_TrappingRainWater {
    static int trap(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int res = 0;
        int[] leftHighest = new int[len];
        int[] rightHighest = new int[len];
        leftHighest[0] = height[0];
        rightHighest[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightHighest[i] = Math.max(rightHighest[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            int temp = Math.min(leftHighest[i], rightHighest[i]);
            if (height[i] < temp) {
                res += (temp - height[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
