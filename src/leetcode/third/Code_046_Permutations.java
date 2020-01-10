package leetcode.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @since 2020-1-10
 */
public class Code_046_Permutations {
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        backtrack(nums, new LinkedList<>(), res);
        return res;
    }

    static void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int n : nums) {
            if (!track.contains(n)) {
                track.add(n);
                backtrack(nums, track, res);
                track.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute(new int[]{1, 2, 3, 4}));
    }
}
