package leetcode.first;

import java.util.*;

/**
 * 全排列2
 *
 * @since 2020-1-22 Wednesday
 */
public class Code_047_Permutations2 {
    List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(nums, res, new LinkedList<>(), new boolean[nums.length]);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, Deque<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, temp, used);
            temp.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Code_047_Permutations2 c = new Code_047_Permutations2();
        System.out.println(c.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(c.permuteUnique(new int[]{1, 0, 2}));
    }
}
