package leetcode.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总数
 * 无重复元素 &　元素可以无限次使用
 * 
 * @since 2020-7-18 Saturday 22:02 - 22:15  
 */
public class Code_039_CombinationSum {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int target, int sum, int index) {
        if (sum == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            dfs(res, tmp, candidates, target, sum + candidates[i], i);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code_039_CombinationSum c = new Code_039_CombinationSum();
        System.out.println(c.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(c.combinationSum(new int[] { 2, 3, 5 }, 8));
    }
}