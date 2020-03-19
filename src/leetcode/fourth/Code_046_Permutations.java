package leetcode.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * @since 2020-3-19 23:02
 */
public class Code_046_Permutations {
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        helper(nums, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    private static void helper(int[] nums, List<Integer> temp, boolean[] track, List<List<Integer>> result) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (track[i]) {
                continue;
            }
            track[i] = true;
            temp.add(nums[i]);
            helper(nums, temp, track, result);
            track[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
    }
}
