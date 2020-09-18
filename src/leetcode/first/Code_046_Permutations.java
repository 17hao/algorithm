package leetcode.first;

import java.util.*;

/**
 * 全排列
 *
 * @since 2019-12-20 Friday
 */
public class Code_046_Permutations {
    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        // Stack<Integer> path = new Stack<>();
        // boolean[] visited = new boolean[nums.length];
        // backtrack(nums, visited, 0, nums.length, path, result);

        LinkedList<Integer> track = new LinkedList<>();
        backtrackV2(nums, track, result);
        return result;
    }

    @Deprecated
    private void backtrack(int[] nums, boolean[] visited, int curSize,
                     int len, Stack<Integer> path, List<List<Integer>> result) {
        if (curSize == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                path.push(nums[i]);
                visited[i] = true;
                backtrack(nums, visited, curSize + 1, len, path, result);
                path.pop();
                visited[i] = false;
            }
        }
    }

    private void backtrackV2(int[] nums, LinkedList<Integer> track, List<List<Integer>> result) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) continue;
            track.add(num);
            backtrackV2(nums, track, result);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code_046_Permutations().permute(new int[]{1, 2, 3}));
        //System.out.println(new Code_046_Permutations().permute(new int[]{1, 2}));
    }
}
