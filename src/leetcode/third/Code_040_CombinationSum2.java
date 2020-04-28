package leetcode.third;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数2
 *
 * @since 2020-4-27 Monday 21:14
 */
public class Code_040_CombinationSum2 {
    static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, new ArrayList<>(), candidates, target, 0, new boolean[candidates.length]);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> tmp, int[] nums, int target, int index, boolean[] track) {
        if (target == 0 && (!res.contains(tmp))) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if ((target - nums[i]) < 0 || track[i]) continue;
            tmp.add(nums[i]);
            track[i] = true;
            helper(res, tmp, nums, target - nums[i], i, track);
            tmp.remove(tmp.size() - 1);
            track[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 6));
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
