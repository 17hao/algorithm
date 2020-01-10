package leetcode.second;

/**
 * 接雨水
 *
 * @since 2020-1-10 14:06
 */
public class Code_042_TrappingRainWatter {
    static int trapV1(int[] height) {
        int len = height.length;
        if (len == 0) return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]);
            if (temp > height[i]) {
                sum += (temp - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trapV1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapV1(new int[]{2, 0, 2}));
    }
}
