package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和2
 *
 * @since 2020-4-19 Friday 10:25 - 11:00
 */
public class Code_040_CombinationSumII {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates.length == 0) return res;
        else helper(candidates, target, res, new ArrayList<>(), 0, new boolean[candidates.length]);
        return res;
    }

    private static void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> tmp, int index, boolean[] track) {
        if (target == 0 && !res.contains(tmp)) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (track[i]) continue;
            if ((target - nums[i]) >= 0) {
                track[i] = true;
                tmp.add(nums[i]);
                helper(nums, target - nums[i], res, tmp, i, track);
                tmp.remove(tmp.size() - 1);
                track[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 0));
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 1));
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 100));
    }
}
