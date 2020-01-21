package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总数2
 *
 * @since 2020-1-21 Tuesday
 */
public class Code_040_CombinationSum2 {
    List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> track, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            track.add(candidates[i]);
            backtrack(res, track, candidates, target - candidates[i], i + 1);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code_040_CombinationSum2 c = new Code_040_CombinationSum2();
        System.out.println(c.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(c.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
