package leetcode.third;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @since 2020-5-4 Monday 21:09 - 21:32
 */
public class Code_016_3SumClosest {
    static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        if (len < 3) return 0;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (Math.abs(tmp - target) < Math.abs(res - target)) {
                    res = tmp;
                } else if (tmp == target) {
                    return tmp;
                } else if (tmp < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 2));
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4, 1, 2, 2, 3, 1, 5, 7, 9, 2, 2, 33, 234, 2, 2, 3, 2, 5}, 100));
    }
}
