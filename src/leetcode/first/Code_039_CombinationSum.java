package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 *
 * @since 2020-1-19 Sunday
 */
public class Code_039_CombinationSum {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, ArrayList<Integer> track) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int index = start; index < candidates.length; index++) {
            if (target < candidates[start]) break;
            track.add(candidates[index]);
            backtrack(candidates, target - candidates[index], index, res, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code_039_CombinationSum c = new Code_039_CombinationSum();
        System.out.println(c.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(c.combinationSum(new int[]{2, 3, 5}, 8));
    }
}
