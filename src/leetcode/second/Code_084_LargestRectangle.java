package leetcode.second;

/**
 * 柱状图中最大矩阵
 *
 * @since 2020-3-30 Monday 22:57
 */
public class Code_084_LargestRectangle {
    /**
     * 时间复杂度O(n ^ 2)
     */
    static int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int res = heights[0];
        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < len && heights[right] >= heights[i]) {
                right++;
            }
            res = Math.max(res, heights[i] * (right - left - 1));
        }
        return res;
    }

    /**
     * 动态规划. 时间复杂度O(n)
     */
    static int largestRectangleAreaV2(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int[] left = new int[len], right = new int[len];
        left[0] = -1;
        right[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = left[tmp];
            }
            left[i] = tmp;
        }
        for (int i = len - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < len && heights[tmp] >= heights[i]) {
                tmp = right[tmp];
            }
            right[i] = tmp;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea(new int[]{2, 3}));
        System.out.println(largestRectangleArea(new int[]{2}));

        System.out.println(largestRectangleAreaV2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleAreaV2(new int[]{2, 3}));
        System.out.println(largestRectangleAreaV2(new int[]{2}));
    }
}
