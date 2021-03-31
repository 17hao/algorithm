package epoch;

import java.util.*;

/**
 * 子集2，数组中包含重复元素
 *
 * @since 2021-3-31 Wednesday 21:32 - 21:52
 */
public class Problem0090 {
    public static void main(String[] args) {
        Problem0090 p = new Problem0090();
        System.out.println(p.subsetsWithDup(new int[]{1, 1, 2}));
        System.out.println(p.subsetsWithDup(new int[]{1, 2, 3, 1}));
        System.out.println(p.subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        optimizeBacktrace(res, new LinkedList<>(), nums, 0);
        return res;
    }

    private void backtrace(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            return;
        } else {
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                if (!res.contains(list)) {
                    res.add(new ArrayList<>(list));
                }
                backtrace(res, list, nums, i + 1);
                list.remove(list.get(list.size() - 1));
            }
        }
    }

    private void optimizeBacktrace(List<List<Integer>> res, Deque<Integer> tmp, int[] nums, int index) {
        res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            tmp.add(nums[i]);
            optimizeBacktrace(res, tmp, nums, i + 1);
            tmp.removeLast();
        }
    }
}
