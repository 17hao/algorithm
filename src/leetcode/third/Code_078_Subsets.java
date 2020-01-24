package leetcode.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 *
 * @since 2020-1-23 腊月廿九 23:48 下大雨 床上坐得屁股疼
 */
public class Code_078_Subsets {
    List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(res, nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Code_078_Subsets c = new Code_078_Subsets();
        System.out.println(c.subsets(new int[]{1, 2, 3}));
    }
}
