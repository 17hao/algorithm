package leetcode.second;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 和17题相似
 *
 * @since 2019-12-20 Friday
 */
public class Code_078_SubSets {
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> temp = new ArrayList<>();
            for (List<Integer> l : result) {
                List<Integer> aux = new ArrayList<>(l);
                aux.add(num);
                temp.add(aux);
            }
            result.addAll(temp);
        }
        return result;
    }

    private List<List<Integer>> result;

    List<List<Integer>> subsetsV2(int[] nums) {
        List<Integer> l = new ArrayList<>();
        result = new ArrayList<>();
        backtrack(nums, 0, l);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> set) {
        result.add(new ArrayList<>(set));
        for (int i = index; i < nums.length; i++) {
            set.add(nums[i]);
            backtrack(nums, i + 1, set);
            set.remove(set.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code_078_SubSets().subsets(new int[]{1, 2, 3}));
        System.out.println(new Code_078_SubSets().subsetsV2(new int[]{1, 2, 3}));
    }
}
