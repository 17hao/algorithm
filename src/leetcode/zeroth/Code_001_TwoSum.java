package leetcode.zeroth;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * @since 2019-12-8 Sunday
 */
public class Code_001_TwoSum {
    static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                result[0] = i;
                result[1] = map.get(complement);
                break;
            }
        }
        return result;
    }

    static int[] twoSumV2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length * 2);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("wrong");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] nums2 = {3, 3};
        System.out.println(Arrays.toString(twoSumV2(nums, 9)));
        System.out.println(Arrays.toString(twoSumV2(nums, 13)));
        System.out.println(Arrays.toString(twoSumV2(nums2, 6)));
    }
}
