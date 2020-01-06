package leetcode.first;

/**
 * 接雨水
 *
 * @since 2020-1-5 Sunday 14:00
 */
public class Code_042_TrappingRainWater {
    /**
     * time complexity O(n ^ 2)
     * space complexity O(1)
     */
    static int trapV1(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = 0; j < i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            int temp = Math.min(maxLeft, maxRight);
            if (temp > height[i]) {
                sum += (temp - height[i]);
            }
        }
        return sum;
    }

    /**
     * 状态转移方程: maxLeft[i]是位于下标i左边墙的最高的墙(不包含自身) maxLeft[i] = max(maxLeft[i - 1], height[i - 1])
     * maxRight[i]是位于下标i右边墙的最高墙
     */
    static int trapV2(int[] height) {
        int res = 0;
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int temp = Math.min(maxLeft[i], maxRight[i]);
            res += (temp > height[i] ? temp - height[i] : 0);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trapV1(a));
        System.out.println(trapV2(a));
    }
}
