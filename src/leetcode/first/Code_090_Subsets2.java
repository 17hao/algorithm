package leetcode.first;

import java.util.*;

/**
 * 子集2
 *
 * @since 2020-1-23
 */
public class Code_090_Subsets2 {
    List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        Arrays.sort(nums);
        backtrack(res, nums, 0, new LinkedList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start, Deque<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(res, nums, i + 1, temp);
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Code_090_Subsets2 c = new Code_090_Subsets2();
        System.out.println(c.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
