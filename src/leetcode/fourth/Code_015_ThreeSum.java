package leetcode.fourth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @since 2020-4-4 Saturday 11:16 - 12:00
 */
public class Code_015_ThreeSum {
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) return res;
        for (int pivot = 0; pivot < len - 2; pivot++) {
            if (pivot > 0 && nums[pivot] == nums[pivot - 1]) continue;
            if (nums[pivot] > 0) break;
            int l = pivot + 1, r = len - 1;
            while (l < r) {
                int sum = nums[pivot] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[pivot], nums[l], nums[r]));
                    do {
                        l++;
                    } while (nums[l] == nums[l - 1] && l < r);
                    do {
                        r--;
                    } while (nums[r] == nums[r + 1] && l < r);
                }
                if (sum < 0) l++;
                if (sum > 0) r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4})); // -4 -1 -1 0 1 2
        System.out.println(threeSum(new int[]{-1, 0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-2, -3, 0, 0, -2})); // -3 -2 -2 0 0
    }
}
