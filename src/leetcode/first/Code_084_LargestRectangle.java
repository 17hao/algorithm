package leetcode.first;

/**
 * 柱状图中最大矩形
 *
 * @since 2020-1-14
 */
public class Code_084_LargestRectangle {
    static int largestRectangleAreaV1(int[] heights) {
        int len = heights.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int leftIndex = i;
            int rightIndex = i;
            while (leftIndex >= 0 && heights[leftIndex] >= heights[i]) {
                leftIndex--;
            }
            while (rightIndex < len && heights[rightIndex] >= heights[i]) {
                rightIndex++;
            }
            res = Math.max(res, heights[i] * (rightIndex - leftIndex - 1));
        }
        return res;
    }

    static int largestRectangleAreaV2(int[] heights) {
        int len = heights.length;
        if (len == 0) return 0;
        int res = 0;
        int[] leftIndex = new int[len];
        int[] rightIndex = new int[len];
        leftIndex[0] = -1;
        rightIndex[len - 1] = len;
        for (int i = 1; i < len; i++) {
            int tmp = i - 1;
            while (tmp >= 0 && heights[tmp] >= heights[i]) {
                tmp = leftIndex[tmp];
            }
            leftIndex[i] = tmp;
        }
        for (int i = len - 2; i >= 0; i--) {
            int tmp = i + 1;
            while (tmp < len && heights[tmp] >= heights[i]) {
                tmp = rightIndex[tmp];
            }
            rightIndex[i] = tmp;
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, heights[i] * (rightIndex[i] - leftIndex[i] - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleAreaV1(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleAreaV1(new int[]{2, 1, 3, 6, 2, 3}));
        System.out.println(largestRectangleAreaV1(new int[]{2, 2}));
        System.out.println("===");
        System.out.println(largestRectangleAreaV2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleAreaV2(new int[]{2, 1, 3, 6, 2, 3}));
        System.out.println(largestRectangleAreaV2(new int[]{2, 2}));
    }
}
