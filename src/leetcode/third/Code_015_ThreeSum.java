package leetcode.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @since 2019-12-20 Friday
 */
public class Code_015_ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len < 3) return result;
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[len - 1] < 0) return result;
        for (int i = 0; i < len - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (nums[left] == nums[left + 1] && left < len - 2) ++left;
                    while (nums[right] == nums[right - 1] && right > 1) --right;
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // -4 -1 -1 0 1 2
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }
}
