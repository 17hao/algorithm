package leetcode.second;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列2(可能包含重复元素)
 * 回溯 + 剪枝
 *
 * @since 2020-3-22 Sunday 10:38
 */
public class Code_047_Permutations2 {
    static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length == 0)
            return result;
        helper(nums, new boolean[nums.length], new LinkedList<>(), result);
        return result;
    }

    private static void helper(int[] nums, boolean[] track, LinkedList<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && track[i - 1]) {
                continue;
            }
            if (track[i]) {
                continue;
            }
            temp.add(nums[i]);
            track[i] = true;
            helper(nums, track, temp, result);
            track[i] = false;
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 2, 2}));
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
        System.out.println(permuteUnique(new int[]{1, 1, 1}));
    }
}
