package leetcode.third;

/**
 * 柱状图中的最大矩形
 *
 * @since 2020-6-10 Wednesday 10:03
 */
public class Code_084_LargestRectangle {
    static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int tmp = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i])
                    break;
                tmp += heights[i];
            }
            for (int k = i + 1; k < len; k++) {
                if (heights[k] < heights[i])
                    break;
                tmp += heights[i];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 动态规划
     * 定义状态变化: int[] left, int[] right; left[i]:
     * [高度大于等于heights[i]的最左边元素下标 - 1],right: [高度大于等于heights[i]的最左边元素下标 + 1];
     * 状态转移方程: left[tmp] = 当(heights[tmp] > heights[i]) tmp = left[tmp] 不停向左跳跃
     */
    static int _largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0)
            return 0;
        int[] left = new int[len], right = new int[len];

        for (int i = 0; i < len; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = left[tmp];
            }
            left[i] = tmp;
        }
        // System.out.println(Arrays.toString(left));

        for (int i = len - 1; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < len && heights[tmp] >= heights[i]) {
                tmp = right[tmp];
            }
            right[i] = tmp;
        }
        // System.out.println(Arrays.toString(right));

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(heights[i] * (right[i] - left[i] - 1), res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 9, 5, 6, 2, 3 }));
        System.out.println(largestRectangleArea(new int[] { 2, 9, 3, 6, 2, 3 }));
        System.out.println("===");
        System.out.println(_largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
        System.out.println(_largestRectangleArea(new int[] { 2, 9, 5, 6, 2, 3 }));
        System.out.println(_largestRectangleArea(new int[] { 2, 9, 3, 6, 2, 3 }));
    }
}
