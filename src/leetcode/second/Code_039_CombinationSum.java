package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @since 2020-4-19 Sunday 01:30
 */
public class Code_039_CombinationSum {
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 只有排序了才能保证跳过重复元素
        if (candidates.length == 0) return res;
        helper(candidates, res, new ArrayList<>(), target, 0);
        return res;
    }

    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> tmp, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < index) continue;
            if ((target - nums[i]) >= 0) {
                tmp.add(nums[i]);
                helper(nums, res, tmp, target - nums[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 2, 6, 7}, 2));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 8));
    }
}
