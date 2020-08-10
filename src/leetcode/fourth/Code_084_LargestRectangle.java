package leetcode.fourth;

import java.util.Arrays;

/**
 * 柱状图中的最大矩形
 * 
 * @since 2020-8-7 Friday 14:27 - 14:36
 * @update 2020-8-10 Monday 15:50
 */
public class Code_084_LargestRectangle {
    /**
     * 时间复杂度: O(n ^ 2)
     */
    static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            int tmpRes = 0;
            if (heights[i] == 0) {
                res = Math.max(tmpRes, res);
                tmpRes = 0;
                continue;
            } else {
                int tmpI = i;
                while (tmpI < heights.length && heights[tmpI] != 0) {
                    min = Math.min(min, heights[tmpI]);
                    tmpI++;
                    tmpRes = Math.max(tmpRes, (tmpI - i) * min);
                }
                res = Math.max(res, tmpRes);
            }
        }
        return res;
    }

    /**
     * 动态规划 15:50 - 16:15
     * 时间复杂度0(n ^ 2)
     */
    static int _largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (heights == null || len == 0) return 0;
        int[] l = new int[len], r = new int[len];
        l[0] = 0;
        r[len - 1] = 0;
        for (int i = 1; i < len; i++) {
            int tmpIndex = i - 1;
            while (tmpIndex >= 0 && heights[tmpIndex] >= heights[i]) {
                tmpIndex = tmpIndex - l[tmpIndex] - 1;
            }
            l[i] = i - tmpIndex - 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            int tmpIndex = i + 1;
            while (tmpIndex < len && heights[tmpIndex] >= heights[i]) {
                tmpIndex = tmpIndex + r[tmpIndex] + 1;
            }
            r[i] = tmpIndex - i - 1;
        }
        System.out.println("l: " + Arrays.toString(l));
        System.out.println("r: " + Arrays.toString(r));
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (l[i] + r[i] + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })); // 10
        System.out.println(largestRectangleArea(new int[] { 2, 1, 7, 6, 2, 3 })); // 12
        System.out.println(largestRectangleArea(new int[] { 4, 2, 0, 3, 2, 4, 3, 4 })); // 10
        System.out.println("===");
        System.out.println(_largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 })); // 10
        System.out.println(_largestRectangleArea(new int[] { 2, 1, 7, 6, 2, 3 })); // 12
        System.out.println(_largestRectangleArea(new int[] { 4, 2, 0, 3, 2, 4, 3, 4 })); // 10
    }
}