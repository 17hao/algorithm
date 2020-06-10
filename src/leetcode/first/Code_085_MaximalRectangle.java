package leetcode.first;

/**
 * 最大矩形
 *
 * @since 2020-6-10 Wednesday 14:17
 */
public class Code_085_MaximalRectangle {
    static int maximalRectangle(char[][] matrix) {
        int len = matrix.length;
        if (len == 0) return 0;

        int res = Integer.MIN_VALUE;
        int[] heights = new int[matrix[0].length];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            res = Math.max(res, _helper(heights));
        }

        return res;
    }

    private static int helper(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;

        int res = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int tmp = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < heights[i])
                    break;
                tmp += heights[i];
            }
            for (int j = i + 1; j < len; j++) {
                if (heights[j] < heights[i])
                    break;
                tmp += heights[i];
            }
            res = Math.max(res, tmp);
        }
        return res;
    }

    private static int _helper(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;

        int[] left = new int[len], right = new int[len];

        for (int i = 0; i < len; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = left[tmp];
            }
            left[i] = tmp;
        }

        for (int i = len - 1; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < len && heights[tmp] >= heights[i]) {
                tmp = right[tmp];
            }
            right[i] = tmp;
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}
