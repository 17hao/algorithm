package leetcode.fourth;

/**
 * 接雨水
 *
 * @since 2020-4-28 Tuesday 19:19 - 19:49
 */
public class Code_042_TrapRainWater {
    static int trapV1(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int maxL = height[i], maxR = height[i];
            for (int j = 0; j < i; j++) {
                maxL = Math.max(height[j], maxL);
            }
            for (int j = i + 1; j < height.length; j++) {
                maxR = Math.max(height[j], maxR);
            }
            if (height[i] < Math.min(maxL, maxR)) {
                res += (Math.min(maxL, maxR) - height[i]);
            }
        }
        return res;
    }

    /**
     * 状态转换方程: left(1 - len-1): dp[i] = max(dp[i - 1], height[i - 1])
     *             right(0 - len-2): dp[i] = max(dp[i + 1], height[i + 1])
     * base case: dp[1] = height[0], dp[len - 2] = height[len - 1]
     */
    static int trapV2(int[] height) {
        int res = 0, len = height.length;
        if (len < 3) return res;
        int[] ldp = new int[len], rdp = new int[len];
        ldp[1] = height[0];
        rdp[len - 2] = height[len - 1];
        for (int i = 2; i < len; i++) {
            ldp[i] = Math.max(ldp[i - 1], height[i - 1]);
        }
        for (int i = len - 3; i >= 0; i--) {
            rdp[i] = Math.max(rdp[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int tmp = Math.min(ldp[i], rdp[i]);
            if (height[i] < tmp) {
                res += (tmp - height[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trapV1(new int[]{}));
        System.out.println(trapV1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trapV2(new int[]{}));
        System.out.println(trapV2(new int[]{0}));
        System.out.println(trapV2(new int[]{0, 1}));
        System.out.println(trapV2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
