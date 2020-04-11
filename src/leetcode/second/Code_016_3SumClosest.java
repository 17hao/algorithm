package leetcode.second;

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @since 2020-4-11 Saturday 10:57
 */
public class Code_016_3SumClosest {
    static int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len - 1; i++) {
            int l = i + 1, r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                } else if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 3));
    }
}
