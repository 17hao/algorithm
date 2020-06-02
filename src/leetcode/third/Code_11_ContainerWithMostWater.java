package leetcode.third;

/**
 * 盛水最多的容器
 *
 * @since 2020-6-1 Monday 19:50
 */
public class Code_11_ContainerWithMostWater {
    static int maxArea(int[] height) {
        int len = height.length;
        int res = 0;
        if (len == 0) return res;
        int l = 0, r = len - 1;
        while (l < r) {
            int cap = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, cap);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1}));
    }
}
