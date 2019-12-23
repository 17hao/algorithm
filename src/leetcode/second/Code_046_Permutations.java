package leetcode.second;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @since 2019-12-23 Monday
 */
public class Code_046_Permutations {
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        backtrack(nums, new LinkedList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (!track.contains(num)) {
                track.add(num);
                backtrack(nums, track, result);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code_046_Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Code_046_Permutations().permute(new int[]{2, 3}));
        System.out.println(new Code_046_Permutations().permute(new int[]{}));
    }
}
