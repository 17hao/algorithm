package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Code_078_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> t = new ArrayList<>();
            for (List<Integer> l : result) {
                List<Integer> aux = new ArrayList<>(l);
                aux.add(nums[i]);
                t.add(aux);
            }
            result.addAll(t);
        }
        return result;
    }
}
