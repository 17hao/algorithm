package leetcode.second;

/**
 * 盛水最多的容器
 *
 * @since 2020-2-24 20:08
 */
public class Code_011_ContainerWithMostWater {
    static public int maxArea(int[] height) {
        int len = height.length;
        int res = 0;
        if (len == 0) return res;
        int left = 0, right = len - 1;
        while (left < right) {
            res = Math.max((right - left) * Math.min(height[right], height[left]), res);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
